package Pieces;

import Board.*;

public class PieceDef {
	
	private int X = 0;
	private int Y = 0;
	
	private PieceType PieceType = null;
	
	private boolean IsWhite = false;
	
	public PieceDef(PieceType PieceType, boolean IsWhite, Bitmap Bitmap) {
		this.PieceType = PieceType;
		this.IsWhite = IsWhite;
		
		int Index = Bitmap.GetBitIndex();
		
		Y = Index / Board.BOARD_SIZE;
		X = Index % Board.BOARD_SIZE;
	}
	
	public int GetX() {
		return X;
	}
	
	public int GetY() {
		return Y;
	}
	
	public boolean IsWhite() {
		return IsWhite;
	}
	
	public PieceType GetPieceType() {
		return PieceType;
	}
	
	public String toString() {
		String PieceDef = "";
		
		PieceDef += "Piece Type: ";
		PieceDef += Piece.PieceTypeToString(GetPieceType());
		
		PieceDef += '\t';
		
		PieceDef += "X: ";
		PieceDef += Integer.toString(GetX());
		
		PieceDef += '\t';
		
		PieceDef += "Y: ";
		PieceDef += Integer.toString(GetY());
		
		PieceDef += '\t';
		
		PieceDef += "Is White: ";
		PieceDef += Boolean.toString(IsWhite());
		
		return PieceDef;
	}

}
