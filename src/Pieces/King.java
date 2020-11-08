package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class King extends Piece {

	public King(boolean IsWhite) {
		super(PieceType.King, "King", 'K', 0x2654, Settings.KING_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
