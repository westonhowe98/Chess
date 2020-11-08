package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class Pawn extends Piece {

	public Pawn(boolean IsWhite) {
		super(PieceType.Pawn, "Pawn", 'P', 0x2659, Settings.PAWN_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
