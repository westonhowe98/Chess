package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class Bishop extends Piece {

	public Bishop(boolean IsWhite) {
		super(PieceType.Bishop, "Bishop", 'B', 0x2657, Settings.BISHOP_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
