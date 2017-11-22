<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@include file="/header.jsp" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Time"%>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%
    
    Connection databaseConnection;
    InitialContext initContext = new InitialContext();
    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");

    databaseConnection = ds.getConnection();
    try {
        databaseConnection = ds.getConnection();
    } catch(Exception e) {
        getServletContext().log("", e);
    }
    String classID = request.getParameter("calssId");
    String sql = "SELECT t.nomina as nomina, t.first_name as fname, t.last_name as lname, "
            + "co.title as materia, s.day as dia, s.start_time inicio, "
            + "s.end_time as fin,  FROM class c, course co, teacher t, classroom cl,"
            + " schedule s "
            + "WHERE t.id IN (SELECT z.teacher_id FROM class z)" ;
    PreparedStatement stmt = databaseConnection.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Profesores ocupados</h1>
<br>
<table>
    <tr>
        <td>Apellido</td>
        <td>Nombre</td>
        <td>N&oacute;mina</td>
        <td>Materia</td>
        <td>D&iacute;a</td>
        <td>Horario inicio</td>
        <td>Horario fin</td>
    </tr>
    <%
        while(rs.next())
        {
    %>
    <tr>
        <td>><%= rs.getString("lname")%></td>
        <td>><%= rs.getString("fname")%></td>
        <td>><%= rs.getString("nomina")%></td>
        <td>><%= rs.getString("materia")%></td>
        <td>><%= rs.getString("dia")%></td>
        <td>><%= rs.getString("inicio")%></td>
        <td>><%= rs.getString("fin")%></td>
    </tr>
    <%
        }
    %>
</table>
<button onclick="goBack()">Regresar</button>
<%@ include file="/footer.jsp" %>
