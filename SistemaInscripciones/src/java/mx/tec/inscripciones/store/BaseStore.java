package mx.tec.inscripciones.store;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public abstract class BaseStore<T> {
    private final String table;
    private final Connection dbc;
    
    public BaseStore(Connection dbc, String table) {
        this.dbc = dbc;
        this.table = table;
    }
    
    public T get(int id) throws SQLException {
        Statement stmt = dbc.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE id = " + id);
        if(rs.next()) {
            return makeBean(rs);
        }

        return null;
    }
    
    public List<T> getAll() throws SQLException {
        List<T> list = new ArrayList();
        Statement stmt = dbc.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
        while(rs.next()) {
            list.add(makeBean(rs));
        }
        return list;
    }

    public List<T> getAll(int n, int offset) throws SQLException {
        ArrayList<T> list = new ArrayList<>(n);

        Statement stmt = dbc.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT " + offset + ", " + n);

        while(rs.next()) {
            list.add(makeBean(rs));
        }

        return list;
    }

    public List<T> getWhereEquals(String col, Object val) throws SQLException {
        String sql = "SELECT * FROM " + table + " WHERE " + col +"= ?";
        ArrayList<T> list = new ArrayList<>();


        PreparedStatement stmt = getDatabase().prepareStatement(sql);
        stmt.setString(1, val.toString());

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            list.add(makeBean(rs));
        }

        return list;
    }

    public int delete(List<Integer> ids) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        int deleted = 0;
        
        PreparedStatement stmt = getDatabase().prepareStatement(sql);

        for(Integer id: ids) {
            stmt.setInt(1, id);
            deleted += stmt.executeUpdate();
        }

        return deleted;
    }
    
    protected Connection getDatabase() {
        return dbc;
    }

    public abstract boolean add(T bean) throws SQLException;
    public abstract boolean update(T bean) throws SQLException;
    
    protected abstract T makeBean(ResultSet rs) throws SQLException;
}
