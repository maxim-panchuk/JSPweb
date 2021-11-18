/*function sendData(data) {
    const response = fetch ("http://localhost:8080/JSPweb-1.0-SNAPSHOT/ServletController", {
        method:     "POST",
        headers:    {
            "Content-Type" : "Application/json"
        },
        body:       JSON.stringify(data)
    })
}*/


function sendData(data) {
    let http = new XMLHttpRequest();
    const main = 'http://localhost:8080/JSPweb-1.0-SNAPSHOT/';
    const page = '/ServletController';
    let url = main + page;
    http.onload = function () {
        document.location.href = 'index.jsp';
    }
    http.open('POST', url, false);
    http.send(JSON.stringify(data));
}