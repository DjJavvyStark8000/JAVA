

//disable receipt button
window.onload = pageLoad;

function pageLoad() {
    const updateButton = document.getElementById("updateButton");
    updateButton.disabled = true;
}

function loadProductsID() {
    fetch("GrabProductID")
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Failed to fetch data from the servlet.");
                }
            })
            .then(data => {
                //alert("Info: " + "\n" + data);
            })
            .catch(error => {
                console.error("Error:", error);
            });

}

function enableAddButton() {
    const updateButton = document.getElementById("updateButton");
    updateButton.disabled = false;
}

//green borders on click
$(document).ready(function () {
// Attach a click event handler to all elements with class "coffee"
    $(".coffee").click(function () {
// Remove the "green-border" class from all elements with class "coffee"
        $(".coffee").removeClass("green-border");
        // Add the "green-border" class to the clicked element
        $(this).addClass("green-border");
    });
});
async function refreshPage() {

    try {
        await loadProductsID();
        await ghostReceipt();
        await fetch("ResetState?resetState=1");
        const unitPriceResponse = await fetch("SaleUnitPrice?");
        if (unitPriceResponse.ok) {
            const unitPriceData = await unitPriceResponse.text();
        } else {
            // Handle the error case for unitPriceResponse here
        }
        const subtotalResponse = await fetch("SaleSubTotal?");
        if (subtotalResponse.ok) {
            const subtotalData = await subtotalResponse.text();
        }


        const virtualReceiptResponse = await fetch("VirtualReceipt");
        if (virtualReceiptResponse.ok) {
            const id = await virtualReceiptResponse.text();
            // alert(id);
        } else {
            // Handle the error case for virtualReceiptResponse here
        }

        //refresh table frame
        refreshTableFrame();
        resetDetails();//combo boxes reset

        const bruteTotalResponse = await fetch("BruteTotal?");
        if (bruteTotalResponse.ok) {
            const bruteTotalData = await bruteTotalResponse.text();
            //alert(bruteTotalData);
            const bruteSpan = document.getElementById("totalbrute");
            bruteSpan.textContent = " " + bruteTotalData;
        } else {
            // Handle the error case for virtualReceiptResponse here
        }

        const taxTotalResponse = await fetch("TaxTotal?");
        if (taxTotalResponse.ok) {
            const taxTotalData = await taxTotalResponse.text();
            //alert(taxTotalData);
            const taxSpan = document.getElementById("totaltax");
            taxSpan.textContent = " " + taxTotalData;
        } else {
            // Handle the error case for virtualReceiptResponse here
        }

        const discountTotalResponse = await fetch("DiscountTotal?");
        if (discountTotalResponse.ok) {
            const discountTotalData = await discountTotalResponse.text();
            //alert(discountTotalData);
            const discountSpan = document.getElementById("totaldiscount");
            discountSpan.textContent = " " + discountTotalData;
        } else {
            // Handle the error case for virtualReceiptResponse here
        }

        const netTotalResponse = await fetch("NetTotal?");
        if (netTotalResponse.ok) {
            const netTotalData = await netTotalResponse.text();
            const netSpan = document.getElementById("totalnet");
            netSpan.textContent = " " + netTotalData;
        } else {
            // Handle the error case for virtualReceiptResponse here
        }

    } catch (error) {
        console.error("Error:", error);
    }
}

