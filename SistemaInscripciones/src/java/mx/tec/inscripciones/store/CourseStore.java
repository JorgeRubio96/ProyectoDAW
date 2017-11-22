/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tec.inscripciones.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mx.tec.inscripciones.model.Course;

/**
 *
 * @author inspiron
 */
public class CourseStore extends BaseStore<Course> {
    private static final String TABLE = "course";
    
    public CourseStore(Connection dbc) {
        super(dbc, TABLE);
    }

    @Override
    public boolean add(Course course) throws SQLException {
        String sql = "INSERT INTO " + course + "(code, title,  dependency_id, honors) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, course.getCode());
        stmt.setString(2, course.getTitle());
        stmt.setInt(3, course.getDepend());
        stmt.setInt(4, course.getHonors()?1:0);
        
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if(rs.next()) {
            course.setId(rs.getInt(1));
            return true;
        }
        
        return false;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }
    
    @Override
    protected Course makeBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String code = rs.getString("code");
        String title = rs.getString("title");
        int dependId = rs.getInt("dependency_id");
        boolean honors = rs.getInt("honors") != 0;
        return new Course(id, code, title, dependId, honors);
    }
}
