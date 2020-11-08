package Board;
import java.util.ArrayList;

import Pieces.*;

public class Board {
	public static final int BOARD_SIZE = 8;
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

	private void AssignPiece(PieceDef PieceDef) {
		Piece NewPiece = Piece.GetPiece(PieceDef.GetPieceType(), PieceDef.IsWhite());
		AssignPiece(PieceDef.GetX(), PieceDef.GetY(), NewPiece);		
	}

	private Square GetSquare(int x, int y) {
		return Squares.get(((BOARD_SIZE - (y + 1)) * BOARD_SIZE) + x);
	}
	
	private int GetX(String Coords) {
		return Coords.charAt(0) - 'a';
	}
	
	private int GetY(String Coords) {
		return BOARD_SIZE - (Character.getNumericValue(Coords.charAt(1)));
	}
	
	/*public Piece GetPiece(PieceType PieceType, boolean IsWhite) {
		for(Piece Piece : Pieces)
			if(Piece.GetPieceType() == PieceType && Piece.IsWhite() == IsWhite)
				return Piece;
						
		return null;
	}*/

	public Square GetSquare(String Coords) {
		return GetSquare(GetX(Coords), GetY(Coords));
	}
	
	public Board() {
		Reset();
	}
	
	public void Reset() {
		Clear();
		
		SetBoard(new Bitboard());
	}
	
	public void Clear() {
		Pieces.clear();
		Squares.clear();
		
		// Remove all pieces from the board, leaving only an array of blank squares.
		for(int y = 0; y < BOARD_SIZE; y++)
			for(int x = 0; x < BOARD_SIZE; x++)
				Squares.add(new Square(x, y));		
	}
	
	public String toString() {
		String BoardValues = "";
		
		for(int y = 0; y < BOARD_SIZE; y++) {
			String NextRow = Integer.toString(BOARD_SIZE - y) + " "; // label the row with index
			
			for(int x = 0; x < BOARD_SIZE; x++)
				NextRow += GetSquare(x, y).toString() + " ";
				
			NextRow = NextRow.substring(0, NextRow.length() - 1); // Remove trailing space
			NextRow += '\n';
			
			//BoardValues = NextRow + BoardValues; // prepend so board displays from white's perspective in console
			BoardValues += NextRow;
			
			NextRow = "";
		}
		
		BoardValues += "   a   b   c   d   e   f   g   h ";
		
		//BoardValues = BoardValues.substring(0, BoardValues.length() - 1); // Remove trailing new line
		
		return BoardValues;
	}

	public void SetBoard(Bitboard Bitboard) {
		Clear();
		
		for(PieceDef PieceDef : Bitboard.GetPieceDefs())
			AssignPiece(PieceDef);
	}

	public ArrayList<Piece> GetPieces() {
		return Pieces;
	}
}
