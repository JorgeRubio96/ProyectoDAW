<!DOCTYPE html>
<html>
<head>
<title>Edit time</title>

<script type="text/javascript">
var prev1h, prev1m, prev2h, prev2m, prevday;

function editTime(e) {
    x = e.parentNode.getElementsByTagName("span");
    prev1h = x[0].innerHTML;
    prev1m = x[1].innerHTML;
    prev2h = x[2].innerHTML;
    prev2m = x[3].innerHTML;
    prevday = x[4].innerHTML;
    x[0].innerHTML = '<input type="number" value =' + prev1h + " />";
    x[1].innerHTML = '<input type="number" value =' + prev1m + " />";
    x[2].innerHTML = '<input type="number" value =' + prev2h + " />";
    x[3].innerHTML = '<input type="number" value =' + prev2m + " />";
    x[4].innerHTML = '<select name="day"><option value="lu">Lu</option><option value"ma">Ma</option><option value="mi">Mi</option><option value="ju">Ju</option><option value="vi">Vi</option><option value="sa">Sa</option></select>';
    y = e.parentNode.getElementsByTagName("select");
    y[0].value = prevday;
    x[5].innerHTML = "";
    x[6].innerHTML = "Save Changes";
    x[7].innerHTML = "Cancel";    
}

function saveChanges(e) {
	if (e.innerHTML != "") {
     	x = e.parentNode.getElementsByTagName("input");
        var time1 = new Date();
        try {
        	if (x[0].value <= 23 && x[0].value > 0 && x[2].value <= 23 && x[2].value > 0 && x[1].value < 60 && x[1].value >= 0 && x[3].value < 60 && x[3].value >= 0) {
                    var time1 = new Date();
                    time1.setHours(x[0].value, x[1].value)
                    var time2 = new Date();
                    time2.setHours(x[2].value, x[3].value)
                    if (time1 < time2 ) {
              		prev1h = x[0].value;
              		prev1m = x[1].value;
              		prev2h = x[2].value;
              		prev2m = x[3].value;
			prevday = e.parentNode.getElementsByTagName("select")[0].value;
			prevday = prevday.charAt(0).toUpperCase() + prevday.charAt(1);
              		remove(e);
          		} else {
              		alert("Hour 2 has to be after hour 1");
             	}
			} else {
				alert("Hour formats aren't valid");
			}
		} catch(err) {
        	alert("Hour formats aren't valid");
        }
    }
}
function cancel(e) {
	if (e.innerHTML != "") {
            remove(e);
	}
}
function remove(e) {
    x = e.parentNode.getElementsByTagName("span");
    x[0].innerHTML = prev1h;
    x[1].innerHTML = prev1m;
    x[2].innerHTML = prev2h;  
    x[3].innerHTML = prev2m;
    x[4].innerHTML = prevday;
    x[5].innerHTML = "Edit";
    x[6].innerHTML = "";
    x[7].innerHTML = "";
}

</script>
<link rel="stylesheet" type="text/css" href="tablabonis.css">
</head>
<body>
<div id="demo" style="max-width:700px;">
<h1>Edit time of classes</h1>
    <div class="table-responsive-vertical shadow-z-1">
    <table id="table" class="table table-hover table-mc-light-blue">
        <tr><td>Time: <span>16</span>:<span>30</span> -  <span>18</span>:<span>00</span> <span>Ma</span> <span class="edit" onclick="editTime(this)"> Edit </span> <span class="edit" onclick="saveChanges(this)"></span> <span class="edit" onclick="cancel(this)"> <br> </span>
        </td></tr>
    </table>
    </div>
</div>
</body>
</html>