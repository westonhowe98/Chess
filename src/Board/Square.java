package Board;
import Pieces.*;

public class Square {
	// These will be 0 based indexes
	private int X = 0;
	private int Y = 0;
	
	private Piece Occupant = null;
	
	public Square(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
	
	public boolean IsOccupied() {
		return Occupant != null;
	}
	
	public Piece GetOccupant() {
		return Occupant;
	}
	
	public void Clear() {
		Occupant = null;
	}
	
	public void SetOccupant(Piece Occupant) {
		this.Occupant = Occupant;
		this.Occupant.SetSquare(this); // point the occupant to this piece so it knows where it is.
	}
	
	public int GetX() {
		return X;
	}
	
	public int GetY() {
		return Y;
	}
	
	public String GetRank() {
		// Add one because index is 0 based
		return Integer.toString(Y + 1);
	}
	
	public String GetFile() {
		// Use char math to get correct char 0=a, 1=b etc.
		return Character.toString((char)('a' + GetX()));
	}
	
	public String GetCoords() {	
		return GetFile() + GetRank();
	}
	
	public String toString() {
		String SquareDisplay = "[";
		
		// if square is empty then return blank, else return the symbol of the occupant
		SquareDisplay += IsOccupied() ? GetOccupant().toString(): " ";
		
		// if square is empty then return the coordinates of the square, else return the symbol of the occupant
		//SquareDisplay += IsOccupied() ? GetOccupant().toString() + " " : GetCoords();
		
		//SquareDisplay += GetX() + " " + GetY(); // Print IDX Coords for debugging
		
		SquareDisplay += "]";
		return SquareDisplay;
	}
	
	public boolean IsLight() {
		/* 
		 * Return true if the square is light color square.
		 * On standard chess board a1 is dark and the colors checker
		 * Based on 0 indexed X Y values squares where the sum of the coordinates is odd will be light
		 */
		return (X + Y) % 2 != 0;
	}
}
