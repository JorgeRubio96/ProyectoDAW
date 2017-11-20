package Groups;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarEnBD {
     Connection db;

    public BuscarEnBD() throws SQLException {
        db = DriverManager.getConnection("jdbc:mysql://localhost/administrador?user=root");
    }

    public boolean Groups(Group g) throws SQLException {
        PreparedStatement stmt = db.prepareStatement("SELECT * FROM grupos WHERE materia = ? AND profesor = ? AND"
                + " cantidadAlumno = ? AND horario = ?");

        stmt.setString(1, g.getMateria());
        stmt.setString(2, g.getProfesor());
        stmt.setInt(3, g.getCantidadAlumnos());
        stmt.setDate(4, g.getHorario());

        ResultSet res = stmt.executeQuery();

        return res.next();
    }
}
