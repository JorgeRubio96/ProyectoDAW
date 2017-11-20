<!DOCTYPE html>
<html>
<head>
    <title>Sistema de Inscripciones</title>
    <style>
        input:invalid{background: red}
        #groups {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #groups td,#groups  th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #groups tr:nth-child(even){background-color: #f2f2f2;}

        #groups tr:hover {background-color: #ddd;}

        #groups th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
        
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: blue;
            color: white;
            text-align: center;
        }
    </style>
    <script>
        window.onload = initForm;
        function goBack(){
            window.history.back();
        }
        function initForm(){
            document.forms[0].onsubmit = validarForma;
        }
        
    </script>
    <script type="text/javascript" src="src\java\group\update.js"></script>
</head>

<body>
