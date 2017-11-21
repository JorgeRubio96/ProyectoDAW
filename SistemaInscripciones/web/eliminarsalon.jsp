<%-- 
    Document   : eliminarsalon
    Created on : 20-nov-2017, 0:50:11
    Author     : inspiron
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="mx.tec.inscripciones.model.Classroom" %>
<%@ page import="mx.tec.inscripciones.store.ClassroomStore" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Salones</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="tablabonis.css">
    </head> 
    <body>
        <div id="demo" style="max-width:500px;">
            <h1>Lista de Salones</h1>
            <h2>Estos son los salones que puedes eliminar, ya que no están ligados a ningún grupo.</h2>

        <div class="table-responsive-vertical shadow-z-1">
            <form action="delete">
            <table id="table" class="table table-hover table-mc-light-blue">
            <thead>
            <tr>
                <th>Salon</th>
                <th>Eliminar</th>
            </tr>
            </thead>
            <tbody>
            <%
                InitialContext initContext = new InitialContext();
                DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");
                ClassroomStore store = new ClassroomStore(ds.getConnection());
                List<Classroom> salones = store.getAll(50, 0);
                for (Classroom classroom : salones) {
            %>
            <tr>
                <td data-title="Nombre"><%=classroom.getCode()%></td>
                <td data-title="casilla"><input name="selected" type="checkbox" value="<%=classroom.getId()%>"></td> 
            </tr>
            <%}%>
            </tbody>
            </table>
            <input type="submit" value="Delete">
            </form>
        </div>
        </div>
    </body>
</html>

