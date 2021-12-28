package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[][] board = new int[N][K+1];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(token.nextToken());
			int V = Integer.parseInt(token.nextToken());

			for (int c = 1; c < K+1; c++) {
				if (W <= c ) {
					if (r == 0) {
						board[r][c] = V;
					} else {
						board[r][c] = Math.max(board[r - 1][c], board[r - 1][c - W] + V);
					}
				} else {
					if (r == 0) {
						board[r][c] = 0;
					} else {
						board[r][c] = board[r - 1][c];
					}
				}
			}
		}
		int max = 0;
		for (int r = 0; r < N; r++) {
			for(int c=1;c<K+1;c++) {
				max =Math.max(board[r][c], max);
			}
		}
		System.out.println(max);
	}
}
