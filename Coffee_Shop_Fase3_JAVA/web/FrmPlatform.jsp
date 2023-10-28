<%-- 
    Document   : FrmPlatform
    Created on : Oct 13, 2023, 12:22:33 PM
    Author     : djjav
--%>

<%@page import="Config.FinalVariables"%>
<%@page import="Config.Substracting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/styles.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="assets/js/servletcaller.js" type="text/javascript"></script>
        <title>Plataforma Principal</title>

    </head>
    <body>

        <div class="main-container">
            <div class="left-container">
                <a href="NameAsigment?nameProduct=Expresso" class="square-box coffee" id="expresso">
                    <div class="button-container">
                        <p class="forsale">Expresso</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Negro" class="square-box coffee" id="negro">
                    <div class="button-container">
                        <p class="forsale">Negro</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Latte" class="square-box coffee" id="latte">
                    <div class="button-container">
                        <p class="forsale">Latte</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Cappuccino" class="square-box coffee" id="cappuccino">
                    <div class="button-container">
                        <p class="forsale">Cappuccino</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Mocha" class="square-box coffee" id="mocha">
                    <div class="button-container">
                        <p class="forsale">Mocha</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=WithMilk" class="square-box coffee" id="conleche">
                    <div class="button-container">
                        <p class="forsale">Con Leche</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Brew" class="square-box coffee" id="brew">
                    <div class="button-container">
                        <p class="forsale">Brew</p>
                    </div>
                </a>

                <a href="NameAsigment?nameProduct=Irish" class="square-box coffee" id="irish">
                    <div class="button-container">
                        <p class="forsale">Irish</p>
                    </div>
                </a>
                <div class="details">

                    <label for="tamano">Tamaño:</label>
                    <select id="tamano" onclick="selectedSize()">
                        <option value="0"></option>
                        <option value="Pequeño">Pequeño</option>
                        <option value="Mediano">Mediano</option>
                        <option value="Grande">Grande</option>
                    </select>

                    <br>

                    <label for="cantidad">Cantidad:</label>
                    <select id="cantidad" onclick="selectedQuantity()">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>

                    <br>

                    <label for="azucar">Azúcar:</label>
                    <select id="azucar" onclick="selectedSugars()">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>

                    <br>

                    <label for="crema">Crema:</label>
                    <select id="crema" onclick="selectedCreams()">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>

                    <br>

                    <label for="leche">Leche:</label>
                    <select id="leche" onclick="selectedMilks()">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>

                    <button class="btnagregar" id="updateButton" type="button" onclick="refreshPage()">Agregar a factura</button>

                    <header class="menu-bottom">
                        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
                            <div class="container">
                                <a class="navbar-brand" href="index.html">Coffee Shop Facturación <i class="fas fa-tasks"></i></a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                                    <ul class="navbar-nav flex-grow-1">
                                        <li class="nav-item">
                                            <a class="nav-link text-dark" href="index.html">Inicio</a>
                                        </li>                                     
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </header>
                </div>
            </div>
            <div class="right-container">
                <div class="receipt-head">
                    <h1 id="logo-header">Coffee Shop</h1>
                    <div class="right-header">
                        <p>Factura:<span class="right-header-results" id="thereceipt"> 000000</span></p>
                        <%
                            Substracting thedate = new Substracting();
                            String date = thedate.getFechaActual();
                            //dont need the time because we can pull i from the servlet
%>
                        <p>Fecha:<span class="right-header-results" id="thedate"> <%=date%></span></p>
                        <p>Hora:<span class="right-header-results" id="thetime"> 000000</span></p>
                    </div>

                </div>
                <div class="receipt-body">
                    <form>
                        <p>Cliente:</p>
                        <input type="text" id="txtcliente" name="cliente" placeholder="Cliente no registrado"><br>
                        <%
                            String email = FinalVariables.ghostEmail;
                        %>
                        <input type="text" id="txtcorreo" name="correo" placeholder="<%=email%>"><br>
                        <p>Detalle:<span class="right-header-results" id="thedetail"> 000000</span></p>
                    </form>


                    <!--shows the tale only this aproach was a quick solution and it needs to be rework-->
                    <iframe class="tableframe" src="TableOnly.jsp" scrolling="yes"></iframe>
                    <div class="form-group">
                        <p>Total Bruto:<span class="right-header-results" id="totalbrute"> 000000</span></p>
                    </div>
                    <div class="form-group">
                        <p>Impuesto:<span class="right-header-results" id="totaltax"> 000000</span></p>
                    </div>
                    <div class="form-group">
                        <p>Descuento:<span class="right-header-results" id="totaldiscount"> 000000</span></p>
                    </div>
                    <div class="form-group">
                        <p>Total Neto:<span class="right-header-results" id="totalnet"> 000000</span></p>
                    </div>
                </div>
                <div id="final-btn-section">
                    <button id="imprimir">Imprimir</button>
                    <button id="cancelar" type="button" onclick="cleanForm()">Cancelar</button>
                    <button id="guardar" type="button" onclick="grabNewClientInfo()">Guardar</button>
                    <button id="salir">Salir</button>
                </div>
            </div>
        </div>

        <div class="message">
            Versión móvil no disponible
        </div>
    </body>   
   
    <script src="assets/js/timing.js" type="text/javascript"></script>
    <script src="assets/js/productname.js" type="text/javascript"></script>
</html>
