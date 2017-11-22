<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Time"%>
<%@ include file="/header.jsp" %>
        <h1>Lista de Grupos</h1>
        <a href="createGroup.jsp">Crear grupo</a>
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Sal&oacute;n</th>
                <th>Hornors</th>
                <th>Acci&oacute;n</th>
            </tr>
            <%
                Connection databaseConnection;
                    InitialContext initContext = new InitialContext();
                    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");

                    databaseConnection = ds.getConnection();

                String sql = "SELECT co.title as materia, c.group_number as numero"
                        + ",s.day as dia, s.start_time as inicio, cl.code as code,"
                        + " cl.building as building, co.honors as honors, t.first_name as fname, "
                        + "t.last_name as lname, c.id as ID "
                        + "FROM class c, course co, teacher t, classroom cl,"
                        + "schedule s "
                        + "WHERE c.course_id = co.id AND "
                        + "c.teacher_id = t.id AND "
                        + "s.class_id = c.id AND "
                        + "s.classroom_id = cl.id";
                
                PreparedStatement stmt = databaseConnection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
            %>
            <tr>
                <td><a href="editGroup.jsp"><input type="hidden" value="<%=rs.getString("ID")%>"><%= rs.getString("materia")%></a></td>
                <td><%= rs.getString("numero")%></td>
                <td><%= rs.getString("fname" + "lname")%></td>
                <td><%= rs.getString("dia" + "inicio")%></td>
                <td><%= rs.getString("code" + "building")%></td>
                <td><%= rs.getString("honors")%></td>
                <td><a onclick="borrar()">borrar</a></td>
            </tr>
            <%
                } 
            %>
        </table>
        <br>
        <a href="reportGroup.jsp">Reporte por grupos</a>
        <br>
        <button onclick="goBack()">Index</button>
<%@ include file="/footer.jsp" %>
