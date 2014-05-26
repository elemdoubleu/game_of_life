import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAliveNeighbors_With0AliveNeighbors_Returns0() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.DEAD},	
				{PieceState.DEAD, PieceState.DEAD}	
		};
		
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		//Act
		int aliveNeighbors = currentBoard.aliveNeighbors(0, 0);
			
		//Assert
		Assert.assertEquals(0, aliveNeighbors);
		
	}
	
	@Test
	public void testAliveNeighbors_With2AliveNeighbors_Returns2() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.DEAD, PieceState.ALIVE}	
		};
		
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		//Act
		int aliveNeighbors = currentBoard.aliveNeighbors(0, 0);
			
		//Assert
		Assert.assertEquals(2, aliveNeighbors);
		
	}
	
	@Test
	public void testAliveNeighbors_With4AliveNeighbors_Returns4() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.DEAD, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE}
		};
		
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		//Act
		int aliveNeighbors = currentBoard.aliveNeighbors(2, 1);
			
		//Assert
		Assert.assertEquals(4, aliveNeighbors);
		
	}
	

	@Test
	public void testNextGeneration_With1LiveCell_CellDies() {
		
		//Arrange
		PieceState[][] currentGameBoard = new PieceState[1][1];
		currentGameBoard[0][0] =PieceState.ALIVE;
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		PieceState[][] expectedNextGameBoard = new PieceState[1][1];
		expectedNextGameBoard[0][0] = PieceState.DEAD;
		GameBoard expectedNextBoard = new GameBoard(expectedNextGameBoard);
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(expectedNextBoard.getPieceState(0, 0), nextGenerationBoard.getPieceState(0, 0));
		
	}
	
	@Test
	public void testNextGeneration_With4LiveCells_CellsLive() {
		
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.ALIVE, PieceState.ALIVE}	
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		PieceState[][] expectedNextGameBoard =
		{
			{PieceState.ALIVE, PieceState.ALIVE},	
			{PieceState.ALIVE, PieceState.ALIVE}	
		};
		GameBoard expectedNextBoard = new GameBoard(expectedNextGameBoard);
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		for (int i=0; i<nextGenerationBoard.numRows(); i++)
		{
			for(int j=0; j<nextGenerationBoard.numCols(); j++)
			{
				Assert.assertEquals(expectedNextBoard.getPieceState(i, i), nextGenerationBoard.getPieceState(i, j));
			}
		}
		
	}
	
	
	
	@Test
	public void testNextGeneration_With1Live0LiveNeighbors_CellDies() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.DEAD},	
				{PieceState.DEAD, PieceState.DEAD}	
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(PieceState.DEAD, nextGenerationBoard.getPieceState(0, 0));
		
	}
	
	@Test
	public void testNextGeneration_WithLive2LiveNeighbors_CellLives() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.DEAD, PieceState.DEAD, PieceState.DEAD},
				{PieceState.DEAD, PieceState.DEAD, PieceState.DEAD}
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(PieceState.ALIVE, nextGenerationBoard.getPieceState(0, 1));
		
	}
	
	@Test
	public void testNextGeneration_WithLive3LiveNeighbors_CellLives() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD},
				{PieceState.DEAD, PieceState.DEAD, PieceState.DEAD}
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(PieceState.ALIVE, nextGenerationBoard.getPieceState(0, 1));
		
	}
	
	@Test
	public void testNextGeneration_WithLive4LiveNeighbors_CellDies() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.DEAD},
				{PieceState.DEAD, PieceState.DEAD, PieceState.DEAD}
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(PieceState.DEAD, nextGenerationBoard.getPieceState(0, 1));
		
	}
	
	@Test
	public void testNextGeneration_WithDead3LiveNeighbors_CellLives() {
		//Arrange
		PieceState[][] currentGameBoard = 
		{
				{PieceState.ALIVE, PieceState.ALIVE, PieceState.ALIVE},	
				{PieceState.DEAD, PieceState.ALIVE, PieceState.DEAD},
				{PieceState.DEAD, PieceState.DEAD, PieceState.DEAD}
		};
		GameBoard currentBoard = new GameBoard(currentGameBoard);
		
		//Act
		GameBoard nextGenerationBoard = currentBoard.nextGeneration();
		
		//Assert
		Assert.assertEquals(PieceState.ALIVE, nextGenerationBoard.getPieceState(1, 2));
		
	}
	

}
