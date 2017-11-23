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
                    String sql = "SELECT co.title as materia, c.group_number as numero"
                        + ",s.day as dia, s.start_time as inicio, cl.code as code,"
                        + " cl.building as building, co.honors as honors, t.first_name as fname, "
                        + "t.last_name as lname, c.id as ID "
                        + "FROM class c, course co, teacher t, classroom cl,"
                        + "schedule s "
                        + "WHERE c.course_id = '"+ classID +"' AND "
                        + "c.teacher_id = t.id AND "
                        + "s.class_id = c.id AND "
                        + "s.classroom_id = cl.id";
                    PreparedStatement stmt = databaseConnection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();

                    if(rs.next()) {
%>
<h1>Reporte de grupos de <%=rs.getString("materia") %></h1>
        <br>
        <form id="formReport">
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Sal&oacute;n</th>
                <th>Hornors</th>
            </tr>
            <%
                while(rs.next())
                {
            %>
            <tr>
                <td><%= rs.getString("materia")%></td>
                <td><%= rs.getString("numero")%></td>
                <td><%= rs.getString("lname")%></td>
                <td><%= rs.getString("dia")%></td>
                <td><%=rs.getString("building")%></td>
                <td><%=rs.getString("honors")%></td>
            </tr>
            <%
                }
            %>
        </table>
        </form>
        <br>
<% } %>
        <button onclick="goBack()">Regresar</button>
<%@ include file="/footer.jsp" %>
