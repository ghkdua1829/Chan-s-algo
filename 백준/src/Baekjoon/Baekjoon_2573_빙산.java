package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2573_빙산 {
	static int rSize, cSize, year;
	static int[][] arr;
	static int[] searchR = { 1, -1, 0, 0 };
	static int[] searchC = { 0, 0, 1, -1 };
	static int iceCount = 0;
	static int[][] copyArr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");

		rSize = Integer.parseInt(tokens.nextToken());
		cSize = Integer.parseInt(tokens.nextToken());
		arr = new int[rSize][cSize];
		for (int r = 0; r < rSize; r++) {
			tokens = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < cSize; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		while (true) {
			copyArr = new int[rSize][cSize]; // 카피본 뜨기( 처음상태 유지로 주위 바닷물 구히가위해)
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					int count = 0;
					if (arr[r][c] != 0) {
						for (int s = 0; s < searchR.length; s++) {
							int nr = r + searchR[s];
							int nc = c + searchC[s];
							if (isIn(nr, nc) && arr[nr][nc] == 0) {
								count++;
							}
						}
						copyArr[r][c] = count;

					}

				}
			}
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					arr[r][c] -= copyArr[r][c];
					if (arr[r][c] < 0) {
						arr[r][c] = 0;
					}
					copyArr[r][c] = arr[r][c];
				}
			}
			iceCount = 0;
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					if (copyArr[r][c] > 0) {
						bfsQueue(new Point(r, c));
						if (iceCount >= 2) {
							System.out.println(++year);
							return;

						}
					}
				}
			}
			int a = 0;
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					if (arr[r][c] != 0) {
						a++;
					}
				}
			}
			if (a == 0) {
				System.out.println(0);
				return;
			}
			year++;

		}
	}

	private static void bfsQueue(Point start) {
		iceCount++;
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rSize][cSize];
		queue.offer(start);

		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			copyArr[top.r][top.c] = 0;
			for (int s = 0; s < searchR.length; s++) {
				int nr = top.r + searchR[s];
				int nc = top.c + searchC[s];
				if (isIn(nr, nc) && arr[nr][nc] > 0) {
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < rSize && c < cSize;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
