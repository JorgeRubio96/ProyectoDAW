package mx.tec.inscripciones.store;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
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

    public List<T> getAll(int n, int offset) throws SQLException {
        ArrayList<T> list = new ArrayList<>(n);

        Statement stmt = dbc.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT " + offset + "," + n);

        while(rs.next()) {
            list.add(makeBean(rs));
        }

        return list;
    }

    protected Connection getDatabase() {
        return dbc;
    }

    public abstract boolean add(T user) throws SQLException;
    
    protected abstract T makeBean(ResultSet rs) throws SQLException;
}
