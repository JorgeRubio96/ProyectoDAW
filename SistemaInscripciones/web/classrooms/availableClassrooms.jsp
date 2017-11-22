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
    String sql = "SELECT cl.code as codigo, cl.building as building, "
            + "cl.room as salon, cl.capacity as capacidad, cl.admin as admin "
            + "FROM classroom cl "
            + "WHERE cl.id NOT IN (SELECT s.classroom_id FROM schedule s)";
    PreparedStatement stmt = databaseConnection.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Salones Disponibles</h1>
<br>
<table>
    <tr>
        <td>Edificio</td>
        <td>C&oacute;digo</td>
        <td>Sal&oacute;n</td>
        <td>Capacidad</td>
        <td>Administrador</td>
    </tr>
    <%
        while(rs.next())
        {
    %>
    <tr>
        <td>><%= rs.getString("building")%></td>
        <td>><%= rs.getString("codigo")%></td>
        <td>><%= rs.getString("salon")%></td>
        <td>><%= rs.getString("capacidad")%></td>
        <td>><%= rs.getString("admin")%></td>
    </tr>
    <%
        }
    %>
</table>
<button onclick="goBack()">Regresar</button>
<%@ include file="/footer.jsp" %>
