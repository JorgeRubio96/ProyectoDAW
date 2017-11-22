<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@ include file="/groups/headerGroups.jsp" %>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Crear grupo
</h1>
<p>Aqu&iacute; ingresa la informaci&oacute;n del grupo:</p>

<form id="datos" method="POST" action="/SistemaInscripciones/ClassServlet">
    <table name="datos">
        <tr>
            <td>Materia:</td>
            <td>
                <select name="materia" v-model="materia">
                    <%
                        InitialContext initContext = new InitialContext();
                    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/sistema_inscripciones");
                    Connection databaseConnection;
                    databaseConnection = ds.getConnection();
                    try {
                        databaseConnection = ds.getConnection();
                    } catch(Exception e) {
                        getServletContext().log("", e);
                    }
                        String sql = "SELECT * FROM course";
                        PreparedStatement stmt = databaseConnection.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next()) {
                            int id = rs.getInt("id");
                            String title = rs.getString("title");
                    %>
                            <option value="<%= id%>"><%= title%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Grupo no.:</td>
            <td>
                <input name="numGroup" type="number" v-model="numGroup">
            </td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td>
                <select name="profesor" v-model="profesor">
                    <%
                        String sql2 = "SELECT * FROM teacher";
                        PreparedStatement stmt2 = databaseConnection.prepareStatement(sql);
                        ResultSet rs2 = stmt2.executeQuery();
                        while(rs2.next()) 
                        {
                            int idProfesor2 = rs2.getInt("id");
                            String fName = rs2.getString("first_name");
                            String lName = rs2.getString("last_name");
                                %>
                                <option value='<%= idProfesor2%>'><%= fName+" "+lName%></option>
                                <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <template v-for="time in times">
            <tr>
                <td>Sal&oacute;n:</td>
                <td>
                    <select name="classroom" v-model="classroom">
                        <%
                            String sql3 = "SELECT * FROM classroom";
                            PreparedStatement stmt3 = databaseConnection.prepareStatement(sql);
                            ResultSet rs3 = stmt3.executeQuery();
                            while(rs3.next()) 
                            {
                                int idSalon2 = rs3.getInt("id");
                                String building = rs3.getString("building");
                                String room = rs3.getString("room");
                        %>
                                    <option value='<%= idSalon2%>'><%= building+" "+room%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
                <td>D&iacute;a:</td>
                <td>
                    <select name="day" v-model="time.day">
                        <option value="Lu">Lunes</option>
                        <option value="Ma">Martes</option>
                        <option value="Mi">Mi&eacute;rcoles</option>
                        <option value="Ju">Jueves</option>
                        <option value="Vi">Viernes</option>
                    </select>
                </td>
                <td>Inicio:</td>
                <td>
                    <input name="time-start" type="time" v-model="time.start">
                </td>
                <td>Fin:</td>
                <td>
                    <input name="time-end" type="time" v-model="time.end">
                </td>
                <td>
                    <a @click="add" v-if="time == times[0]">Agregar</a>
                    <a @click="remove(time)" v-else>Borrar</a>
                </td>
            </tr>
        </template>
    </table>
    <br>
    <br>
    <input type="submit" value="Crear">
    <button type="reset" value="Borrar">Borrar</button>
</form>
    <button onclick="goBack()">Cancelar</button>
    <br>
    <p>Al dar clic en Crear se registraran los cambios</p>
    <script>
        let horarioVue = new Vue({
            el: '#datos',
            data: {
                materia: 0,
                profesor: "",
                numGroup: 0,
                classroom: 0,
                times: [{}]
            },
            methods: {
                add: function() {
                    this.times.push({});
                },
                remove: function(time) {
                    this.times.splice(this.times.indexOf(time), 1);
                },
                send: function() {
                    let data = {
                        materia: this.materia,
                        profesor: this.profesor,
                        numGroup: this.numGroup,
                        classroom: this.classroom,
                        times: this.times
                    };

                    let xhr = new XMLHttpRequest();
                    xhr.open("POST", "/SistemaInscripciones");
                }
            }
        });
    </script>
<%@ include file="/footer.jsp" %>
