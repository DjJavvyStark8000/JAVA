<%-- 
    Document   : ReceiptList
    Created on : Oct 26, 2023, 3:07:57 PM
    Author     : djjav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Config.FinalVariables"%>
<%@page import="Config.Substracting"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/receipts.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="assets/js/receipts.js" type="text/javascript"></script>
        <title>Facturación</title>
    <body>
        <div class="main-container">
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
                                <li class="nav-item">
                                    <a class="nav-link text-dark" href="FrmPlatform.jsp">Plataforma</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="tabla-titulo">Facturas de clientes</div>
            <table border="1" class="tabla-productos" id="virtualreceipt">
                <thead>
                    <tr>
                        <th>ID_FACTURA</th>
                        <th>CLIENTE</th>
                        <th>ID_CLIENTE</th>
                        <th>FECHA</th>
                        <th>IMPUESTO</th>
                        <th>DESCUENTO</th>
                        <th>TOTAL</th>
                        <th>EDITAR</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Object[] item : Substracting.clientReceipts) {
                    %>
                    <tr>
                        <td><%= item[0]%></a></td>
                        <td><%= item[1]%></td>
                        <td><%= item[2]%></td>
                        <td><%= item[3]%></td>
                        <td><%= item[4]%></td>
                        <td><%= item[5]%></td>
                        <td><%= item[6]%></td>
                        <td>
                            <a href="" data-value="<%= item[0]%>" onclick="editThisReceipt(this.getAttribute('data-value')); return false;"><i class="fa fa-pen"></i></a>&nbsp&nbsp
                            <a href="" data-value="<%= item[0]%>" onclick="eraceThisReceipt(this.getAttribute('data-value')); return false;"><i class="fa fa-trash"></i></a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table><br>
            <div class="busqueda">
                <form>
                    <input type="radio" name="userType" value="" id="radioID" style="color: white">
                    <label for="id">Busqueda por Factura</label>

                    <input type="radio" name="userType" value="client" id="radioClient" style="color: white">
                    <label for="client">Busqueda por Cliente</label>
                </form><br>
                <label style="color:white" for="txtBuscar">Ingresar datos por buscar</label>
                <input type="text" id="txtBuscar" name="txtBuscar" value="">
                <input type="submit" id="btnBuscar" name="btnBuscar" value="Buscar" onclick="setCondition()" disabled/>
                <input type="submit" id="btnRefrescar" name="btnRefrescar" value="Refrescar" onclick="refrescar()"/>
            </div>

        </div>
        <div class="message">
            Versión móvil no disponible
        </div>
    </body>
    <script src="assets/js/preparecondition.js" type="text/javascript"></script>
</html>
