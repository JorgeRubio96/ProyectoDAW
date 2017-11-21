<%@ include file="/header.jsp" %>
<h1>Reporte de grupos por materia</h1>
        <br>
        <form id="formReport">
            Seleccione materia: <select id="materia" name="materia" onchange="showGroup(this.value)" placeholder="Seleccione un valor">
                <option></option>
                <option>Valor</option>
            </select>
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
        </form>
        <br>
        <button conclick="goBack()">Index</button>
<%@ include file="/footer.jsp" %>
