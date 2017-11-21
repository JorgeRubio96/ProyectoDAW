<%-- 
    Document   : listclassrooms
    Created on : 21-nov-2017, 0:47:26
    Author     : inspiron
--%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="models.*" %>

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
        <div class="table-responsive-vertical shadow-z-1">
            <table id="table" class="table table-hover table-mc-light-blue">
            <thead>
            <tr>
                <th>Classroom</th>
                <th>Building</th>
                <th>Room Number</th>
            </tr>
            </thead>
            <tbody>
            <%List<Classroom> salones= DBmethods.allSalones();
            for (Iterator<Classroom> itr = salones.iterator(); itr.hasNext(); )
            {
            %>
            <tr>
                <td data-title="code"><%=itr.next().getCode()%></td>
                <td data-title="build"><%=itr.next().getBuilding()%></td>
                <td data-title="number"><%=itr.next().getNumber()%></td>
            </tr>
            <%}%>
            </tbody>
            </table>
        </div>
        </div>
    </body>
</html>

