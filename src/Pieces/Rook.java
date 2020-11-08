package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class Rook extends Piece {

	public Rook(boolean IsWhite) {
		super(PieceType.Rook, "Rook", 'R', 0x2656, Settings.ROOK_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
