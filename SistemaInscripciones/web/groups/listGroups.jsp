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
        <a href="editAddGroup.jsp">Crear grupo</a>
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero de grupo</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Sal&oacute;n</th>
                <th>Acci&oacute;n</th>
            </tr>
            <%
                InitialContext initContext = new InitialContext();
                DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");
                Connection databaseConnection = ds.getConnection();
                String sql = "SELECT course.title as materia, class.group_number as numero, "
                        + "schedule.day as dia, schedule.begin_time as inicio, schedule.end_time as fin, course.code as code,"
                        + "classroom.building as building, class.id as ID, "
                        + "teacher.first_name as fName, teacher.last_name as lName "
                        + "FROM class, course, teacher, classroom, "
                        + "schedule WHERE class.course_id = course.id AND "
                        + "schedule.class_id = class.id AND "
                        + "schedule.classroom_id = classroom.id";
                
                PreparedStatement stmt = databaseConnection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
            %>
            <tr>
                <td><a href="editGroup.jsp"><input type="hidden" value="<%=rs.getString("ID")%>"><%= rs.getString("materia")%></a></td>
                <td><%= rs.getString("numero")%></td>
                <td><%= rs.getString("fName") + " " + rs.getString("lName")%></td>
                <td><%= rs.getString("dia") + " " + rs.getString("inicio") + "-" + rs.getString("fin")%></td>
                <td><%= rs.getString("code")%></td>
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
