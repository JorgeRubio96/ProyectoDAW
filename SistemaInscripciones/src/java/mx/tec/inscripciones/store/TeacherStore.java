package mx.tec.inscripciones.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.tec.inscripciones.model.Teacher;

public class TeacherStore extends BaseStore<Teacher> {
    private static final String TABLE = "teacher";
    
    public TeacherStore(Connection dbc) {
        super(dbc, TABLE);
    }

    @Override
    public boolean add(Teacher user) throws SQLException {
        String sql = "INSERT INTO " + TABLE + "(nomina, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, user.getNomina());
        stmt.setString(2, user.getFirstName());
        stmt.setString(3, user.getLastName());
        stmt.setString(4, user.getEmail());
        
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if(rs.next()) {
            user.setId(rs.getInt(1));
            return true;
        }
        
        return false;
    }
    
    @Override
    protected Teacher makeBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nomina = rs.getString("nomina");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        
        return new Teacher(id, nomina, firstName, lastName, email);
    }
}
