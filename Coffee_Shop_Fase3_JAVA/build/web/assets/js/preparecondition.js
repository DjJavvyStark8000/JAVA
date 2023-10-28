// Add event listeners to the radio buttons
document.getElementById('radioID').addEventListener('click', function () {
    radioIDClicked('EF.ID_FACTURA = ');
});

document.getElementById('radioClient').addEventListener('click', function () {
    radioClientClicked('NOMBRE_CLIENTE = \'');
});

function radioIDClicked(halfCondition) {
    let button = document.getElementById("btnBuscar");
    button.disabled = false;
    fetch("SetHalfCondition?halfCondition=" + halfCondition)
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {

            })
            .catch(error => {
                console.error("Error:", error);
            });
}

function radioClientClicked(halfCondition) {
    let button = document.getElementById("btnBuscar");
    button.disabled = false;
    fetch("SetHalfCondition?halfCondition=" + halfCondition)
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                //alert(data);
            })
            .catch(error => {
                console.error("Error:", error);
            });
}

function refrescar() {
    fetch("CleanCondition")
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {

                window.location.replace("FrmReceipts.jsp");

            })
            .catch(error => {
                console.error("Error:", error);
            });
}
