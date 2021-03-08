package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10157_자리배정 {
	static int R, C;
	static int[][] search = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		C = Integer.parseInt(token.nextToken());
		R = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[R][C];
		Point first = new Point(R - 1, 0);
		boolean[][] visited = new boolean[R][C];
		visited[first.r][first.c] = true;
		int dir = 0;
		Point result = new Point(0, 0);
		int num = 1;
		if (K > R * C) {
			System.out.println(0);
			return;
		}
		while (true) {
			int nr = first.r + search[dir][0];
			int nc = first.c + search[dir][1];
			if (isIn(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if (num == K) {
//					System.out.println(num);
					result.r = first.r;
					result.c = first.c;
					break;
				}
				arr[first.r][first.c] = num++;
				first.r = nr;
				first.c = nc;
			} else {
				dir = (dir + 1) % 4;
			}
			if (num == R * C) {
				arr[first.r][first.c] = num;
				result.r = first.r;
				result.c = first.c;
				break;
			}
		}
		System.out.println((result.c+1)+" "+(R-result.r));
		

//		for (int[] a : arr) {
//			System.out.println(Arrays.toString(a));
//		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
