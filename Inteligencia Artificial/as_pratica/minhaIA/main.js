// Representa um estado do tabuleiro como matriz.
const initialState = [
    [0, -1, 0, -1, 0, -1, 0, -1],
    [-1, 0, -1, 0, -1, 0, -1, 0],
    [0, -1, 0, -1, 0, -1, 0, -1],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1, 0, 1, 0],
    [0, 1, 0, 1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1, 0, 1, 0]
  ];
  
  // Função para copiar o estado do tabuleiro.
  function copyBoard(board) {
    return board.map(row => [...row]);
  }
  
  // Avalia o tabuleiro. Retorna um valor numérico baseado na vantagem do jogador.
  function evaluateBoard(board) {
    let score = 0;
    for (let row of board) {
      for (let cell of row) {
        if (cell === 1) score += 1; // Peão do jogador
        if (cell === -1) score -= 1; // Peão do oponente
      }
    }
    return score;
  }
  
  // Gera todos os movimentos possíveis para um jogador.
  function generateMoves(board, player) {
    const moves = [];
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[i].length; j++) {
        if (board[i][j] === player) {
          // Adiciona movimentos simples e capturas (exemplo básico)
          const directions = player === 1 ? [[-1, -1], [-1, 1]] : [[1, -1], [1, 1]];
          for (let [di, dj] of directions) {
            const newRow = i + di;
            const newCol = j + dj;
            if (
              newRow >= 0 &&
              newRow < board.length &&
              newCol >= 0 &&
              newCol < board[0].length &&
              board[newRow][newCol] === 0
            ) {
              const newBoard = copyBoard(board);
              newBoard[i][j] = 0;
              newBoard[newRow][newCol] = player;
              moves.push(newBoard);
            }
          }
        }
      }
    }
    return moves;
  }
  
  // Implementação do algoritmo Minimax.
  function minimax(board, depth, isMaximizingPlayer) {
    if (depth === 0) {
      return evaluateBoard(board);
    }
  
    const player = isMaximizingPlayer ? 1 : -1;
    const moves = generateMoves(board, player);
  
    if (isMaximizingPlayer) {
      let maxEval = -Infinity;
      for (let move of moves) {
        const eval = minimax(move, depth - 1, false);
        maxEval = Math.max(maxEval, eval);
      }
      return maxEval;
    } else {
      let minEval = Infinity;
      for (let move of moves) {
        const eval = minimax(move, depth - 1, true);
        minEval = Math.min(minEval, eval);
      }
      return minEval;
    }
  }
  
  // Seleciona o melhor movimento para o jogador.
  function findBestMove(board, depth) {
    let bestMove = null;
    let bestValue = -Infinity;
    const moves = generateMoves(board, 1);
  
    for (let move of moves) {
      const moveValue = minimax(move, depth - 1, false);
      if (moveValue > bestValue) {
        bestValue = moveValue;
        bestMove = move;
      }
    }
  
    return bestMove;
  }
  
  // Exemplo de uso:
  console.log("Estado inicial:", initialState);
  const bestMove = findBestMove(initialState, 3);
  console.log("Melhor movimento:", bestMove);
  