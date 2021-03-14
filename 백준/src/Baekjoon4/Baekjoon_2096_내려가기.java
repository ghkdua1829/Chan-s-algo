package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2096_내려가기 {

	static int[][] board, board2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][3];
		board2 = new int[N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			board[r][0] = board2[r][0] = Integer.parseInt(token.nextToken());
			board[r][1] = board2[r][1] = Integer.parseInt(token.nextToken());
			board[r][2] = board2[r][2] = Integer.parseInt(token.nextToken());

		}
		for (int r = 1; r < N; r++) {
			board[r][0] += Math.max(board[r - 1][0], board[r - 1][1]);
			board[r][1] += Math.max(board[r - 1][0], Math.max(board[r - 1][1], board[r - 1][2]));
			board[r][2] += Math.max(board[r - 1][2], board[r - 1][1]);
		}
		System.out.print(Math.max(board[N - 1][0], Math.max(board[N - 1][1], board[N - 1][2]))+" ");

		for (int r = 1; r < N; r++) {
			board2[r][0] += Math.min(board2[r - 1][0], board2[r - 1][1]);
			board2[r][1] += Math.min(board2[r - 1][0], Math.min(board2[r - 1][1], board2[r - 1][2]));
			board2[r][2] += Math.min(board2[r - 1][2], board2[r - 1][1]);
		}
		System.out.print(Math.min(board2[N - 1][0], Math.min(board2[N - 1][1], board2[N - 1][2])));
	}

}
