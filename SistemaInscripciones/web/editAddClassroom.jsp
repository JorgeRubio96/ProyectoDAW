<%-- 
    Document   : editAddClass
    Created on : 21-nov-2017, 20:04:27
    Author     : inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Create classroom</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            /* -- import Roboto Font ---------------------------- */
            @import "https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic&subset=latin,cyrillic";
            body {
                font-family: 'RobotoDraft', 'Roboto', 'Helvetica Neue, Helvetica, Arial', sans-serif;
                font-style: normal;
                font-weight: 300;
                font-size: 1rem;
                line-height: 2rem;
                letter-spacing: 0.01rem;
                color: #212121;
                background-color: #f5f5f5;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
                text-rendering: optimizeLegibility;
            }
            #demo {
              margin: 20px auto;
            }
            label {
                display: inline-block;
                width: 140px;
                text-align: right;
            }​
        </style>
    </head>
    <body>
        <div id="demo">
        <form action="ClassroomServlet">
            <label> Classroom code: </label> <input type="text" name="ccode" maxlength="10" required><br>
            <label> Building:</label> <input type="text" name="build" maxlength="40" required><br>
            <label> Room number: </label> <input type="number" name="number" min="1" required><br>
            <input type="submit" value="Create">
        </form>
        </div>
    </body>
</html>