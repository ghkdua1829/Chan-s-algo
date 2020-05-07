package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_16234_인구이동 {
	static int[][] arr;
	static int L, R, result;
	static int[] searchR = { 1, -1, 0, 0 };
	static int[] searchC = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean token;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size][size];
		visited = new boolean[arr.length][arr.length];

		L = sc.nextInt();
		R = sc.nextInt();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		while (true) {
			result++;
			visited = new boolean[arr.length][arr.length];
			token = false;
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					bfsQueue(new Point(r, c));

				}
			}
			if (!token) {
				break;
			}
		}

		System.out.println(--result);
	}

	public static void bfsQueue(Point start) {
		Queue<Point> queue = new LinkedList<>();
		List<Point> points = new ArrayList<>();
		int sum = 0, count = 0;
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			count++;
			int value = arr[top.r][top.c];
			points.add(top);
			sum += value;
			for (int s = 0; s < searchR.length; s++) {
				int nr = top.r + searchR[s];
				int nc = top.c + searchC[s];
				if (isIn(nr, nc) && Math.abs(arr[nr][nc] - value) >= L && Math.abs(arr[nr][nc] - value) <= R) {
					token = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}

		for (int i = 0; i < points.size(); i++) {
			arr[points.get(i).r][points.get(i).c] = sum / count;
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < arr.length && c < arr.length;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
