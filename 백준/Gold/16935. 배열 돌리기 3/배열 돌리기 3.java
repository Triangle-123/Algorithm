import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			int command = Integer.parseInt(st.nextToken());
			switch(command) {
			case 1:
				board = one(board);
				break;
			case 2:
				board = two(board);
				break;
			case 3:
				board = three(board);
				break;
			case 4:
				board = four(board);
				break;
			case 5:
				board = five(board);
				break;
			case 6:
				board = six(board);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int[][] one(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];
		for(int i = 0; i < newBoard.length; i++) {
			for(int j = 0; j < newBoard[i].length; j++) {
				newBoard[i][j] = board[board.length - i - 1][j];
			}
		}
		return newBoard;
	}
	
	private static int[][] two(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				newBoard[i][j] = board[i][board[i].length - j - 1];
			}
		}
		return newBoard;
	}
	
	private static int[][] three(int[][] board) {
		int[][] newBoard = new int[board[0].length][board.length];
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board.length; j++) {
				newBoard[i][j] = board[board.length - j - 1][i];
			}
		}
		return newBoard;
	}
	
	private static int[][] four(int[][] board) {
		int[][] newBoard = new int[board[0].length][board.length];
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board.length; j++) {
				newBoard[i][j] = board[j][board[0].length - i - 1];
			}
		}
		return newBoard;
	}
	
	private static int[][] five(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];
		for(int i = 0; i < board.length / 2; i++) {
			for(int j = 0; j < board[i].length / 2; j++) {
				newBoard[i][j] = board[i + board.length / 2][j];
				newBoard[i][j + board[i].length / 2] = board[i][j];
				newBoard[i + board.length / 2][j + board[0].length / 2] = board[i][j + board[0].length / 2];
				newBoard[i + board.length / 2][j] = board[i + board.length / 2][j + board[0].length / 2];
			}
		}
		return newBoard;
	}
	
	private static int[][] six(int[][] board) {
		int N = board.length;
		int M = board[0].length;
		int[][] newBoard = new int[N][M];
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++) {
				newBoard[i + N / 2][j] = board[i][j];
				newBoard[i][j] = board[i][j + M / 2];
				newBoard[i][j + M / 2] = board[i + N / 2][j + M / 2];
				newBoard[i + N / 2][j + M / 2] = board[i + N / 2][j];
			}
		}
		return newBoard;
	}
}
