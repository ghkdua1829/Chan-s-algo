package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_7576_토마토 {
	static int[][] arr;
	static Queue<Point> queue = new LinkedList<Point>();
	private static boolean[][] visited;
	static List<Point> plist = new ArrayList<>();

	static int cSize;
	static int rSize;

	static int[] searchR = { 0, -1, 1, 0 };
	static int[] searchC = { -1, 0, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		cSize = Integer.parseInt(tokens.nextToken());
		rSize = Integer.parseInt(tokens.nextToken());
		visited = new boolean[rSize][cSize];
		arr = new int[rSize][cSize];
		for (int r = 0; r < rSize; r++) {
			tokens = new StringTokenizer(in.readLine());
			for (int c = 0; c < cSize; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				if (arr[r][c] == 1) {
					plist.add(new Point(r, c));
				}
			}
		}
		bfs(plist);
		int day = 0;
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				if (arr[r][c] == 0) {
					System.out.println("-1");
					return;
				}
				if (day < arr[r][c]) {
					day = arr[r][c];
				}

			}
		}
		System.out.println(day - 1);
	}

	public static void bfs(List<Point> tomatoSpot) {
		for (int i = 0; i < tomatoSpot.size(); i++) {
			queue.offer(new Point(tomatoSpot.get(i).r, tomatoSpot.get(i).c));
		}
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			for (int s = 0; s < searchR.length; s++) {
				int nr = top.r + searchR[s];
				int nc = top.c + searchC[s];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					if (arr[nr][nc] == 0) {
						queue.offer(new Point(nr, nc));
						arr[nr][nc] = arr[top.r][top.c] + 1;
					}

				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < rSize && c >= 0 && c < cSize;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}