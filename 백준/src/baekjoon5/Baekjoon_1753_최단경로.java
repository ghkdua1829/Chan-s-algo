package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1753_최단경로 {
	static int INF = 1234567;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int startV = Integer.parseInt(br.readLine());
		List<Point>[] D = new List[V + 1];
		for (int i = 1; i < V + 1; i++) {
			D[i] = new ArrayList<Point>();
		}

		for (int t = 0; t < E; t++) {
			token = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			D[u].add(new Point(v, w));
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(startV, 0));

		int[] dist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(dist, INF);
		dist[startV] = 0;
		while (!pq.isEmpty()) {
			Point start = pq.poll();
			for (int s = 0; s < D[start.v].size(); s++) {
				int nextV = D[start.v].get(s).v;
				int nextW = D[start.v].get(s).w;
				if (dist[nextV] > dist[start.v] + nextW && !visited[start.v]) {
					dist[nextV] = dist[start.v] + nextW;
					pq.offer(new Point(nextV, dist[nextV]));
				}
			}
			visited[start.v] = true;

		}
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else
				System.out.println(dist[i]);
		}

	}

	static class Point implements Comparable<Point> {
		int v, w;

		Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Point p1) {
			return Integer.compare(this.w, p1.w);

		}

	}
}
