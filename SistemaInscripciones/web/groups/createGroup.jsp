<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Crear grupo
</h1>
<p>Aqu&iacute; ingresa la informaci&oacuten del grupo:</p>

<form method="Post" name="createGroup" id="createGroup" action="AddToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <table>
        <tr>
            <td>Materia:</td>
            <td>
                <select id="materia" name="materia">
                    <option></option>
                    <option value="1">Modelos y Anlitica de redes sociales</option>
                    <option value="2">Desarrollo de Aplicaciones Web</option>
                    <option value="3">Calidad y Pruebas de Software</option>
                    <option value="4">Introduccion a la Programacion</option>
                    <option value="5">Estructura de datos</option>
                    <option value="6">Dise&ntilde;o de Algoritmos</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Grupo no.:</td>
            <td>
                <input type="text" id="numGroup" name="numGroup">
            </td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td>
                <select id="profesor" name="profesor">
                    <option></option>
                    <option value="1">Luis Perez</option>
                    <option value="2">Romina De La Cruz</option>
                    <option value="3">Jaime Corrales</option>
                    <option value="4">Consuelo Garcia</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Horario:</td>
            <td>
            </td>
        </tr>
        <tr>
            <td>Sal&oacute;n:</td>
            <td>
                <select id="classroom" name="classroom">
                    <option></op>
                    <option value="1">A3301</option>
                    <option value="2">A4404</option>
                    <option value="3">A2202</option>
                    <option value="4">A1207</option>
                    <option value="5">A3105</option>
                </select>
            </td>
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
