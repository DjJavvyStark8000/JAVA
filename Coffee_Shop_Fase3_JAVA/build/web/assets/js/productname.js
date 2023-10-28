
var links = document.querySelectorAll(".square-box.coffee");

links.forEach(function (link) {
    link.addEventListener("click", function (event) {
        event.preventDefault();

        var nameProduct = this.getAttribute("href").split('=')[1].trim(); // Trim the product name

        fetch("NameAsigment?nameProduct=" + nameProduct)
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
            })
            .then(data => {
               // alert("Response from the server: " + data);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
});


