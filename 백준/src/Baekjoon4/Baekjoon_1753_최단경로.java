package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int startV = Integer.parseInt(br.readLine());
		List<Point>[] list = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			list[u].add(new Point(v, w));
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[startV] = 0;

		pq.add(new Point(startV, 0));

		boolean[] checked = new boolean[V + 1];

		while (!pq.isEmpty()) {
			Point top = pq.poll();
			if (checked[top.v]) {
				continue;
			}

			for (Point next : list[top.v]) {
				if (dist[next.v] >= dist[top.v] + next.dir) {
					dist[next.v] = dist[top.v] + next.dir;
					pq.add(new Point(next.v, dist[next.v]));
				}
			}
			checked[top.v] = true;
		}
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

	static class Point implements Comparable<Point> {
		int v, dir;

		public int compareTo(Point o) {
			return Integer.compare(this.dir, o.dir);
		}

		public Point(int v, int dir) {
			super();
			this.v = v;
			this.dir = dir;
		}

	}

}
