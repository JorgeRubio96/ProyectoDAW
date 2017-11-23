<%-- 
    Document   : editAddClass
    Created on : 21-nov-2017, 21:39:46
    Author     : inspiron
--%>

<%@page import="mx.tec.inscripciones.model.Classroom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="mx.tec.inscripciones.model.Course"%>
<%@page import="mx.tec.inscripciones.viewmodel.TeacherListViewModel"%>
<%@page import="mx.tec.inscripciones.model.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="mx.tec.inscripciones.store.TeacherStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/GetClassroomsAndProfessors" />
<html>
    <head>
        <title>Create class</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">
            var classrooms;
            window.onload = function() {
                classrooms = document.getElementById("classselect").cloneNode(true);
            }
            function agregar() {
                div = document.getElementById("times");
                div.innerHTML += '<label></label> <input type="time" name="time_start">-<input type="time" name="time_end"';
                div.innerHTML += ' Day: <select name="day"><option value="lu">Lu</option><option value="ma">Ma</option><option value="mi">Mi</option><option value="ju">Ju</option><option value="vi">Vi</option><option value="sa">Sa</option></select> Classroom: '
                div.appendChild(classrooms);
                div.innerHTML += "<br>";
                cont += 1;
            }
        </script>
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
        <form action="ClassServlet">
            <label> Course: </label> <select name="courses"><br>
            <%  List<Course> courses = new ArrayList<>();
                courses = (List<Course>) request.getAttribute("courses");
                for (Iterator<Course> iter = courses.iterator(); iter.hasNext();)
            {   Course course = iter.next();%>
            <option value="<%=course.getId()%>"><%=course.getCode() + " - " + course.getTitle()%></option>
            <%}
            %>
            </select><br>
            <label> Professor: </label> <select name="proffs"><br>
            <%  List<Teacher> teachers = new ArrayList<>();
                teachers = (List<Teacher>) request.getAttribute("teachers");
                for (Iterator<Teacher> iter = teachers.iterator(); iter.hasNext();)
            {   Teacher teacher = iter.next();%>
            <option value="<%=teacher.getId()%>"><%=teacher.getFirstName()+" "+teacher.getLastName()%></option>
            <%}
            %>
            </select><br>
            <label> Group Number: </label> <input type="number" name="group" min="1" required><br>
            <label> Time(s): </label> <input type="time" name="time_start" required>-<input type="time" name="time_end" required>
            Day: <select name="day"><option value="lu">Lu</option><option value="ma">Ma</option><option value="mi">Mi</option><option value="ju">Ju</option><option value="vi">Vi</option><option value="sa">Sa</option></select>
            Classroom: <select name="salon" id="classselect">
            <%  List<Classroom> classrooms = new ArrayList<>();
                classrooms = (List<Classroom>) request.getAttribute("classrooms");
                for (Iterator<Classroom> iter = classrooms.iterator(); iter.hasNext();)
            {   Classroom cr = iter.next();%>
            <option value="<%=cr.getId()%>"><%=cr.getCode()%></option>
            <%}
            %> 
            </select><br>
            <div id="times"></div>
            <input type="button" value="Add another time slot" onclick="agregar();"><br>
            <input type="submit" value="Create">
        </form>
        </div>
    </body>
</html>