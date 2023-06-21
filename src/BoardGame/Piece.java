package BoardGame;

public class Piece {

	protected Position position;
	
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null; //A posição inicial sempre será nula
	}

	protected Board getBoard() {
		return board;
	}


	
	
}