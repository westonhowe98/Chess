import Board.*;
import Pieces.*;
import java.util.Scanner;

public class Game {
	private Board Board = null;
	private MoveFactory MoveFactory = null;
	private static boolean Continue = true;
	
	public static void clearScreen() {  
	    System.out.flush();  
	}  
	
	public static void print(String String) {
		System.out.println(String);
		System.out.println();
	}
	
	public static void main(String[] args) {	
		Start();
	}
	
	public static void Start() {
		Game Game = new Game();
		
		Game.Display();
		
		while(Continue)
			Game.ListenForMove();
	}
	
	public Game() {
		Board = new Board();
		MoveFactory = new MoveFactory(Board);
	}
	
	public void Display() {
		clearScreen();
		System.out.println(Board.toString());
		System.out.println();
		
		Bitboard Bitboard = new Bitboard(Board);
		System.out.println(Bitboard.GetPieceMap(PieceType.King, true));
		System.out.println();
	}
	
	public void ExecuteMove(String Move) {
		System.out.println(MoveFactory.GetMove(Move).Execute());
		System.out.println();
		Display();
	}
	
	public void ListenForMove() {
		Scanner Scanner = new Scanner(System.in);
		
		System.out.print("Enter Move: ");
		ExecuteMove(Scanner.nextLine());
		
	}

}
