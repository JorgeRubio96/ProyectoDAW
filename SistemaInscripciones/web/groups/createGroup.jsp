<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Crear grupo
</h1>
<p>Aqu&iacute; ingresa la informaci&oacuten del grupo:</p>

<form name="createGroup" id="createGroup" action="AddToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <table>
        <tr>
            <td>Materia:</td>
            <td>
                <select id="materia" name="materia">
                    <op></op>
                    <op value="1">Modelos y Anlitica de redes sociales</op>
                    <op value="2">Desarrollo de Aplicaciones Web</op>
                    <op value="3">Calidad y Pruebas de Software</op>
                    <op value="4">Introduccion a la Programacion</op>
                    <op value="5">Estructura de datos</op>
                    <op value="6">Dise&ntilde;o de Algoritmos</op>
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
                    <op></op>
                    <op value="1">Luis Perez</op>
                    <op value="2">Romina De La Cruz</op>
                    <op value="3">Jaime Corrales</op>
                    <op value="4">Consuelo Garcia</op>
                </select>
            </td>
        </tr>
        <tr>
            <td>Horario:</td>
            <td>
                <select id="schedule" name="schedule">
                    
                </select>
            </td>
        </tr>
        <tr>
            <td>Sal&oacute;n:</td>
            <td>
                <select id="classroom" name="classroom">
                    <op></op>
                    <op value="1">A3301</op>
                    <op value="2">A4404</op>
                    <op value="3">A2202</op>
                    <op value="4">A1207</op>
                    <op value="5">A3105</op>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td></td>
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
