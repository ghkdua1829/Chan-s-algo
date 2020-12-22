package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14499_주사위굴리기 {

	static int[][] search = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[][] arr = new int[N][M];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		Dice dice = new Dice();
		token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(token.nextToken());
			int nr = x + search[dir][0];
			int nc = y + search[dir][1];
			if (isIn(nr, nc)) {
				x = nr;
				y = nc;
				dice.move(dir);
				if (arr[x][y] == 0) {
					arr[x][y] = dice.bottom;
				} else {
					dice.bottom = arr[x][y];
					arr[x][y] = 0;
				}
				sb.append(dice.top + "\n");
			}

		}
		System.out.println(sb.toString());

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Dice {
		int top, left, right, up, down, bottom;

		public void move(int dir) {
			if (dir == 1) {
				moveRight();
			} else if (dir == 2) {
				moveLeft();
			} else if (dir == 3) {
				moveUp();
			} else if (dir == 4) {
				moveDown();
			}
		}

		public void moveUp() {
			int temp = this.bottom;
			this.bottom = this.down;
			this.down = this.top;
			this.top = this.up;
			this.up = temp;
		}

		public void moveDown() {
			int temp = this.bottom;
			this.bottom = this.up;
			this.up = this.top;
			this.top = this.down;
			this.down = temp;
		}

		public void moveLeft() {
			int temp = this.bottom;
			this.bottom = this.right;
			this.right = this.top;
			this.top = this.left;
			this.left = temp;
		}

		public void moveRight() {
			int temp = this.bottom;
			this.bottom = this.left;
			this.left = this.top;
			this.top = this.right;
			this.right = temp;
		}
	}

}
