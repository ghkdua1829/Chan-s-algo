package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class baekjoon_7569_토마토 {
	static int cSize, rSize, H, time, tempTime;
	static int[][] arr;
	static ArrayList<Point> list;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		cSize = Integer.parseInt(token.nextToken());
		rSize = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		arr = new int[rSize][cSize];
		for (int t = 0; t < H; t++) {
			list = new ArrayList<>();
			for (int r = 0; r < rSize; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < cSize; c++) {
					arr[r][c] = Integer.parseInt(token.nextToken());
					if (arr[r][c] == 1) {
						list.add(new Point(r, c));
					}
				}
			}
			bfsQueue(list);
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					if (arr[r][c] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
			time += tempTime;
		}
		System.out.println(time);
	}

	private static void bfsQueue(ArrayList<Point> start) {
		Queue<Point> queue = new LinkedList<>();
		tempTime = -1;
		boolean[][] visited = new boolean[rSize][cSize];
		for (int i = 0; i < start.size(); i++) {
			queue.offer(start.get(i));
		}
		while (!queue.isEmpty()) {
			tempTime++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (visited[top.r][top.c]) {
					continue;
				}
				visited[top.r][top.c] = true;
				arr[top.r][top.c] = 1;
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && arr[nr][nc] != -1 && !visited[nr][nc]) {
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < rSize && c < cSize;
	}
}
