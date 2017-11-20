<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Editar grupo
</h1>
<p>Aqu&iacute; esta la informaci&oacuten del grupo:</p>
<%@page import="group.Group" %>
<% Group group = (Group) request.getAttribute("group"); %>
<form name="editGroup" id="editGroup" action="" onSubmit="return ValidarForma(this);">
    <br>
    Clave:<input type="text" name="clave" required value="">
    <br>
    Materia:<input type="text" name="materia" required value="<%= group.getMateria() %>"/>
    <br>
    Profesor:<input type="text" name="profesor" required value="<%= group.getProfesor() %>">
    <br>
    Horario:<input type="text" name="horario" required value="<%= group.getHorario() %>">
    <br>
    <br>
    <input type="submit" value="enviar">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <p>Al dar clic en Submit se registraran los cambios</p>
<%@ include file="/footer.jsp" %>
