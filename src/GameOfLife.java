
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
		
		// Print first generation
		GameBoard currentBoard = new GameBoard(currentGameBoard);	
		System.out.println("Generation 1:");
		currentBoard.print();
		System.out.println();
		
		// Print generations 2 to 5
		for (int i=2; i<=5; i++)
		{
			currentBoard = currentBoard.nextGeneration();
			System.out.println("\nGeneration " + i + ":");
			currentBoard.print();
			System.out.println();
		}
		
	}

}
