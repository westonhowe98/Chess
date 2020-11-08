package Pieces;
import Board.Square;

public class Move {
	private Square Origin;
	private Square Destination;
	
	public Move(Square Origin, Square Destination) {
		this.Origin = Origin;
		this.Destination = Destination;
	}
	
	public String Execute() {
		String Notation = toString();
		
		if(IsCapture())
			GetDestination().GetOccupant().Capture();
		
		Piece Piece = GetPiece();
		GetOrigin().Clear(); // Clear origin before moving to destination
		GetDestination().SetOccupant(Piece); // Move piece to destination
	
		return Notation;
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
		String Move = "";
		
		if(GetPiece().GetName() != "Pawn")
			Move += Character.toString(GetPiece().toChar());
		
		if(IsCapture())
			Move += "x";
		
		Move += GetDestination().GetCoords();
		return  Move;
	}
	
}