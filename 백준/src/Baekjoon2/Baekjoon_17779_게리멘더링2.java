package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17779_게리멘더링2 {
	static Point[][] arr;
	static int N, Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Point[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = new Point(Integer.parseInt(token.nextToken()), 0);
			}
		}
		for (int r = 1; r < N - 1; r++) {
			for (int c = 0; c < N - 2; c++) {
				for (int rr = 1; rr < N; rr++) {
					for (int cc = 1; cc < N; cc++) {

						gari(c, r, cc, rr);

					}
				}
			}
		}
		System.out.println(Min);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	private static void gari(int x, int y, int d1, int d2) {
		int topY = y - d1 - 1;
		int topX = x + d1 - 1;
		int leftY = y - 1;
		int leftX = x - 1;
		int rightY = y - d1 + d2 - 1;
		int rightX = x + d1 + d2 - 1;
		int botY = y + d2 - 1;
		int botX = x + d2 - 1;

		if (isIn(topX, topY) && isIn(leftX, leftY) && isIn(rightX, rightY) && isIn(botX, botY)) {
			int[] result = new int[5];
			for (int r = 0; r < leftY; r++) {
				for (int c = 0; c <= topX; c++) {
					arr[r][c].gu = 1;
				}
			}
			for (int r = 0; r <= rightY; r++) {
				for (int c = topX + 1; c < N; c++) {
					arr[r][c].gu = 2;
				}
			}
			for (int r = leftY; r < N; r++) {
				for (int c = 0; c < botX; c++) {
					arr[r][c].gu = 3;
				}
			}
			for (int r = rightY + 1; r < N; r++) {
				for (int c = botX; c < N; c++) {
					arr[r][c].gu = 4;
				}
			}
			for (int r = topY, i = 1; r <= leftY; r++, i++) {
				for (int c = topX; c > topX - i; c--) {
					arr[r][c].gu = 5;
				}
			}
			for (int r = topY, i = 1; r <= rightY; r++, i++) {
				for (int c = topX; c < topX + i; c++) {
					arr[r][c].gu = 5;
				}
			}
			for (int r = botY, i = 1; r >= leftY; r--, i++) {
				for (int c = botX; c > botX - i; c--) {
					arr[r][c].gu = 5;
				}
			}
			for (int r = botY, i = 1; r >= rightY; r--, i++) {
				for (int c = botX; c < botX + i; c++) {
					arr[r][c].gu = 5;
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					result[arr[r][c].gu - 1] += arr[r][c].value;
				}
			}
			Arrays.sort(result);
			int min = result[0];
			int max = result[4];
			if (Min > max - min) {
				Min = max - min;
			}
		}
	}

	static class Point {
		int value, gu;

		public Point(int value, int gu) {
			super();
			this.value = value;
			this.gu = gu;
		}

		@Override
		public String toString() {
			return "Point [value=" + value + ", gu=" + gu + "]";
		}

	}
}
