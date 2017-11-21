<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Editar grupo
</h1>
<p>Aqu&iacute; esta la informaci&oacuten del grupo:</p>
<%@page import="group.Group" %>
<% Group group = (Group) request.getAttribute("group"); %>
<form name="editGroup" id="editGroup" action="UpdateToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <br>
    Clave:<input type="text" name="clave" id="clave" required value="">
    <br>
    Materia:<input type="text" name="materia" id="materia" required value="<%= group.getMateria() %>"/>
    <br>
    Profesor:<input type="text" name="profesor" id="profesor" required value="<%= group.getProfesor() %>">
    <br>
    Horario:<input type="text" name="horario" id="horario" hint="aaaa-mm-dd" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required value="<%= group.getHorario() %>">
    <br>
    <br>
    <input type="submit" value="enviar" onclick="validate(this.form)">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <a href="/listGroups.jsp">Cancelar</a>
    <button type="button" id="cancelbtn" >Cancelar</button>
    <p>Al dar clic en Submit se registraran los cambios</p>
<%@ include file="/footer.jsp" %>
