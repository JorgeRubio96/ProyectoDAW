<%@ include file="/header.jsp" %>
        <h1>Lista de Grupos</h1>
        <a href="createGroup.jsp">Crear grupo</a>
        <table id="groups">
            <tr>
                <th>Materia</th>
                <th>N&uacute;mero</th>
                <th>Profesor</th>
                <th>Horario</th>
                <th>Idioma</th>
                <th>Sal&oacute;n</th>
                <th>Hornors</th>
                <th>Acci&oacute;n</th>
            </tr>
        </table>
        <br>
        <a href="reportGroup.jsp">Reporte por grupos</a>
        <br>
        <button onclick="goBack()">Index</button>
<%@ include file="/footer.jsp" %>
