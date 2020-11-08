package Board;

public class Bitmaps {
	/*
	 * This class acts as a structure to hold useful pre-calculated bitmaps in
	 * an organized way. 
	 */
	
	/* Letter representations of board's files. */
    public static class File {
        public static final int A = 0;
        public static final int B = 1;
        public static final int C = 2;
        public static final int D = 3;
        public static final int E = 4;
        public static final int F = 5;
        public static final int G = 6;
        public static final int H = 7;
    }
    
    public static final Bitmap FIRST_POSITION = new Bitmap(0x8000000000000000L);

    public static final Bitmap[] RANKS = {
		new Bitmap(0xFF00000000000000L), /* 1 */
		new Bitmap(0x00FF000000000000L), /* 2 */
		new Bitmap(0x0000FF0000000000L), /* 3 */
		new Bitmap(0x000000FF00000000L), /* 4 */
		new Bitmap(0x00000000FF000000L), /* 5 */
		new Bitmap(0x0000000000FF0000L), /* 6 */
		new Bitmap(0x000000000000FF00L), /* 7 */
		new Bitmap(0x00000000000000FFL), /* 8 */
    };
    
    public static final Bitmap[] FILES = {
		new Bitmap(0x0101010101010101L), /* A */
		new Bitmap(0x0202020202020202L), /* B */
		new Bitmap(0x0404040404040404L), /* C */
		new Bitmap(0x0808080808080808L), /* D */
		new Bitmap(0x1010101010101010L), /* E */
		new Bitmap(0x2020202020202020L), /* F */
		new Bitmap(0x4040404040404040L), /* G */
		new Bitmap(0x8080808080808080L), /* H */
    };
	
	public static final Bitmap WHITE_KING = new Bitmap(0x1000000000000000L);
	public static final Bitmap WHITE_QUEEN = new Bitmap(0x0800000000000000L);
	public static final Bitmap WHITE_ROOK = new Bitmap(0x8100000000000000L);
	public static final Bitmap WHITE_BISHOP = new Bitmap(0x2400000000000000L);
	public static final Bitmap WHITE_KNIGHT = new Bitmap(0x4200000000000000L);
	public static final Bitmap WHITE_PAWN = new Bitmap(0x00FF000000000000L);
	
	public static final Bitmap BLACK_KING = new Bitmap(0x0000000000000010L);
	public static final Bitmap BLACK_QUEEN = new Bitmap(0x0000000000000008L);
	public static final Bitmap BLACK_ROOK = new Bitmap(0x0000000000000081L);
	public static final Bitmap BLACK_BISHOP = new Bitmap(0x0000000000000024L);
	public static final Bitmap BLACK_KNIGHT = new Bitmap(0x0000000000000042L);
	public static final Bitmap BLACK_PAWN = new Bitmap(0x000000000000FF00L);
	
    public static final Bitmap[] ALL_PIECE_LIST = {
		WHITE_KING, 
		WHITE_QUEEN, 
		WHITE_ROOK, 
		WHITE_BISHOP,
		WHITE_KNIGHT,
		WHITE_PAWN,
		BLACK_KING, 
		BLACK_QUEEN, 
		BLACK_ROOK, 
		BLACK_BISHOP,
		BLACK_KNIGHT,
		BLACK_PAWN
    };
	
	public static final Bitmap[] WHITE_PIECE_LIST = {
		WHITE_KING, 
		WHITE_QUEEN, 
		WHITE_ROOK, 
		WHITE_BISHOP,
		WHITE_KNIGHT,
		WHITE_PAWN
	};
    
    public static final Bitmap[] BLACK_PIECE_LIST = {
		BLACK_KING, 
		BLACK_QUEEN, 
		BLACK_ROOK, 
		BLACK_BISHOP,
		BLACK_KNIGHT,
		BLACK_PAWN
	};
    
    public static final Bitmap[] KING_LIST = {
		WHITE_KING,
		BLACK_KING
	};
    
    public static final Bitmap[] QUEEN_LIST = {
		WHITE_QUEEN,
		BLACK_QUEEN
	};
    
    public static final Bitmap[] ROOK_LIST = {
		WHITE_ROOK,
		BLACK_ROOK
	};
    
    public static final Bitmap[] BISHOP_LIST = {
		WHITE_BISHOP,
		BLACK_BISHOP
	};
    
    public static final Bitmap[] KNIGHT_LIST = {
		WHITE_KNIGHT,
		BLACK_KNIGHT
	};
    
    public static final Bitmap[] PAWN_LIST = {
		WHITE_PAWN,
		BLACK_PAWN
	};

    public static final Bitmap ALL_PIECES = Bitmap.Union(ALL_PIECE_LIST);
    public static final Bitmap WHITE_PIECES = Bitmap.Union(WHITE_PIECE_LIST);
    public static final Bitmap BLACK_PIECES = Bitmap.Union(BLACK_PIECE_LIST);
    public static final Bitmap KINGS = Bitmap.Union(KING_LIST);
    public static final Bitmap QUEENS = Bitmap.Union(QUEEN_LIST);
    public static final Bitmap ROOKS = Bitmap.Union(ROOK_LIST);
    public static final Bitmap BISHOPS = Bitmap.Union(BISHOP_LIST);
    public static final Bitmap KNIGHTS = Bitmap.Union(KNIGHT_LIST);
    public static final Bitmap PAWNS = Bitmap.Union(PAWN_LIST);
    
}
