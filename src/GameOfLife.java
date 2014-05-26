
public class GameOfLife {
	
	public static void main(String[] args) {

		PieceState[][] currentGameBoard = 
			{
					{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD},	
					{PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE, PieceState.ALIVE},
					{PieceState.ALIVE, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE},
					{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD},	
					{PieceState.ALIVE, PieceState.DEAD, PieceState.DEAD, PieceState.DEAD, PieceState.ALIVE}
			};
		GameBoard currentBoard = new GameBoard(currentGameBoard);	
		currentBoard.print();
		System.out.println();
		
		GameBoard SecondGenerationBoard = currentBoard.nextGeneration();
		SecondGenerationBoard.print();
		System.out.println();
		
		GameBoard ThirdGenerationBoard = SecondGenerationBoard.nextGeneration();
		ThirdGenerationBoard.print();
		System.out.println();
		
	}

}
