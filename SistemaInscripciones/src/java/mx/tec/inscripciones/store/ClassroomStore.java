package mx.tec.inscripciones.store;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.tec.inscripciones.model.Classroom;

public class ClassroomStore extends BaseStore<Classroom> {
    private static final String TABLE = "classroom";
    
    public ClassroomStore(Connection dbc) {
        super(dbc, TABLE);
    }
    
    public List<Classroom> getUnused() throws SQLException {
        ArrayList unused = new ArrayList();
        
        String sql = "SELECT * FROM " + TABLE
            + " WHERE id NOT IN (SELECT classroom_id FROM class)";

        Statement stmt = getDatabase().createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            unused.add(makeBean(rs));
        }
        
        return unused;
    }

    @Override
    public boolean add(Classroom classroom) throws SQLException {
        String sql = "INSERT INTO " + TABLE + "(code, building, room) VALUES (?, ?, ?)";
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, classroom.getCode());
        stmt.setString(2, classroom.getBuilding());
        stmt.setInt(3, classroom.getNumber());
        
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if(rs.next()) {
            classroom.setId(rs.getInt(1));
            return true;
        }
        
        return false;
    }
    
    @Override
    protected Classroom makeBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String code = rs.getString("code");
        String building = rs.getString("building");
        int number = rs.getInt("room");
        
        return new Classroom(id, code, building, number);
    }
}
