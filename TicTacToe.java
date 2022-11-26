package TicTacToe;
import java.util.*;
public class TicTacToe {
	private Player player1, player2;
	private Board BOARD;
	private int numplayers = 0;

	public static void main(String[] args) {		
		TicTacToe t = new TicTacToe();
		t.StartGame();		
	}
	
	public void StartGame() {
		//take input from user
		Scanner s = new Scanner(System.in);
		player1 = takeinput(++numplayers);
		player2 = takeinput(++numplayers);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("The Symbol is Already Taken !!!  Please RE-ENTER...");
			player2.setSymbol(s.next().charAt(0));
		}
		//create board
		BOARD = new Board(player1.getSymbol(), player2.getSymbol());
		//play the game.
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
			if(player1Turn) {
				System.out.println("player 1 - "+player1.getname()+"'s Turn");
				System.out.println("Enter the x and y co-ordinates: ");
				int x = s.nextInt(), y = s.nextInt();
				status = BOARD.move(player1.getSymbol(), x, y);
				
				if(status == Board.INVALIDMOVE) {
					System.out.println("invalid move !! please try again...");					
				}else {
					player1Turn = false;
					BOARD.print();
				}
			}else {
				System.out.println("player 2 - "+player2.getname()+"'s Turn");
				System.out.println("Enter the x and y co-ordinates: ");
				int x = s.nextInt(), y = s.nextInt();
				status = BOARD.move(player2.getSymbol(), x, y);
				
				if(status == Board.INVALIDMOVE) {
					System.out.println("invalid move !! please try again...");					
				}else {
					player1Turn = true;
					BOARD.print();
				}
			}
		}
		if(status == Board.PLAYER1WINS) {
			System.out.println();
			System.out.println("             player 1 - "+player1.getname()+" wins!!!!          ");
		}else if(status == Board.PLAYER2WINS) {
			System.out.println();
			System.out.println("             player 2 - "+player2.getname()+" wins!!!!          ");
		}else {
			System.out.println("             !! THE GAME IS DRAW !!            ");
		}
		
		
	}
	public Player takeinput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player"+num+" name :");
		String name = s.nextLine();
		System.out.println("Enter player" + num+" symbol :");
		char symbol = s.next().charAt(0);
		
		Player p = new Player(name, symbol);
		return p;
		
				
	}

}
