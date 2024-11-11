// script.js


function searchTable() {
    let input = document.getElementById("search");
    let filter = input.value.toLowerCase();
    let table = document.getElementById("alumnoTable");
    let rows = table.getElementsByTagName("tr");
  
    for (let i = 1; i < rows.length; i++) {
      let cells = rows[i].getElementsByTagName("td");
      let match = false;
  
      // Recorre todas las celdas de la fila para buscar coincidencias
      for (let j = 0; j < cells.length - 1; j++) {
        let cell = cells[j];
        if (cell) {
          let text = cell.textContent || cell.innerText;
          if (text.toLowerCase().indexOf(filter) > -1) {
            match = true;
            break;
          }
        }
      }
  
      // Muestra o esconde la fila dependiendo si encontró coincidencias
      rows[i].style.display = match ? "" : "none";
    }
  }
  