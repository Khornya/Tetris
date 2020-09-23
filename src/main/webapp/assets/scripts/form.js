(() => {
    console.log(oldMatrix);
    // oldMatrix = [[1,0,0],[1,0,0],[1,0,0]];

    let createGrid = (size) => {
        let grid = document.getElementById("grid");
        grid.innerHTML = "";
        let line;
        for (let i = 0; i < size; i++) {
            line = document.createElement("div");
            line.className = "line";
            grid.appendChild(line);
            cells.push([]);
            for (let j = 0; j < size; j++) {
                cells[i].push(document.createElement("div"));
                cells[i][j].className = "cell";
                cells[i][j].style.backgroundColor = "white";
                cells[i][j].addEventListener("click", () => {
                    toggleValue(i,j);
                    toggleColor(cells[i][j])
                });
                line.appendChild(cells[i][j]);
            }
        }
        return cells.map(line => line.map(() => 0));
    };

    let toggleColor = (cell) => {
        cell.style.backgroundColor === "white" ? cell.style.backgroundColor = "blue" : cell.style.backgroundColor = "white";
    };

    function toggleValue(i,j) {
        matrix[i][j] === 0 ? matrix[i][j] = 1 : matrix[i][j] = 0
    }

    let dropdown = document.getElementById("size");
    dropdown.addEventListener("change", () => {
        matrix = createGrid()
    });

    let matrix;
    let cells = [];
    if (oldMatrix !== null) {
        let size = oldMatrix.length;
        matrix = createGrid(size);
        for (let i = 0; i < size; i++) {
            for (let j = 0; j < size; j++) {
                if (oldMatrix[i][j] === 1) {
                    toggleValue(i, j);
                    toggleColor(cells[i][j]);
                }
            }
        }
    } else {
        matrix = createGrid(dropdown.options[dropdown.selectedIndex].value);
    }

    let form = document.querySelector("form");
    form.addEventListener("submit", (e) => {
        e.preventDefault();
        // document.getElementById("matrix").value = JSON.stringify(matrix);
        let name = document.getElementById("name").value;
        document.getElementById("piece").value = {
            "name": name,
            "matrix": matrix
        };
        form.submit();
    });
})();