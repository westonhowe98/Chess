import Pieces.*;
import Board.*;


public class MoveFactory {
	private Board Board = null;
	
	public MoveFactory() {	}
	
	public MoveFactory(Board Board) {
		SetBoard(Board);
	}
	
	public Move GetMove(String Origin, String Destination) {
		return new Move(Board.GetSquare(Origin), Board.GetSquare(Destination));
	}
	
	public Move GetMove(String MoveStr) {	
		if(MoveStr.contains("-")) { // hyphenated e.g. e2-e4
			String[] Coords = MoveStr.split("-");
			return GetMove(Coords[0], Coords[1]);
		}
		
		return null;
	}
	
	public void SetBoard(Board Board) {
		this.Board = Board;
	}
	
	public Board GetBoard() {
		return Board;
	}
	
}
