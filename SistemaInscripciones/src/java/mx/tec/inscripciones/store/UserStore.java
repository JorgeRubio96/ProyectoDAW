package mx.tec.inscripciones.store;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import mx.tec.inscripciones.PasswordStorage;
import mx.tec.inscripciones.model.User;

public class UserStore {
    private final String TABLE = "user";
    private final Connection dbc;
    
    public UserStore(Connection dbc) {
        this.dbc = dbc;
    }
    
    public User get(int id) throws SQLException {
        Statement stmt = dbc.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE id = " + id);
        if(rs.next()) {
            return makeUser(rs);
        }

        return null;
    }

    public List<User> getAll(int n, int offset) throws SQLException {
        ArrayList<User> list = new ArrayList<>(n);

        Statement stmt = dbc.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " LIMIT " + offset + "," + n);

        while(rs.next()) {
            list.add(makeUser(rs));
        }

        return list;
    }

    public boolean add(User user) throws SQLException {
        String sql = "INSERT INTO " + TABLE + "(first_name, last_name, username, pass) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = dbc.prepareStatement(sql);
        
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getPassword());
        
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        if(rs.next()) {
            user.setId(rs.getInt(1));
            return true;
        }
        
        return false;
    }
    
    public User login(String username, String password) throws 
            SQLException, 
            PasswordStorage.InvalidHashException,
            PasswordStorage.CannotPerformOperationException {
        String sql = "SELECT * FROM " + TABLE + " WHERE username = ?";
        PreparedStatement stmt = dbc.prepareStatement(sql);
        stmt.setString(1, username);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            int id = rs.getInt("id");
            String hash = rs.getString("pass");
            
            if(PasswordStorage.verifyPassword(password, hash)) {
                return makeUser(rs);
            }
        }
        
        return null;
    }
    
    private User makeUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String username = rs.getString("username");
        String password = rs.getString("pass");
        
        return new User(id, firstName, lastName, username, password);
    }
}
