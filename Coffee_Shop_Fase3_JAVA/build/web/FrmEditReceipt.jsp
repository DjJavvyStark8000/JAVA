<%-- 
    Document   : FrmEditReceipt
    Created on : Oct 27, 2023, 9:02:50 AM
    Author     : djjav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Config.Substracting"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/editreceipt.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/editreceipts.js" type="text/javascript"></script>
        <title>JSP Page</title>

    </head>
    <body>
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
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="FrmReceipts.jsp">Facturación</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <div class="main-container">

            <div class="tabla-titulo">Editar de Facturas</div>
            <%
                Object[] firstRow = Substracting.clientReceipts.get(0);

            %>
           
                <table>
                    <tr>
                        <th>ID_FACTURA</th>
                        <td><input type="text" id="id_factura" value="<%=firstRow[0]%>" disabled></td>
                    </tr>
                    <tr>
                        <th>CLIENTE</th>
                        <td><input type="text" id="cliente" value="<%=firstRow[1]%>" disabled></td>
                    </tr>
                    <tr>
                        <th>ID_CLIENTE</th>
                        <td><input type="text" id="id_cliente" value="<%=firstRow[2]%>" disabled></td>
                    </tr>
                    <tr>
                        <th>FECHA</th>
                        <td><input type="text" id="fecha" value="<%=firstRow[3]%>"></td>
                    </tr>
                    <tr>
                        <th>IMPUESTO</th>
                        <td><input type="text" id="impuesto" value="<%=firstRow[4]%>"></td>
                    </tr>
                    <tr>
                        <th>DESCUENTO</th>
                        <td><input type="text" id="descuento" value="<%=firstRow[5]%>"></td>
                    </tr>
                    <tr>
                        <th>TOTAL</th>
                        <td><input type="text" id="total" value="<%=firstRow[6]%>"></td>
                    </tr>
                </table><br>
                <input type="submit" id="btnGuardar" name="btnGuardar" value="Guardar" onclick="overWrite()"/>
            
        </div>
        <div class="message">
            Versión móvil no disponible
        </div>
    </body>
</html>
