package lecture_29;

import java.util.Scanner;

public class sudoku_solve {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = scn.nextInt();
			}
		}
		sudoku(board, 0, 0);

	}

	public static void sudoku(int[][] board, int row, int col) {
		if (col == board[0].length) {
			col = 0;
			row = row + 1;
		}
		if (row == board.length) {
			System.out.println("-------------");
			print_board(board);
			return;
		}

		if (board[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (issafe(board, row, col, i)) {
					board[row][col] = i;
					sudoku(board, row, col + 1);
					board[row][col] = 0;
				}
			}
		} else {
			sudoku(board, row, col + 1);
		}
	}

	public static void print_board(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean issafe(int[][] board, int row, int col, int ele) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == ele) {
				return false;
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i] == ele) {
				return false;
			}
		}

		int box_r = row / 2;
		int box_c = col / 2;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[(box_r * 3) + i][(box_c) * 3 + j] == ele) {
					return false;
				}
			}
		}
		return true;

	}

}
