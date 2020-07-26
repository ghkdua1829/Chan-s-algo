package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Baekjoon_15685_드래곤커브 {

	static int[][] board = new int[101][101];
	static int[][] search = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			int g = Integer.parseInt(token.nextToken());
			boolean[][] visited = new boolean[101][101];
			visited[y][x] = true;
			List<Point> dots = new ArrayList<>();
			dots.add(new Point(x, y));
			Point standard = new Point(x + search[d][1], y + search[d][0]);
			dots.add(standard);
			visited[standard.y][standard.x] = true;
			for (int i = 1; i <= g; i++) {
				int size = dots.size();
				Point tempStandard = new Point(0, 0);
				for (int l = 0; l < size; l++) {
					int nx = standard.y - dots.get(l).y + standard.x;
					int ny = dots.get(l).x - standard.x + standard.y;
					if (l == 0) {
						tempStandard = new Point(nx, ny);
					}
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						dots.add(new Point(nx, ny));
					}
				}
				standard = tempStandard;
			}
			for (int i = 0; i < dots.size(); i++) {
				int xx = dots.get(i).x;
				int yy = dots.get(i).y;
				board[yy][xx] = 1;
			}
		}
		int result = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (board[r][c] == 1) {
					if(board[r+1][c]==1 && board[r+1][c+1]==1 && board[r][c+1]==1) {
						result++;
					}
				}

			}
		}
		System.out.println(result);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
