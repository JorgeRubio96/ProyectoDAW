<%-- 
    Document   : editSubject
    Created on : 20/11/2017, 04:26:11 PM
    Author     : avm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materias disponibles</title>
        <link rel="stylesheet" type="text/css" href="estiloInscripciones.css" />
    </head>
    
    <script>
        
        function runXHR(){
        var xhr= new XMLHttpRequest();
        var params= "";
        
        xhr.open("GET", "subjectServlet", true);
        
        xhr.onload= function(){
            if(this.status == 200){
                document.getElementById("materias").innerHTML= 
                        xhr.responseText;
            }
        };
        
        xhr.send();
    }
    </script>
    
    <body>
        <h2>Navegacion</h2>
        <a href="index.html">INICIO</a><br>
        <a href="groups/listGroups.jsp">Grupos</a><br>
        <a href="">Profesores</a><br>
        <a href="">Salones</a><br>
        <a href="editSubject.jsp">Materias</a><br>
        <div id="materias" style="position: absolute;
             left:200px;top:0;"></div>
        <button onclick="runXHR()" style="position: relative;
             left:200px;top:0;">Lista</button><br>
        
             <form method='GET' action="editAddSubject.jsp">
                 <input type="submit" value="Añadir"/>
             </form><br>
             
             <p>Codigo de curso que quieres modificar</p>
             <form method='GET'action="updateSubject.jsp">
                 <input type="text" name="modID">
                 <input type="submit" value="Modificar"/>
             </form>
    </body>
</html>
