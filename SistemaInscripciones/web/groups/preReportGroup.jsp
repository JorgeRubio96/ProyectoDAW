<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Time"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>

<h1>Reporte de grupos por materia</h1>
        <br>
        <form id="formReport" action="reportGroupServlet" method="GET">
            Seleccione materia: 
            <select id="materia" name="materia" onchange="showGroup(this.value)">
                <option></option>
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
                    
                    String sql = "SELECT * FROM course";
                    PreparedStatement stmt = databaseConnection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();
                    while(rs.next()) 
                    {
                        int id = rs.getInt("id");
                        String title = rs.getString("title");

                            %>
                            <option value='<%= id%>'><%= title%></option>
                            <%
                    }
                %>
            </select>
            <input type="submit" value="Mostrar">
        </form>
        <br>
        <button onclick="goBack()">Regresar</button>
<%@ include file="/footer.jsp" %>
