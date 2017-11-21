var table;
var count=0;

function agregarHorario(){
    count++;
    table = document.getElementById("datos");
    var tr = document.createElement("tr");
    var data = "<td>D&iacute;a:</td><td><select id='dia"+count+"' name='dia"+count+"'><option value='Lu'>Lunes</option>"
            +"<option value='Ma'>Martes</option>"
            +"<option value='Mi'>Mi&eacute;rcoles</option><option value='Ju'>Jueves</option>"
            +"<option value='Vi'>Viernes</option></select></td><td>Inicio:</td><td>"
            +"<input type='time' id='hrInicio_"+count+"' name='hrInicio_"+count+"'></td><td>Fin:</td><td>"
            +"<input type='time' id='hrFin_"+count+"' name='hrFin_"+count+"'></td><td><a onclick='borrarFila("+count+")'>"
            +"Borrar</a></td>";
    tr.innerHTML = data;
    var idTR = "tr"+count;
    tr.setAttribute("id", idTR);
    table.appendChild(tr);
}

function borrarFila(c){
    var id = "tr"+c;
    count--; 
    var row = document.getElementById(id);
    table.removeChild(row);
    return false;
}

