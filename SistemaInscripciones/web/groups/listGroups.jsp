<%@ page import="group.Group" %>
<%@ include file="/header.jsp" %>
        <h1>Lista de Grupos</h1>
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Idioma</th>
                <th>Clave</th>
                <th>Sal&oacute;n</th>
                <th>Hornors</th>
                <th>Acci&oacute;n</th>
            </tr>
        </table>
        <br>
        <a href="reportGroup.jsp">Reporte por grupos</a>
        <br>
        <button conclick="goBack()">Index</button>
<%@ include file="/footer.jsp" %>
