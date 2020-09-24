(() => {
    const COLORS = ['blue','yellow','pink', 'green'];
    const ROWS = 10;
    const COLS = 20;

    let gridCells = [];
    let currentPiece = {
        xposition: 0,
        yposition: 0,
        matrix: []
    };

    let createGrid = (rows,cols) => {
        let grid = document.getElementById("grid");
        let line;
        for (let i = 0; i < cols; i++) {
            line = document.createElement("div");
            line.className = "line";
            grid.appendChild(line);
            gridCells.push([]);
            for (let j = 0; j < rows; j++) {
                gridCells[i].push(document.createElement("div"));
                gridCells[i][j].className = "cell";
                gridCells[i][j].style.backgroundColor = "black";
                line.appendChild(gridCells[i][j]);
            }
        }
    };

    let selectRandomPieceMatrix = (pieces) => {
        return pieces[Math.floor(Math.random() * pieces.length)].matrix;
    };

    let putCurrentPieceOnGrid = (color) => {
        for (let i = 0; i < currentPiece.matrix.length; i++) {
            for (let j = 0; j < currentPiece.matrix.length; j++) {
                if (currentPiece.matrix[i][j] === 1) {
                    gridCells[i + currentPiece.yposition][j + currentPiece.xposition].style.backgroundColor = color;
                }
            }
        }
    };

    createGrid(ROWS,COLS);

    setInterval(() => {
        putCurrentPieceOnGrid('black');
        currentPiece.matrix = selectRandomPieceMatrix(pieces);
        currentPiece.color = COLORS[Math.floor(Math.random() * COLORS.length)];
        currentPiece.xposition = Math.floor((ROWS - currentPiece.matrix.length) / 2);
        currentPiece.yposition = 0;
        putCurrentPieceOnGrid(currentPiece.color);
    }, 1000)
})();