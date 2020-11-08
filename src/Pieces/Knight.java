package Pieces;

import java.util.ArrayList;

import Configuration.Settings;

public class Knight extends Piece {

	public Knight(boolean IsWhite) {
		super(PieceType.Knight, "Knight", 'N', 0x2658, Settings.KNIGHT_VALUE, IsWhite);
	}

	@Override
	public ArrayList<Move> GetMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
