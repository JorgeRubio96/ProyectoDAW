<%@ page import="group.Group" %>
<%@ include file="/header.jsp" %>
        <h1>Lista de Grupos</h1>
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Cantidad de alumnos</th>
            </tr>
        </table>
        <br>
        <button conclick="goBack()">Index</button>
<%@ include file="/footer.jsp" %>
