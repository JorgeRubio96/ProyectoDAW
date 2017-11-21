<%@ include file="/groups/headerGroups.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>
    Crear grupo
</h1>
<p>Aqu&iacute; ingresa la informaci&oacuten del grupo:</p>

<form id="datos" action="AddToDataBaseServlet" @submit.prevent="send">
    <table name="datos">
        <tr>
            <td>Materia:</td>
            <td>
                <select v-model="materia">
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
                <input type="number" v-model="numGroup">
            </td>
        </tr>
        <tr>
            <td>Profesor:</td>
            <td>
                <select v-model="profesor">
                    <option></option>
                    <option value="1">Luis Perez</option>
                    <option value="2">Romina De La Cruz</option>
                    <option value="3">Jaime Corrales</option>
                    <option value="4">Consuelo Garcia</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Sal&oacute;n:</td>
            <td>
                <select v-model="classroom">
                    <option></op>
                    <option value="1">A3301</option>
                    <option value="2">A4404</option>
                    <option value="3">A2202</option>
                    <option value="4">A1207</option>
                    <option value="5">A3105</option>
                </select>
            </td>
        </tr>
        <template v-for="time in times">
            <tr>
                <td>D&iacute;a:</td>
                <td>
                    <select v-model="time.day">
                        <option value="Lu">Lunes</option>
                        <option value="Ma">Martes</option>
                        <option value="Mi">Mi&eacute;rcoles</option>
                        <option value="Ju">Jueves</option>
                        <option value="Vi">Viernes</option>
                    </select>
                </td>
                <td>Inicio:</td>
                <td>
                    <input type="time" v-model="time.start">
                </td>
                <td>Fin:</td>
                <td>
                    <input type="time" v-model="time.end">
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
    <input type="submit" value="Crear" onclick="validate(this.form)">
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
                    }
                    
                    console.log(data);
                }
            }
        });
    </script>
<%@ include file="/footer.jsp" %>
