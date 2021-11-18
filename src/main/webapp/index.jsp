<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jspweb.Logic.ServerResponse" %>
<%@ page import="com.example.jspweb.Logic.TestTable" %>
<%@ page import="com.example.jspweb.Logic.SvgUpdater" %>
<%@ page import="com.example.jspweb.Logic.LastDots" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Hello, world!</title>
</head>
<body>
<div class="container-fluid">
    <div class="row content-class">
        <div class="col-2 sidebar">
            <button class="btn-params" type="button" data-bs-toggle="offcanvas" data-bs-target=".offcanvas" aria-controls="offcanvasExample">
                Settings
            </button>
            <p class="sidebar-text">
                Panchuk Maxim, P3214
            </p>
        </div>

        <div class="col-5">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">X</th>
                    <th scope="col">Y</th>
                    <th scope="col">R</th>
                    <th scope="col">Time</th>
                    <th scope="col">Execution Time</th>
                    <th scope="col">Result</th>
                </tr>
                </thead>
                <%
                    TestTable testTable = new TestTable((ArrayList<ServerResponse>) session.getAttribute("dots"));
                %>
                <%= testTable.toString()%>
            </table>
        </div>


        <div class="col-5 d-flex justify-content-center">
            <svg class="svg-coordinates " height="350" width="350" id="area-graph">

                <path class="coordinates-figure" d="
                            M 105 175
                          h70
                          v-70
                          A70 70 0 0 0 105 175z
                        "></path>

                <polygon class="coordinates-figure" points="175,315 175,175 315,175 ">
                </polygon>

                <rect class="coordinates-figure" x="35" y="175" width="140" height="140"></rect>

                <line class="coordinate-axis" x1="0" x2="345" y1="175" y2="175"></line>
                <line class="coordinate-axis" x1="175" x2="175" y1="350" y2="5"></line>


                <line class="coordinates-marker" x1="171" x2="179" y1="35" y2="35"></line>
                <line class="coordinates-marker" x1="171" x2="179" y1="105" y2="105"></line>
                <line class="coordinates-marker" x1="171" x2="179" y1="245" y2="245"></line>
                <line class="coordinates-marker" x1="171" x2="179" y1="315" y2="315"></line>

                <text class="positive-coords" x="150" y="40">R</text>
                <text class="negative-coords" x="150" y="320">-R</text>


                <line class="coordinates-marker" x1="35" x2="35" y1="171" y2="179"></line>
                <line class="coordinates-marker" x1="105" x2="105" y1="171" y2="179"></line>
                <line class="coordinates-marker" x1="245" x2="245" y1="171" y2="179"></line>
                <line class="coordinates-marker" x1="315" x2="315" y1="171" y2="179"></line>

                <text class="positive-coords" x="310" y="195">R</text>
                <text class="negative-coords" x="30" y="195">-R</text>

                <text class="coordinates-text" x="182" y="11">Y</text>
                <text class="coordinates-text" x="335" y="167">X</text>

                <%
                    SvgUpdater svgUpdater = new SvgUpdater((ArrayList<LastDots>) session.getAttribute("lastDots"));
                %>
                <%=
                    svgUpdater.toString()
                %>
            </svg>
        </div>

    </div>
</div>

<div class="offcanvas offcanvas-start" tabindex="-1" aria-labelledby="offcanvasExampleLabel" id="myOffcanvas">
    <div class="offcanvas-header">
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Закрыть"></button>
    </div>
    <div class="offcanvas-body">
        <form action="" id="main-form">
            <div class="x-selector">
                <p>X  value</p>
                <div class="row ml-3">
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox1" value="-2.0" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox1">-2.0</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox2" value="-1.5" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox2">-1.5</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox3" value="-1.0" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox3">-1.0</label>
                    </div>
                </div>

                <div class="row">
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox4" value="-0.5" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox4">-0.5</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox5" value="0.0" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox5">0.0</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox6" value="0.5" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox2">0.5</label>
                    </div>
                </div>

                <div class="row">
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox7" value="1.0" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox3">1.0</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox8" value="1.5" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox4">1.5</label>
                    </div>
                    <div class="form-check col-4">
                        <input class="form-check-input check-box" type="checkbox" id="inlineCheckbox9" value="2.0" name="check[]">
                        <label class="form-check-label" for="inlineCheckbox5">2.0</label>
                    </div>
                </div>

                <div class="y-selector">
                    <p>Y  value</p>
                    <div class="mb-3">
                        <input type="text" class="form-control" id="inputY" name = "inputY" onkeyup="this.value = this.value.replace(/[^\d . -]/g,'');">
                        <label for="inputY"></label>
                    </div>
                </div>

                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                    <p>Select R</p>
                    <div class="w-100"></div>
                    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                        <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" value="1">
                        <label class="btn btn-outline-primary" for="btnradio1">1</label>

                        <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" value="2">
                        <label class="btn btn-outline-primary" for="btnradio2">2</label>

                        <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off" value="3">
                        <label class="btn btn-outline-primary" for="btnradio3">3</label>

                        <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off" value="4">
                        <label class="btn btn-outline-primary" for="btnradio4">4</label>

                        <input type="radio" class="btn-check" name="btnradio" id="btnradio5" autocomplete="off" value="5">
                        <label class="btn btn-outline-primary" for="btnradio5">5</label>

                    </div>
                </div>
            </div>

            <div class="buttons">
                <button type="button" class="btn btn-primary btn-off" id="send" name="sendButton">Send</button>
                <button type="button" class="btn btn-primary btn-off" id="reset" name="resetButton">Reset</button>
            </div>
        </form>
    </div>
</div>

<script src="js/validation.js"></script>

<script src="js/Dot.js"></script>
<script src="js/RequestBody.js"></script>
<script src="js/updTbl.js"></script>
<script src="js/updDots.js"></script>
<script src="js/updSVG.js"></script>
<script src="js/drawDot.js"></script>
<script src="js/sendForm.js"></script>
<script src="js/resetForm.js"></script>
<script src="js/index.js"></script>
<script src="js/sendDatas.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
</body>
</html>