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
        <?php include nav.php ?>
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
        <a href="groups/listGroups.jsp">Grupos</a>
        <a href="">Profesores</a>
        <a href="">Salones</a>
        <a href="editSubject.jsp">Materias</a>
        <div id="materias" style="position: relative;
             left:200px;top:0;"></div>
        <button onclick="runXHR()" style="position: relative;
             left:200px;top:0;">Lista</button><br>
        <button onclick="alert(hola)" style="position: relative;
             left:200px;top:0;">Modifica</button>
        
    </body>
</html>
