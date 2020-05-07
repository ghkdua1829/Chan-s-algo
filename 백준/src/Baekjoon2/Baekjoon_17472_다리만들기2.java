package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17472_다리만들기2 {
	static int R, C, islandId;
	static int[][] arr;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] graph;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		islandId = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 1) {
					bfs(r, c);
					islandId++;
				}
			}
		}
		graph = new int[islandId][islandId];
		for (int[] row : graph) {
			Arrays.fill(row, 20);

		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] != 0) {
					bfsBridge(r, c);
				}
			}
		}
		PriorityQueue<Dot> pq = new PriorityQueue<>();
		for (int r = 0; r < graph.length; r++) {
			for (int c = r + 1; c < graph.length; c++) {
				if (graph[r][c] != 20 && graph[r][c] != 1) {
					pq.add(new Dot(r, c, graph[r][c]));
				}
			}
		}
		parent = new int[islandId - 2];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int result = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Dot top = pq.poll();
			int a = find(top.start - 2);
			int b = find(top.end - 2);
			if (a == b) {
				continue;
			}
			union(a, b);
			result += top.weight;
			cnt++;
			if (cnt == parent.length - 1) {
				break;
			}
		}
		for (int i = 0; i < parent.length-1; i++) {
			if (find(parent[i]) != find(parent[i+1])) {
				System.out.println(-1);
				return;
			}
		}
		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);

		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static class Dot implements Comparable<Dot> {
		int start, end, weight;

		public Dot(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Dot [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Dot o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	private static void bfsBridge(int r, int c) {
		for (int s = 0; s < search.length; s++) {

			for (int l = 1;; l++) {
				int nr = r + search[s][0] * l;
				int nc = c + search[s][1] * l;

				if (!isIn(nr, nc)) {
					break;
				}
				if (arr[nr][nc] == arr[r][c]) {
					break;
				}
				if (arr[nr][nc] != 0) {
					if (l - 1 != 1 && graph[arr[r][c]][arr[nr][nc]] != 1)
						graph[arr[r][c]][arr[nr][nc]] = Math.min(l - 1, graph[arr[r][c]][arr[nr][nc]]);
					break;
				}
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));

		while (!queue.isEmpty()) {
			Point top = queue.poll();

			arr[top.r][top.c] = islandId;

			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && arr[nr][nc] == 1) {
					queue.offer(new Point(nr, nc));
				}
			}
		}
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
