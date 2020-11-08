package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class Queen extends Piece {

	public Queen(boolean IsWhite) {
		super(PieceType.Queen, "Queen", 'Q', 0x2655, Settings.QUEEN_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
