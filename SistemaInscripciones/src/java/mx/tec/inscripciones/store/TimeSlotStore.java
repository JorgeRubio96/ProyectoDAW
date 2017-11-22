/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.store;
import mx.tec.inscripciones.model.TimeSlot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class TimeSlotStore extends BaseStore<TimeSlot> {
    private static final String TABLE = "schedule";
    
    public TimeSlotStore(Connection dbc) {
        super(dbc, TABLE);
    }

    @Override
    public boolean add(TimeSlot time) throws SQLException {
        String sql = "INSERT INTO " + TABLE + "(start_time, end_time, day, classroom_id) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setTime(1, time.getStartTime());
        stmt.setTime(2, time.getEndTime());
        stmt.setString(3, time.getDay());
        stmt.setInt(3, time.getClassroomId());  
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if(rs.next()) {
            time.setId(rs.getInt(1));
            return true;
        }
        
        return false;
    }

    @Override
    public boolean update(TimeSlot time) {
        return false;
    }
    
    @Override
    protected TimeSlot makeBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Time start_time = rs.getTime("start_time");
        Time end_time = rs.getTime("end_time");
        String day = rs.getString("day");
        int classroom = rs.getInt("clasroom_id");
        return new TimeSlot(id, start_time, end_time, day, classroom);
    }
}
