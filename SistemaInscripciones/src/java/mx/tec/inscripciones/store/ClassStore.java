package mx.tec.inscripciones.store;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import mx.tec.inscripciones.model.Class;
import mx.tec.inscripciones.model.TimeSlot;

public class ClassStore extends BaseStore<Class> {
    private static final String TABLE = "class";
    private final PreparedStatement subStmt, oSubStmt;
    
    public ClassStore(Connection dbc) throws SQLException {
        super(dbc, TABLE);
        
        String sql = "SELECT * FROM schedule WHERE class_id = ?";
        subStmt = getDatabase().prepareStatement(sql);
        sql = "INSERT INTO schedule(class_id, classroom_id, day, begin_time, end_time) VALUES (?, ?, ?, ?, ?)";
        oSubStmt = getDatabase().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    @Override
    public boolean add(Class aClass) throws SQLException {
        String sql = "INSERT INTO " + TABLE + "(course_id, teacher_id, group_number) VALUES (?, ?, ?)";
        PreparedStatement stmt = getDatabase().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, aClass.getCourseId());
        stmt.setInt(2, aClass.getTeacherId());
        stmt.setInt(3, aClass.getGroupNumber());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
                aClass.setId(rs.getInt(1));
        }        
        for (TimeSlot time : aClass.getTimes()) {
            oSubStmt.setInt(1, aClass.getId());
            oSubStmt.setInt(2, time.getClassroomId());
            oSubStmt.setString(3, time.getDay());
            oSubStmt.setTime(4, time.getStartTime());
            oSubStmt.setTime(5, time.getEndTime());
            oSubStmt.executeUpdate();         
            ResultSet ms = oSubStmt.getGeneratedKeys();
            if(ms.next()) {
                time.setId(ms.getInt(1));
            }
        }
        if(rs.next()) {
            return true;
        }        
        return false;
    }

    @Override
    public int delete(List<Integer> ids) throws SQLException {
        String sql = "DELETE FROM " + TABLE + " WHERE id = ?";
        int deleted = 0;
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql);

        for(Integer id: ids) {
            stmt.setInt(1, id);
            deleted += stmt.executeUpdate();
        }

        return deleted;
    }
    
    @Override
    protected Class makeBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int courseId = rs.getInt("course_id");
        int teacherId = rs.getInt("teacher_id");
        int groupNumber = rs.getInt("group_number");
        
        ArrayList<TimeSlot> times = new ArrayList();

        subStmt.setInt(1, id);
        ResultSet subRs = subStmt.executeQuery();
       
        while(subRs.next()) {
            int timeSlotId = subRs.getInt("id");
            int classroomId = subRs.getInt("classroom_id");
            String day = subRs.getString("day");
            Time beginTime = subRs.getTime("begin_time");
            Time endTime = subRs.getTime("end_time");
            
            times.add(new TimeSlot(timeSlotId, beginTime, endTime, day, classroomId));
        }
        
        return new Class(id, courseId, teacherId, groupNumber, times);
    }
}
