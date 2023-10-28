window.addEventListener('load', function () {
    const hasReloaded = localStorage.getItem('hasReloaded');

    if (!hasReloaded) {
        // First reload on page load
        // window.location.reload();
        loadReceiptsFromDB();

        // Set a flag in local storage to indicate the first reload
        localStorage.setItem('hasReloaded', 'true');

        // After the first reload, you can add a delay if needed
        setTimeout(function () {
            // Second reload
            window.location.reload();
        }, 1000); // Wait 
    } else {
        localStorage.removeItem('hasReloaded');
    }
});

function loadReceiptsFromDB() {
    fetch("LoadReceipts")
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

function eraceThisReceipt(dataValue) {
    if (window.confirm("¿Seguro desea eliminar este registro?")) {
        // Append a random query parameter to the URL to avoid caching
        const randomQueryParam = "nocache=" + Math.random();
        const url = "DeleteReceipt?theID=" + dataValue + "&" + randomQueryParam;

        fetch(url)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    } else {
                        throw new Error("Failed to fetch data from the servlet.");
                    }
                })
                .then(data => {
                    if (data == 1) {
                        alert("Dato eliminado con éxito");
                        loadReceiptsFromDB();
                        setTimeout(() => {
                            window.location.replace("FrmReceipts.jsp");
                        }, 2000); // Wait for 2 seconds before executing the code
                    }
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    } else {
        alert("Registro no fue eliminado");
    }
}
function editThisReceipt(dataValue) {

    //send the id to my array at the same time i load the contents
    fetch("EditReceipt?editReceipt=" + dataValue)
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                if (data) {
                    window.location.href = "FrmEditReceipt.jsp";
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
}

function setCondition() {
    var theCondition = document.getElementById("txtBuscar").value;
    
    // Check if the value is numeric
    if (!isNaN(theCondition)) {
        //send the id to my array at the same time i load the contents
    fetch("SetCondition?theCondition=" + theCondition)
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                if (data) {
                    window.location.replace("FrmReceipts.jsp");

                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    } else {
       //send the id to my array at the same time i load the contents
    fetch("SetCondition?theCondition=" + theCondition + "'")
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                if (data) {
                    window.location.replace("FrmReceipts.jsp");

                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }
   
}