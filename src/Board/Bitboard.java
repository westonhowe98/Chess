package Board;
import java.util.ArrayList;

import Pieces.*;

public class Bitboard {
	
	private Bitmap White;
	private Bitmap Black;

	private Bitmap Kings;
	private Bitmap Queens;
	private Bitmap Rooks;
	private Bitmap Bishops;
	private Bitmap Knights;
	private Bitmap Pawns;
	
	public Bitboard() {
		Reset();
	}
	
	public Bitboard(Board Board) {
		Clear();
		for(Piece Piece : Board.GetPieces())
			AddPiece(Piece);
	}
	
	public void Clear() {
		White = new Bitmap();
		Black = new Bitmap();
		
		Kings = new Bitmap();
		Queens = new Bitmap();
		Rooks = new Bitmap();
		Bishops = new Bitmap();
		Knights = new Bitmap();
		Pawns = new Bitmap();
	}
	
	public void Reset() {
		Clear();
		
		White = Bitmaps.WHITE_PIECES;
		Black = Bitmaps.BLACK_PIECES;
		
		Kings = Bitmaps.KINGS;
		Queens = Bitmaps.QUEENS;
		Rooks = Bitmaps.ROOKS;
		Bishops = Bitmaps.BISHOPS;
		Knights = Bitmaps.KNIGHTS;
		Pawns = Bitmaps.PAWNS;
	}
	
	public Bitmap GetAll() {
		return GetWhite().or(GetBlack());
	}
	
	public Bitmap GetWhite() {
		return White;
	}
	
	public Bitmap GetBlack() {
		return Black;
	}
	
	public Bitmap GetKings() {
		return Kings;
	}

	public Bitmap GetQueens() {
		return Queens;
	}
	
	public Bitmap GetRooks() {
		return Rooks;
	}
	
	public Bitmap GetBishops() {
		return Bishops;
	}
	
	public Bitmap GetKnights() {
		return Knights;
	}
	
	public Bitmap GetPawns() {
		return Pawns;
	}
	
	public Bitmap GetColor(boolean IsWhite) {
		if(IsWhite)
			return GetWhite();
		
		return GetBlack();
	}
	
	public Bitmap GetPieceMap(PieceType PieceType, boolean IsWhite) {
		switch(PieceType) {
			case King: return GetKings().and(GetColor(IsWhite));
			case Queen: return GetQueens().and(GetColor(IsWhite));
			case Rook: return GetRooks().and(GetColor(IsWhite));
			case Bishop: return GetBishops().and(GetColor(IsWhite));
			case Knight: return GetKnights().and(GetColor(IsWhite));
			case Pawn: return GetPawns().and(GetColor(IsWhite));
		}
		
		return GetAll();
	}
	
	public ArrayList<PieceDef> GetPieceDefs(boolean IsWhite) {
		ArrayList<PieceDef> PieceDefs = new ArrayList<PieceDef>();
		
		for(PieceType PieceType : PieceType.values())
			PieceDefs.addAll(GeneratePieceDefs(PieceType, IsWhite, GetPieceMap(PieceType, IsWhite)));
		
		return PieceDefs;
	}
	
	public ArrayList<PieceDef> GetPieceDefs() {
		ArrayList<PieceDef> PieceDefs = new ArrayList<PieceDef>();
		
		PieceDefs.addAll(GetPieceDefs(true));
		PieceDefs.addAll(GetPieceDefs(false));
		
		return PieceDefs;
	}
	
	private Bitmap GetCoordinateMap(int x, int y) {
		int index = (y * Board.BOARD_SIZE) + x; // the index of the square on the board where the piece is located.
		return new Bitmap(Bitmaps.FIRST_POSITION.GetValue() >>> index); // shift the bit flag to the point that matches the pieces location
	}
	
	private void AddPiece(Piece Piece) {
		// Get the bitmap for the point on the board the piece is
		Bitmap PieceMap = GetCoordinateMap(Piece.GetSquare().GetX(), Piece.GetSquare().GetY());
		
		// Add piece to color bitmaps
		if(Piece.IsWhite())
			White = GetWhite().or(PieceMap);
		else
			Black = GetBlack().or(PieceMap);
			
		// determine the type of piece to add it to the correct bitmap
		switch(Piece.GetPieceType()) {
			case King:
				Kings = Kings.or(PieceMap);
				break;
				
			case Queen:
				Queens = Queens.or(PieceMap);
				break;
				
			case Rook:
				Rooks = Rooks.or(PieceMap);
				break;
				
			case Bishop:
				Bishops = Bishops.or(PieceMap);
				break;
				
			case Knight:
				Knights = Knights.or(PieceMap);
				break;
				
			case Pawn:
				Pawns = Pawns.or(PieceMap);
				break;
		}
	}

	public static ArrayList<PieceDef> GeneratePieceDefs(PieceType PieceType, boolean IsWhite, Bitmap Bitmap) {
		ArrayList<PieceDef> PieceDefs = new ArrayList<PieceDef>();
		
		while(Bitmap.GetValue() != 0) {
			Bitmap LsbBitmap = Bitmap.lsb(); // Get the bitmap of the left most bit for that piece type
			PieceDefs.add(new PieceDef(PieceType, IsWhite, LsbBitmap)); // add the piece def for the LSB piece
			Bitmap = Bitmap.xor(LsbBitmap); // Remove the LSB piece from the original bitmap
		}
		
		return PieceDefs;
	}
	
}
