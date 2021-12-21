package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] bus = new int[N + 1];
		List[] road = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			road[i] = new ArrayList<Point>();
		}
		for (int t = 0; t < M; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int cost = Integer.parseInt(token.nextToken());
			road[start].add(new Point(end, cost));
		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(road[i]);
		}

		StringTokenizer token = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, 987654321);
		dist[start] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		while (!pq.isEmpty()) {
			Point top = pq.poll();
//			int next = top.v;
//			if (!visited[next]) {
//				visited[next] = true;
//				for (int i = 0; i < road[next].size(); i++) {
//					Point node = (Point) road[next].get(i);
//					if (!visited[node.v] && dist[node.v] > dist[next] + node.cost) {
//						dist[node.v] = dist[next] + node.cost;
//						pq.add(new Point(top.v, 0));
//					}
//				}
//			}

			for (int i = 0; i < road[top.v].size(); i++) {
				Point next = (Point) road[top.v].get(i);
				if (!visited[next.v] && dist[next.v] > dist[top.v] + next.cost) {
					dist[next.v] = dist[top.v] + next.cost;
					pq.add(new Point(next.v, dist[next.v]));
				}
			}

		}
		System.out.println(dist[end]);

	}

	static class Point implements Comparable<Point> {
		int v, cost;

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}

		public Point(int end, int cost) {
			super();
			this.v = end;
			this.cost = cost;
		}

	}

}
