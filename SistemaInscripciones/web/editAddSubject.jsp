<%-- 
    Document   : editAddSubject
    Created on : 21/11/2017, 05:57:51 PM
    Author     : avm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva materia</title>
        <link rel="stylesheet" type="text/css" href="estiloInscripciones.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </head>
    <script>
        function applyChanges(){
            
                var cod= $('#curso').val();
                var nom= $('#nombre').val();
                var hon= $('#honors').val();
                
                $.post('insertSubject', 
                {codigo:cod,nombre:nom,honors:hon},
                function(data){
                    $('#resultado').html(data);
                });
            
        }
    </script>
    <body>
        <h2>Navegacion</h2>
        <a href="index.html">INICIO</a><br>
        <a href="groups/listGroups.jsp">Grupos</a><br>
        <a href="">Profesores</a><br>
        <a href="">Salones</a><br>
        <a href="editSubject.jsp">Materias</a><br>
        <h1>Agregar curso</h1>
        Codigo de curso  <input type="text" id="codigo"><br>
        Nombre de curso  <input type="text" id="nombre"><br>
        ¿Honores? <input type="radio" id="honors1" name="honors" value="true">
        <label for="honors1">Si</label>
        <input type="radio" id="honors2" name="honors" value="false">
        <label for="honors2">No</label><br>
        <button id="apply" onclick="applyChanges()">Aceptar</button>
        <br><br>
        <div id="resultado"></div>
    </body>
</html>
