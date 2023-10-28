function overWrite() {
    var idFactura = document.getElementById("id_factura").value;
    var theCliente = document.getElementById("cliente").value;
    var idCliente = document.getElementById("id_cliente").value;
    var theFecha = document.getElementById("fecha").value;
    var theImpuesto = document.getElementById("impuesto").value;
    var theDescuento = document.getElementById("descuento").value;
    var theTotal = document.getElementById("total").value;

    var url = "ReceiptOverWrite"; // Update the URL accordingly

    var data = new URLSearchParams({
        'id_factura': idFactura,
        'cliente': theCliente,
        'id_cliente': idCliente,
        'fecha': theFecha,
        'impuesto': theImpuesto,
        'descuento': theDescuento,
        'total': theTotal
    });

    fetch(url, {
        method: 'POST', // Change the method if necessary
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' // Adjust content type if needed
        },
        body: data
    })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                if (data) {
                    document.getElementById("fecha").disabled = true;
                    document.getElementById("impuesto").disabled = true;
                    document.getElementById("descuento").disabled = true;
                    document.getElementById("total").disabled = true;
                    document.getElementById("btnGuardar").disabled = true;
                    // Change the background color to white
                    document.getElementById("fecha").style.color = "white";
                    document.getElementById("impuesto").style.color = "white";
                    document.getElementById("descuento").style.color = "white";
                    document.getElementById("total").style.color = "white";                   
                    alert("Registro editado con éxito");
                }

            })
            .catch(error => {
                console.error("Error:", error);
            });
}

