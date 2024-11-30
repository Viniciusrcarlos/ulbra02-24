let red = 1;
let empty = 0;
let black = -1;
let cell_width = 0;
let board_origin = 0;

function inicializarTabuleiro() {
    let tabuleiroInicial = [
        [red, empty, red, empty, red, empty, red, empty],
        [empty, red, empty, red, empty, red, empty, red],
        [red, empty, red, empty, red, empty, red, empty],
        [empty, empty, empty, empty, empty, empty, empty, empty],
        [empty, empty, empty, empty, empty, empty, empty, empty],
        [empty, black, empty, black, empty, black, empty, black],
        [black, empty, black, empty, black, empty, black, empty],
        [empty, black, empty, black, empty, black, empty, black],
    ];

    let cells = [];
    let pieces = [];

    for (let i = 0; i < tabuleiroInicial.length; i++) {
        let row = tabuleiroInicial[i];

        for (let j = 0; j < row.length; j++) {
            let colValue = row[j];
            if (colValue != empty) {
                let piece = {row: i, col: j, state: colValue};
                pieces.push(piece);
            }
            let cell = {row: i, col: j, state: colValue};
            cells.push(cell);
        }
        return {cells: cells, pieces: pieces, turn: red};
    }
}

function drawD3Script(tabuleiro) {
    tabuleiro.append("g")
				.selectAll("rect")
				.data(cells)
				.enter().append("rect")
				.attr("x", function(d) { return mapCellToCoordinates(origin, cellWidth, d).x})
				.attr("y", function(d) { return mapCellToCoordinates(origin, cellWidth, d).y})
				.attr("height", cellWidth)
				.attr("width", cellWidth)
				.style("fill", "white")
				.style("stroke", "black")
				.style("stroke-width", "1px");

	//Draw pieces
	var dragEndedDimensions = function(d) {
		node = d3.select(this);
		dragEnded(origin, cellWidth, node, d);
	}

	var drag = d3.drag()
					.on("start", dragStarted)
					.on("drag", dragged)
					.on("end", dragEndedDimensions);

    tabuleiro.append("g")
				.selectAll("circle")
				.data(pieces)
				.enter().append("circle")
				.attr("r", cellWidth/2)
				.attr("cx", function(d) { var x = mapCellToCoordinates(origin, cellWidth, d).x; return x+cellWidth/2;})
				.attr("cy", function(d) { var y = mapCellToCoordinates(origin, cellWidth, d).y; return y+cellWidth/2;})
				.style("fill", function(d) { if (d.state == red) return "red"; else return "black";})
				.call(drag)
				;

	//Draw scoreboard
	d3.select("#divScoreboard").remove();
	d3.select("body").append("div")
				.attr("id", "divScoreboard")
				.style("font-size", "36")
				.html("SCOREBOARD")

	d3.select("#divScoreboard")
		.append("div")
		.style("font-size", "24")
		.attr("id", "winner");

	d3.select("#divScoreboard")
				.append("div")
				.attr("id", "redScore")
				.style("font-size", "18")
				.html("Red: 12")

	d3.select("#divScoreboard")
				.append("div")
				.attr("id", "blackScore")
				.style("font-size", "18")
				.html("Black: 12")
				;
}

function desenhaTabuleiro(origin, cellWidth, tabuleiro) {
    let boardState = inicializarTabuleiro();
    let cells = boardState.cells;
    let pieces = boardState.pieces;

    drawD3Script(tabuleiro);
}

function mostraTabuleiroAtual() {
    d3.selectAll("text").each(function (d, i) {
        d3.select(this).style("display", "none");
    });

    let cells = tabuleiroAtual.cells;
    let pieces = tabuleiroAtual.pieces;

    drawText(pieces);
}

function novoJogo(origin, cellWidth, tabuleiro) {
    movePiece.moves = [];
    d3.select("#btnReplay").style("display", "none");
    cell_width = cellWidth;
    board_origin = origin;
    tabuleiroAtual = desenhaTabuleiro(origin, cellWidth, tabuleiro);
    tabuleiro.ui = true;
    mostraTabuleiroAtual();
}