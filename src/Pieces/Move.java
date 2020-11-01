package Pieces;
import Board.Square;

public class Move {
	private Square Origin;
	private Square Destination;
	
	public Move(Square Origin, Square Destination) {
		this.Origin = Origin;
		this.Destination = Destination;
	}
	
	public Piece GetPiece() {
		// return the piece that will be moving
		return GetOrigin().GetOccupant();
	}
	
	public Square GetOrigin() {
		return Origin;
	}
	
	public Square GetDestination() {
		return Destination;
	}
	
	public boolean IsCapture() {
		// if destination is empty then not a capture move.
		if(!GetDestination().IsOccupied())
			return false;
		
		// if move is blocked then can't be capture
		if(IsBlocked())
			return false;
		
		return true;
	}
	
	public boolean IsBlocked() {
		// if destination is empty then can't be blocked.
			if(!GetDestination().IsOccupied())
				return false;
		
		// if the occupying piece is the same color as the origin piece then move is blocked
		return GetDestination().GetOccupant().IsWhite() == GetPiece().IsWhite();
	}
	
	public String toString() {
		return Character.toString(GetPiece().toChar()) + GetDestination().GetCoords();
	}
}
