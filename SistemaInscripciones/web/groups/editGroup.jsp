<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Editar grupo
</h1>
<p>Aqu&iacute; esta la informaci&oacuten del grupo:</p>
<%@page import="group.Group" %>
<% Group group = (Group) request.getAttribute("group"); %>
<form name="editGroup" id="editGroup" action="UpdateToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <table>
        <tr>
            <td>Clave:</td>
            <td><input type="text" name="clave" id="clave" required></td>
        </tr>
        <tr>
            <td>Materia:</td>
            <td><input type="text" name="materia" id="materia" required value="<%= group.getMateria() %>"/></td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td><input type="text" name="profesor" id="profesor" required value="<%= group.getProfesor() %>"></td>
        </tr>
        <tr>
            <td>Horario:</td>
            <td><input type="text" name="horario" id="horario" hint="aaaa-mm-dd" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required value="<%= group.getHorario() %>"></td>
        </tr>    
    </table>
    <input type="submit" value="Guardar" onclick="validate(this.form)">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <p>Al dar clic en Guardar se registraran los cambios</p>
<%@ include file="/footer.jsp" %>
