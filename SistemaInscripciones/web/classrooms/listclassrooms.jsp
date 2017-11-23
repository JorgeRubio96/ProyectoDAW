<%-- 
    Document   : listclassrooms
    Created on : 21-nov-2017, 0:47:26
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
            <h1>Classroom List</h1>
            <a href="/SistemaInscripciones">Inicio</a>
            <a href="/SistemaInscripciones/editAddClassroom.jsp">Agregar</a>
            <div class="table-responsive-vertical shadow-z-1">
                <table id="table" class="table table-hover table-mc-light-blue">
                <thead>
                <tr>
                    <th>Classroom</th>
                    <th>Building</th>
                    <th>Room</th>
                </tr>
                </thead>
                <tbody>
                <%
                    InitialContext initContext = new InitialContext();
                    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");
                    ClassroomStore store = new ClassroomStore(ds.getConnection());
                    List<Classroom> salones = store.getAll();
                    for (Classroom salon : salones) {
                %>
                <tr>
                    <td data-title="code"><%=salon.getCode()%></td>
                    <td data-title="build"><%=salon.getBuilding()%></td>
                    <td data-title="number"><%=salon.getNumber()%></td>
                </tr>
                <%}%>
                </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

