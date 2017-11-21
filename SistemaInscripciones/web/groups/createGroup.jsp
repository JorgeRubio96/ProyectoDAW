<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Crear grupo
</h1>
<p>Aqu&iacute; ingresa la informaci&oacuten del grupo:</p>

<form name="createGroup" id="createGroup" action="AddToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <table>
        <tr>
            <td>Clave:</td>
            <td><input type="text" name="clave" id="clave" required></td>
        </tr>
        <tr>
            <td>Materia:</td>
            <td><input type="text" name="materia" id="materia" required /></td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td><input type="text" name="profesor" id="profesor" required ></td>
        </tr>
        <tr>
            <td>Horario:</td>
            <td><input type="text" name="horario" id="horario" hint="aaaa-mm-dd" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required ></td>
        </tr>    
    </table>
    <br>
    <br>
    <input type="submit" value="Crear" onclick="validate(this.form)">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <br>
    <p>Al dar clic en Crear se registraran los cambios</p>
<%@ include file="/footer.jsp" %>
