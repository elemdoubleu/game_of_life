
public class GameOfLife {
	
	public static void main(String[] args) {

		// Setup example GameBoard
		PieceState[][] currentGameBoard = 
			{
					{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD},	
					{PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE, PieceState.ALIVE},
					{PieceState.ALIVE, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE},
					{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD},	
					{PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE}
			};
		
		// Create first generation GameBoard
		GameBoard currentBoard = new GameBoard(currentGameBoard);	
		
		// Print generations 1 to 5
		for (int i=1; i<=5; i++)
		{	
			System.out.println("\nGeneration " + i + ":");
			currentBoard.print();
			System.out.println();
			currentBoard = currentBoard.nextGeneration();
		}
		
	}

}
