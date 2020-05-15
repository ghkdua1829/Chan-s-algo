package Baekjoon2;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Baekjoon_2636_치즈 {
	static int R, C;
	static int[][] arr;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());

		arr = new int[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		list.add(new Point(0, 0));
		int tempCnt = 0;
		int time =0;
		while (true) {
			bfs(list);
			list.clear();
			if(isEmpty()) {
				break;
			}
			time++;
			tempCnt=0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (arr[r][c] == 1 && isOut(new Point(r, c))) {
						list.add(new Point(r, c));
						tempCnt++;
					}
				}
			}

		}
		System.out.println(time);
		System.out.println(tempCnt);
	}

	static boolean isEmpty() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isOut(Point p) {
		for (int s = 0; s < search.length; s++) {
			int nr = p.r + search[s][0];
			int nc = p.c + search[s][1];
			if (isIn(nr, nc) && arr[nr][nc] == 2) {
				return true;
			}
		}
		return false;
	}

	static void bfs(List<Point> list) {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			queue.add(new Point(list.get(i).r, list.get(i).c));
			visited[list.get(i).r][list.get(i).c] = true;
			arr[list.get(i).r][list.get(i).c] = 2;
		}
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 0) {
					visited[nr][nc] = true;
					arr[nr][nc] = 2;
					queue.add(new Point(nr, nc));
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
