<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Time"%>
<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Editar grupo
</h1>
<p>Aqu&iacute; esta la informaci&oacuten del grupo:</p>
<%@page import="mx.tec.inscripciones.model.Class" %>
<% Class group = (Class) request.getAttribute("Class"); %>
<%@page import="mx.tec.inscripciones.model.Course"%>
<%@page import="mx.tec.inscripciones.model.Classroom"%>
<%@page import="mx.tec.inscripciones.model.Teacher"%>
<%@page import="mx.tec.inscripciones.model.TimeSlot"%>
<%// get parameters from the request
 int idMateria = Integer.parseInt(request.getParameter("idMateria"));
 int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));
 int groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
 int idSalon = Integer.parseInt(request.getParameter("idSalon") );
 String dia = request.getParameter("dia");
 String hrInicio = request.getParameter("hrInicio"); 
 String hrFin = request.getParameter("hrFin");
//buscar en bd la materia, el salon, el profesor y el schedule
 Course materia;
 Classroom salon;
 Teacher profesor;
 TimeSlot horario;
 ArrayList<Course> materias = new ArrayList();
%>
<form name="editGroup" id="editGroup" action="UpdateToDataBaseServlet" onSubmit="return ValidarForma(this);">
    <table id="datos" name="datos">
        <tr>
            <td>Materia:</td>
            <td>
                <select id="materia" name="materia">
                    <option></option>
                    <%
                        String sql = "SELECT * FROM course";
                        PreparedStatement stmt = getDatabase().prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next()) {
                            int id = rs.getInt("id");
                            String code = rs.getString("code");
                            String title = rs.getString("title");
                            int honors = rs.getInt("honors");
                            int lab_hrs = rs.getInt("lab_hrs");
                            if(id == idMateria)
                            {
                                %>
                                <option value='<%= idMateria%>' selected><%= title%></option>
                                <%
                            } else 
                            {
                                %>
                                <option value='<%= idMateria%>'><%= title%></option>
                                <%
                            }
                        }
                        
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Grupo no.:</td>
            <td>
                <input type="number" id="numGroup" name="numGroup" value='<%= groupNumber%>'>
            </td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td>
                <select id="profesor" name="profesor">
                    <option></option>
                    <%
                        String sql2 = "SELECT * FROM teacher";
                        PreparedStatement stmt2 = getDatabase().prepareStatement(sql);
                        ResultSet rs2 = stmt2.executeQuery();
                        while(rs2.next()) {
                            int idProfesor2 = rs2.getInt("id");
                            String fName = rs2.getString("first_name");
                            String lName = rs2.getString("last_name");
                            if(idProfesor2 == idProfesor)
                            {
                                %>
                                <option value='<%= idProfesor%>' selected><%= fName+" "+lName %></option>
                                <%
                            } else 
                            {
                                %>
                                <option value='<%= idProfesor%>'><%= fName+" "+lName%></option>
                                <%
                            }
                        }
                        
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Sal&oacute;n:</td>
            <td>
                <select id="classroom" name="classroom">
                    <option></op>
                    <%
                        String sql3 = "SELECT * FROM classroom";
                        PreparedStatement stmt3 = getDatabase().prepareStatement(sql);
                        ResultSet rs3 = stmt3.executeQuery();
                        while(rs3.next()) {
                            int idSalon2 = rs3.getInt("id");
                            String building = rs3.getString("building");
                            String room = rs3.getString("room");
                            if(idSalon2 == idSalon)
                            {
                                %>
                                <option value='<%= idSalon2%>' selected><%= building+" "+room %></option>
                                <%
                            } else 
                            {
                                %>
                                <option value='<%= idSalon2%>'><%= building+" "+room%></option>
                                <%
                            }
                        }
                        
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>D&iacute;a:</td>
            <td>
                <select id="dia" name="dia">
                    <%
                        String sql4 = "SELECT * FROM schedule";
                        PreparedStatement stmt4 = getDatabase().prepareStatement(sql);
                        ResultSet rs4 = stmt4.executeQuery();
                        while(rs4.next()) {
                            int idSchedule = rs4.getInt("id");
                            String dia2 = rs4.getString("day");
                            String start_time = rs4.getString("start_time");
                            String end_time = rs4.getString("end_time");
                            if(dia2 == dia && start_time==hrInicio && end_time == hrFin)
                            {
                                %>
                                <option value='<%= dia2%>' selected><%= dia2%></option>
                                <%
                            } else 
                            {
                                %>
                                <option value='<%= dia2%>'><%= dia2%></option>
                                <%
                            }
                        }
                        
                    %>
                </select>
            </td>
            <td>Inicio:</td>
            <td>
                <input type="time" id="hrInicio_0" name="hrInicio_0" value="<%= hrInicio%>">
            </td>
            <td>Fin:</td>
            <td>
                <input type="time" id="hrFin_0" name="hrFin_0" value="<%= hrFin%>">
            </td>
            <td><a onclick="agregarHorario()">Agregar</a></td>
        </tr>
    </table>
    <br>
    <br>
    <input type="submit" value="Crear" onclick="validate(this.form)">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <p>Al dar clic en Guardar se registraran los cambios</p>
<%@ include file="/footer.jsp" %>
