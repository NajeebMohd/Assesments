package TicTacToe;

public class Board {
	private char board[][];
	private int boardsize = 3;
	private int count;
	private char p1symbol, p2symbol;
	private static final char Empty = ' ';
	
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int DRAW = 3;
	public static final int INCOMPLETE = 4;
	public static final int INVALIDMOVE = 5;
	
	
	public Board(char p1symbol, char p2symbol) {
		board = new char[boardsize][boardsize];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = Empty;
			}
		}
		this.p1symbol = p1symbol;
		this.p2symbol = p2symbol;
	}
	
	
	public void print() {
		System.out.println("------------");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
	
	public int move(char symbol, int x, int y) {
		if(x < 0 || x >= boardsize || y < 0 || y >= boardsize || board[x][y] != Empty) {
			return INVALIDMOVE;
		}
		board[x][y] = symbol;
		count++;
		// for row
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		//for columns
		if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		//for diagonals
		if( board[0][0] != Empty && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		if(board[0][0] != Empty && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
			return symbol == p1symbol ? PLAYER1WINS : PLAYER2WINS;
		}
		
		if(count == boardsize * boardsize) {
			return DRAW;
		}
		return INCOMPLETE;
	
	}
}
