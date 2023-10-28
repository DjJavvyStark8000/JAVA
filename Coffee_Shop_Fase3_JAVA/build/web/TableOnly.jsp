<%-- 
    Document   : TableOnly
    Created on : Oct 19, 2023, 3:42:07 PM
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
        <link href="assets/css/tableframe.css" rel="stylesheet" type="text/css"/>
        <title>Productos</title>
    </head>
    <body>
        
        <table border="1" class="tabla-productos" id="virtualreceipt">
            <thead>
                <tr>
                    <th>CANTIDAD</th>
                    <th>PRODUCTO</th>
                    <th>TAMAÑO</th>
                    <th>PRECIO/U</th>
                    <th>SUBTOTAL</th>
                </tr>
            </thead>
            <tbody>
                <%                            if (Substracting.getIsReseting()) {
                        for (Object[] item : Substracting.receiptLines) {
                %>
                <tr>
                    <td><%= item[0]%></td>
                    <td><%= item[1]%></td>
                    <td><%= item[2]%></td>
                    <td><%= item[3]%></td>
                    <td><%= item[4]%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table><br>
    </body>
</html>
