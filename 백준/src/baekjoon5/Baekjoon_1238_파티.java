package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1238_파티 {
	static List<Point>[] list;
	static int N, M, X, INF = 123456789;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		X = Integer.parseInt(token.nextToken());
		dist = new int[N + 1][N + 1];
		for (int r = 0; r < N + 1; r++) {
			for (int c = 0; c < N + 1; c++) {
				if (r == c) {
					dist[r][c] = 0;
				} else
					dist[r][c] = INF;
			}
		}
		for (int t = 0; t < M; t++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int cost = Integer.parseInt(token.nextToken());
			dist[start][end] = cost;
		}
		marshal(dist);
		int answer = 0;
		for (int i = 1; i < N + 1; i++) {
			answer = Math.max(dist[i][X] + dist[X][i], answer);

		}
		System.out.println(answer);

	}

	static void marshal(int[][] d) {
		for (int t = 1; t < N + 1; t++) {
			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < N + 1; c++) {
//					if (r != t || c != t) {
					d[r][c] = Math.min(d[r][c], d[r][t] + d[t][c]);
//					}
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int V, D;

		public Point(int v, int d) {
			super();
			V = v;
			D = d;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.D, o.D);
		}

	}

}
