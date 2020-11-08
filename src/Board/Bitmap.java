package Board;

public class Bitmap {
	
	private long Value = 0;
	
	public Bitmap() {
	}
	
	public Bitmap(long Value) {
		this.Value = Value;
	}
	
	public long GetValue() {
		return Value;
	}
	
	public Bitmap and(Bitmap Bitmap) {
		return Bitmap.and(Value);
	}
	
	public Bitmap and(long Value) {
		return new Bitmap(this.Value & Value);
	}
	
	public Bitmap or(Bitmap Bitmap) {
		return Bitmap.or(Value);
	}
	
	public Bitmap or(long Value) {
		return new Bitmap(this.Value | Value);
	}
	
	public Bitmap xor(Bitmap Bitmap) {
		return Bitmap.xor(Value);
	}
	
	public Bitmap xor(long Value) {
		return new Bitmap(this.Value ^ Value);
	}
	
	public Bitmap lsb() {
		// return a bitmap of the least significant bit
		return new Bitmap(Long.lowestOneBit(Value));
	}
	
	public Bitmap msb() {
		// return a bitmap of the most significant bit
		return new Bitmap(Long.highestOneBit(Value));
	}
	
	public int GetBitIndex() {
		long BitValue = Value;
		
		int Index = 0;
		while(BitValue != 1L) {
			BitValue = BitValue >>> 1;
			Index++;
			
			// Don't do an infinite loop if a bitmap of multiple bits is passed.
			if(Index >= Long.SIZE)
				return -1;
		}
			
		return Index;
	}
	
	public String toString() {
		String BitmapStr = "";
		
		for(int i = 0; i < 8; i++) {
			// Extract a single byte from the bitmap and make it a 0 padded string
			String BitmapRow = String.format("%8s", Long.toBinaryString((Value >> (8 * i)) & 0xff)).replace(" ", "0");
			BitmapStr += BitmapRow + '\n';
		}
		
		BitmapStr = BitmapStr.substring(0, BitmapStr.length() - 1);
				
		return BitmapStr;
	}
	
	public String toBinaryString() {
		return String.format("%64s", Long.toBinaryString(Value)).replace(" ", "0");
	}

	public static Bitmap Union(Bitmap[] Bitmaps) {
		long UnionBitmap = 0L;
		
		for(Bitmap Bitmap : Bitmaps)
			UnionBitmap |= Bitmap.GetValue();
		
		return new Bitmap(UnionBitmap);
	}
}
