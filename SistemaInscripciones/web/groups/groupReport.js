var request;

function getRequestObject(){
    if(window.ActiveXObject)
    {
        return(new ActiveXObject("Microsoft.XMLHTTP"));
    }else if (windos.XMLHttpRequest)
    {
        return(new XMLHttpRequest());
    } else {
        return(null);
    }
}
function sendRequest()
{
    request = getRequestObject;
    request.onreadystateChange = handleResponse;
    request.open("GET", "groupReport.html", true);
    request.send(null);
}

function handleRespone()
{
    if((request.readyState == 4) && 
            (request.status == 200))
    {
        var reqDoc = request.responseText;
    }
}