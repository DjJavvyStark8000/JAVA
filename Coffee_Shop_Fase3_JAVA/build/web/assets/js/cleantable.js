function cleanTable(){
    // Clear all rows from the <tbody>
    var tbody = document.querySelector('.tabla-productos tbody');
    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }
}
