package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_19237_어른상어 {
	static int[][] search = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Board[][] board;
	static List<Shark> sharks;
	static int[][][] dirs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		board = new Board[N][N];
		sharks = new ArrayList<Shark>();
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(token.nextToken());
				if (num != 0) {
					sharks.add(new Shark(num, r, c, 0));
				}
				board[r][c] = new Board(num, 0);
			}
		}

		dirs = new int[N][4][4];
		token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			Shark shark = sharks.get(i);
			shark.dir = Integer.parseInt(token.nextToken());
		}

	}

	static class Board {
		int num, time;

		public Board(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
	}

	static class Shark {
		int r, c, num, dir;

		public Shark(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}

	}
}
