package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2468_안전영역 {
	static int[][] arr;
	static int size, finalResult;
	static int maxHeight = Integer.MIN_VALUE;
	static int[] searchR = { 0, -1, 0, 1 };
	static int[] searchC = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static int maxResult = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		size = Integer.parseInt(tokens.nextToken());
		arr = new int[size][size];
		for (int r = 0; r < size; r++) {
			tokens = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < size; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
				if (maxHeight < arr[r][c]) {
					maxHeight = arr[r][c];
				}
			}
		}
		if(maxHeight==1) {
			System.out.println(1);
			return;
		}
		for (int i = 1; i < maxHeight; i++) {
			visited = new boolean[size][size];
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (arr[r][c] <= i) {
						visited[r][c] = true;
					}
				}
			}
			finalResult =0;
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (!visited[r][c]) {
						bfsQueue(new Point(r,c));
					}
				}
			}
			if(maxResult<finalResult) {
				maxResult = finalResult;
			}
		}
		System.out.println(maxResult);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}

	public static void bfsQueue(Point start) {
		finalResult++;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			for(int s =0;s<searchR.length;s++) {
				int nr = top.r+searchR[s];
				int nc = top.c+searchC[s];
				if(isIn(nr,nc) && !visited[nr][nc]) {
					queue.offer(new Point(nr,nc));
				}
			}
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
