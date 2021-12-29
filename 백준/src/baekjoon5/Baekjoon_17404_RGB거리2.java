package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17404_RGB거리2 {
	static int INF = 12345678;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		int result = INF;
		for (int t = 0; t < 3; t++) {
			int[][] copy = new int[N][3];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < 3; c++) {
					copy[r][c] = board[r][c];
				}
			}
			for (int i = 0; i < 3; i++) {
				if (i == t) {
					copy[N - 1][i] = INF;
				} else {
					copy[0][i] = INF;
				}
			}
			for (int r = 1; r < N; r++) {
				copy[r][0] += Math.min(copy[r - 1][1], copy[r - 1][2]);
				copy[r][1] += Math.min(copy[r - 1][0], copy[r - 1][2]);
				copy[r][2] += Math.min(copy[r - 1][0], copy[r - 1][1]);
			}
			result = Math.min(result, Math.min(copy[N - 1][0], Math.min(copy[N - 1][1], copy[N - 1][2])));
		}
		System.out.println(result); 
	}

}
