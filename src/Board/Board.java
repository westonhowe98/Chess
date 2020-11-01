package Board;
import java.util.ArrayList;

import Pieces.*;

public class Board {
	private static final int BOARD_SIZE = 8;
	private static final int PIECE_COUNT = BOARD_SIZE * 4;
	private ArrayList<Square> Squares = new ArrayList<>(BOARD_SIZE * BOARD_SIZE);
	private ArrayList<Piece> Pieces = new ArrayList<>(PIECE_COUNT);
	
	private void AssignPiece(String Coords, Piece Piece)  {
		AssignPiece(GetX(Coords), GetY(Coords), Piece);
	}
	
	private void AssignPiece(int x, int y, Piece Piece)  {
		/*
		 * Given a piece and coordinates put the piece on that square
		 * Add the piece to the Pieces array for easier access later
		 * Note: This method should not be used to move a piece. 
		 * It would be added to the pieces array twice if so.
		 */
		Pieces.add(Piece);
		GetSquare(x, y).SetOccupant(Piece);
	}
	
	private Square GetSquare(int x, int y) {
		return Squares.get((y * BOARD_SIZE) + x);
	}
	
	private int GetX(String Coords) {
		return Coords.charAt(0) - 'a';
	}
	
	private int GetY(String Coords) {
		return Character.getNumericValue(Coords.charAt(1)) - 1;
	}
	
	public Square GetSquare(String Coords) {
		return GetSquare(GetX(Coords), GetY(Coords));
	}
	
	public Board() {
		Reset();
	}
	
	public void Reset() {
		Clear();
		
		// Assign all white pieces
		AssignPiece("a1", new Rook(true));
		AssignPiece("b1", new Knight(true));
		AssignPiece("c1", new Bishop(true));
		AssignPiece("d1", new Queen(true));
		AssignPiece("e1", new King(true));
		AssignPiece("f1", new Bishop(true));
		AssignPiece("g1", new Knight(true));
		AssignPiece("h1", new Rook(true));
		
		// Assign all white pawns
		for(int x = 0; x < BOARD_SIZE; x++)
			AssignPiece(x, 1, new Pawn(true));
		
		// Assign all black pieces
		AssignPiece("a8", new Rook(false));
		AssignPiece("b8", new Knight(false));
		AssignPiece("c8", new Bishop(false));
		AssignPiece("d8", new Queen(false));
		AssignPiece("e8", new King(false));
		AssignPiece("f8", new Bishop(false));
		AssignPiece("g8", new Knight(false));
		AssignPiece("h8", new Rook(false));
		
		// Assign all black pawns
		for(int x = 0; x < BOARD_SIZE; x++)
			AssignPiece(x, 6, new Pawn(false));
	}
	
	public void Clear() {
		// Remove all pieces from the board, leaving only an array of blank squares.
		for(int y = 0; y < BOARD_SIZE; y++)
			for(int x = 0; x < BOARD_SIZE; x++)
				Squares.add(new Square(x, y));
	}
	
	public String toString() {
		String BoardValues = "";
		
		for(int y = 0; y < BOARD_SIZE; y++) {
			String NextRow = Integer.toString(y + 1) + " "; // label the row with index
			
			for(int x = 0; x < BOARD_SIZE; x++)
				NextRow += GetSquare(x, y).toString() + " ";
				
			NextRow = NextRow.substring(0, NextRow.length() - 1); // Remove trailing space
			NextRow += '\n';
			
			BoardValues = NextRow + BoardValues; // prepend so board displays from white's perspective in console
			NextRow = "";
		}
		
		BoardValues += "   a   b   c   d   e   f   g   h ";
		
		//BoardValues = BoardValues.substring(0, BoardValues.length() - 1); // Remove trailing new line
		
		return BoardValues;
	}
}