//send cup size
function selectedSize() {

    enableAddButton();
    var selectElement = document.getElementById("tamano");
    selectElement.addEventListener("change", function () {
        var selectedValue = selectElement.value;
        var selectedIndex;
        if (selectedValue === "Pequeño") {
            selectedIndex = 1;
        } else if (selectedValue === "Mediano") {
            selectedIndex = 2;
        } else {
            selectedIndex = 3;
        }

        fetch("SaleSize?sizeProduct=" + selectedIndex)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                })
                .then(data => {
                    console.log(data);
                    //  alert("Product size set to: " + data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    });
}

//send quantity
function selectedQuantity() {

    enableAddButton();
    var selectElement = document.getElementById("cantidad");
    selectElement.addEventListener("change", function () {
        var selectedValue = selectElement.value;
        fetch("SaleQuantity?productQuantity=" + selectedValue)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                })
                .then(data => {
                    // Show an alert with the response
                    //  alert("Product quantity set to: " + data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    });
}

//send quantity
function selectedSugars() {
    var selectElement = document.getElementById("azucar");
    selectElement.addEventListener("change", function () {
        var selectedValue = selectElement.value;
        fetch("SugarSale?productSugar=" + selectedValue)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                })
                .then(data => {
                    // Show an alert with the response
                    //alert("Product sugar set to: " + data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    });
}

//send quantity
function selectedCreams() {
    var selectElement = document.getElementById("crema");
    selectElement.addEventListener("change", function () {
        var selectedValue = selectElement.value;
        fetch("CreamSale?productCream=" + selectedValue)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                })
                .then(data => {
                    // Show an alert with the response
                    //alert("Product cream set to: " + data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    });
}

//send quantity
function selectedMilks() {
    var selectElement = document.getElementById("leche");
    selectElement.addEventListener("change", function () {
        var selectedValue = selectElement.value;
        fetch("MilkSale?productMilk=" + selectedValue)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                })
                .then(data => {
                    // Show an alert with the response
                    //alert("Product milk set to: " + data);
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    });
}

//ghost receipt maker
function ghostReceipt() {
    fetch("GhostReceipt")
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
            })
            .then(data => {
                // Update the content of the span with the received ID
                const receiptSpan = document.getElementById("thereceipt");
                const detailSpan = document.getElementById("thedetail");
                if (receiptSpan && detailSpan) {
                    receiptSpan.textContent = " " + data;
                    detailSpan.textContent = " " + data;
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
}

function resetDetails(){
    const tamanoSelect = document.getElementById("tamano");
    tamanoSelect.value = "";
    const quantitySelect = document.getElementById("cantidad");
    quantitySelect.value = "0";
    const sugarSelect = document.getElementById("azucar");
    sugarSelect.value = "0";
    const creamSelect = document.getElementById("crema");
    creamSelect.value = "0";
    const milkSelect = document.getElementById("leche");
    const updateButton = document.getElementById("updateButton");
    updateButton.disabled = true;
}

//clean form and clean variables by servlet html level
function cleanForm() {
// Clear or reset items
    const tamanoSelect = document.getElementById("tamano");
    tamanoSelect.value = "0";
    const receiptSpan = document.getElementById("thereceipt");
    receiptSpan.textContent = " 000000";
    const detailSpan = document.getElementById("thedetail");
    detailSpan.textContent = " 000000";
    const quantitySelect = document.getElementById("cantidad");
    quantitySelect.value = "0";
    const sugarSelect = document.getElementById("azucar");
    sugarSelect.value = "0";
    const creamSelect = document.getElementById("crema");
    creamSelect.value = "0";
    const milkSelect = document.getElementById("leche");
    milkSelect.value = "0";
    const updateButton = document.getElementById("updateButton");
    updateButton.disabled = true;
    const bruteSpan = document.getElementById("totalbrute");
    bruteSpan.textContent = " 000000";
    const taxSpan = document.getElementById("totaltax");
    taxSpan.textContent = " 000000";
    const discountSpan = document.getElementById("totaldiscount");
    discountSpan.textContent = " 000000";
    const netSpan = document.getElementById("totalnet");
    netSpan.textContent = " 000000";
    //after the servlet clean the array then refresh the iframe table
    fetch("CleanForm?")
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
            })
            .then(data => {
                // refresh the iframe here
                refreshTableFrame();
            })
            .catch(error => {
                console.error("Error:", error);
            });
}

function refreshTableFrame() {
    const updateButton = document.getElementById("updateButton");
    updateButton.disabled = true;
    // Get a reference to the iframe element by its class name
    var iframe = document.querySelector(".tableframe");
    // Set the 'scrolling' attribute to 'yes' to enable scrolling
    iframe.setAttribute("scrolling", "yes");
    // Refresh the content within the iframe by changing the src attribute
    iframe.src = iframe.src;
}



function grabNewClientInfo() {
    // Get the input elements by their ids
    var inputEmail = document.getElementById("txtcorreo");
    var inputName = document.getElementById("txtcliente");

    // Get the values the user typed in both fields
    var typedEmail = inputEmail.value;
    var typedName = inputName.value;

    // Check if the typed values are not empty
    if (typedEmail.trim() !== "" && typedName.trim() !== "") {
        // You should consider encoding the user input to prevent XSS attacks
        var encodedEmail = encodeURIComponent(typedEmail);
        var encodedName = encodeURIComponent(typedName);

        // Send the request to the servlet with both values
        fetch("SendToDataBase?userEmail=" + encodedEmail + "&userName=" + encodedName)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    } else {
                        throw new Error("Response not OK");
                    }
                })
                .then(data => {
                    alert("Almacenado con éxito");
                    cleanForm();
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    } else {
        fetch("SendToDataBase?userEmail=" + "ghost@format.com" + "&userName=" + "Cliente")
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    } else {
                        throw new Error("Response not OK");
                    }
                })
                .then(data => {
                    alert("Almacenado con éxito");
                    cleanForm();
                })
                .catch(error => {
                    console.error("Error:", error);
                });
    }
}














