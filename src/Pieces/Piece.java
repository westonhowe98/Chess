package Pieces;
import java.util.ArrayList;

import Board.Square;
import Configuration.Settings;

public abstract class Piece {
	protected static final int BLACK_OFFSET = 6;
	
	private String Name = "";
	private char CharSymbol = ' ';
	private int SymbolCode;
	private int Value = 0;
	private boolean IsWhite = false;
	
	private PieceType PieceType;
		
	private Square Square = null;
	private boolean IsAlive = true;
	
	public static Piece GetPiece(PieceType PieceType, boolean IsWhite) {
		switch(PieceType) {
			case King: return new King(IsWhite);
			case Queen: return new Queen(IsWhite);
			case Rook: return new Rook(IsWhite);
			case Bishop: return new Bishop(IsWhite);
			case Knight: return new Knight(IsWhite);
			case Pawn: return new Pawn(IsWhite);
		}
		
		return null;
	}
	
	public static String PieceTypeToString(PieceType PieceType) {
		switch(PieceType) {
			case King: return "King";
			case Queen: return "Queen";
			case Rook: return "Rook";
			case Bishop: return "Bishop";
			case Knight: return "Knight";
			case Pawn: return "Pawn";
		}
		
		return "Piece";
	}
	
	public Piece(PieceType PieceType, String Name, char CharSymbol, int SymbolCode, int Value, boolean IsWhite) {
		this.PieceType = PieceType;
		this.Name = Name;
		this.CharSymbol = IsWhite ? CharSymbol : Character.toLowerCase(CharSymbol);
		this.SymbolCode = IsWhite ? SymbolCode : SymbolCode + BLACK_OFFSET;
		this.Value = Value;
		this.IsWhite = IsWhite;
	}
	
	public void Capture() {
		IsAlive = false;
	}
	
	public boolean IsAlive() {
		return IsAlive;
	}
	
	public Square GetSquare() {
		return Square;
	}
	
	public void SetSquare(Square Square) {
		this.Square = Square;
	}
	
	public String GetName() {
		return Name;
	}
	
	public PieceType GetPieceType() {
		return PieceType;
	}
	
	public String GetSymbol() {
		return Character.toString((char) SymbolCode);
	}
	
	public int GetValue() {
		return Value;
	}
	
	public boolean IsWhite() {
		return IsWhite;
	}
	
	public String toString() {
		if(Settings.USE_UNICODE)
			return GetSymbol();
		
		return Character.toString(toChar());
	}
	
	public char toChar() {		
		return CharSymbol;
	}
	
	public abstract ArrayList<Move> GetMoves();
	
}
