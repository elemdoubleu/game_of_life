import java.lang.IllegalArgumentException;

/**
 * Board of pieces used for the Game of Life.
 * @author lisawhite
 *
 */
public class GameBoard {
	
	PieceState[][] currentBoard; 
	
	/**
	 * Create a GameBoard object
	 * @param board 2D Array of Pieces
	 */
	public GameBoard(PieceState[][] board) {
		
		currentBoard = board;
	}
	
	/**
	 * Get the number of rows in the GameBoard
	 * @return Number of rows in GameBoard
	 */
	public int numRows() {
		return currentBoard.length;
	}
	
	/**
	 * Get the number of columns in the GameBoard
	 * @return Number of columns in the GameBoard
	 */
	public int numCols() {
		if (currentBoard.length == 0)
			return 0;
		return currentBoard[0].length; 
	}
	
	/**
	 * Get the state of the requested piece location
	 * @param row Row of the location of the requested piece
	 * @param col Column of the location of the requested piece
	 * @return The state of the requested piece location
	 */
	public PieceState getPieceState(int row, int col)  {
		
		validatePieceLocation(row, col);
		
		return currentBoard[row][col];
	}
	
	/**
	 * Get the number of alive neighbors of the requested piece location.
	 * @param row Row of the location of the requested piece
	 * @param col Column of the location of the requested piece
	 * @return Number of alive neighbors of the requested piece location.
	 */
	public int aliveNeighbors(int row, int col) 
	{
		validatePieceLocation(row, col);
		
		int numRows = currentBoard.length;
		int numCols = (currentBoard.length > 0) ? currentBoard[0].length : 0; 
		
		int startRow = (row == 0) ? 0: row-1 ;
		int endRow = (row == numRows-1) ? numRows-1 : row+1;
		int startCol = (col == 0) ? 0 : col-1;
		int endCol = (col == numCols-1) ? numCols-1 : col+1;
		
		int aliveNeighbors = 0;
		
		for (int i= startRow; i<=endRow; i++)
		{	
			for (int j=startCol; j<= endCol; j++)
			{
				// Skip current Piece in neighbors
				if(i==row && j==col)
					continue;
				
				if (currentBoard[i][j] == PieceState.ALIVE)
					aliveNeighbors++;	
			}
		}
		
		return aliveNeighbors;
	}
	
	/**
	 * Validates the specified row and column are within range of the board
	 * @param row Row of the piece location
	 * @param col Column of the piece location
	 */
	private void validatePieceLocation(int row, int col) {
		if (row < 0 || row >= numRows())
			throw new IllegalArgumentException("Invalid row: value is outside of board bounds");
		if (col < 0 || col >= numCols())
			throw new IllegalArgumentException("Invalid col: value is outside of board bounds");
	}
	
	/**
	 * Determines the state of current piece in the next generation of the GameBoard 
	 * based on the Game of Life rules.
	 * @param currentState The dead/alive state of the current piece
	 * @param aliveNeighbors The number of alive neighbors of the current piece
	 * @return State of current piece in the next generation of the GameBoard
	 */
	private static PieceState determineNextPieceState(PieceState currentState, int aliveNeighbors)
	{
		PieceState nextState = currentState;
		
		if (currentState == PieceState.ALIVE)
		{
			if (aliveNeighbors == 2 || aliveNeighbors == 3)
				nextState = PieceState.ALIVE;
			else
				nextState = PieceState.DEAD;
		}
		else if (currentState == PieceState.DEAD)
		{
			if (aliveNeighbors == 3)
				nextState = PieceState.ALIVE;
			else
				nextState = PieceState.DEAD;
		}
		
		return nextState;
	}
	
	/**
	 * Generates a new GameBoard for the next generation of the Game based on the current state
	 * @return Next generation game board.
	 */
	public GameBoard nextGeneration() 
	{
		
		PieceState[][] nextGeneration = new PieceState[this.numRows()][this.numCols()];

		for (int i=0; i<this.numRows(); i++)
		{
			for(int j=0; j<this.numCols(); j++)
			{
				int aliveNeighbors = this.aliveNeighbors(i,j);
				
				PieceState currentPieceState = this.getPieceState(i, j);
				
				nextGeneration[i][j] = determineNextPieceState(currentPieceState, aliveNeighbors);
			}
		}
		
		return new GameBoard(nextGeneration);
	}
	
	/**
	 * Prints the current game board to the screen.
	 */
	public void print()
	{
		for (int i=0; i<currentBoard.length; i++)
		{
			for(int j=0; j<currentBoard[0].length; j++)
			{
				System.out.print(currentBoard[i][j].getStateValue());
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}

}
