/**
 * Enumeration used for the state of a piece in the Game of Life.
 * @author lisawhite
 *
 */
public enum PieceState {
	
	DEAD(0), ALIVE(1);
	
	private int value;

    private PieceState(int value) {
        this.value = value;
    }
    
    public int getStateValue() {
    	return this.value;
    }

}
