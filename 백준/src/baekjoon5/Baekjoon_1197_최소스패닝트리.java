package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1197_최소스패닝트리 {
	static int INF = 12345678;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		boolean[] visited = new boolean[V + 1];
		List<Point>[] list = new List[V + 1];
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int dist = Integer.parseInt(token.nextToken());
			list[start].add(new Point(end, dist));
			list[end].add(new Point(start, dist));

		}
		int[] D = new int[V + 1];
		Arrays.fill(D, INF);
		D[1] = 0;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(1, 0));
		int result = 0;
		while (!pq.isEmpty()) {
			Point start = pq.poll();
			if (visited[start.v]) {
				continue;
			}
			for (int s = 0; s < list[start.v].size(); s++) {
				Point next = list[start.v].get(s);
				if (D[next.v] > next.dist && !visited[next.v]) {
					D[next.v] = next.dist;
					pq.offer(new Point(next.v, D[next.v]));
				}
			}
			visited[start.v] = true;

		}
		for(int i=1;i<D.length;i++) {
			result += D[i];
		}
		System.out.println(result);

	}

	static class Point implements Comparable<Point> {
		int v, dist;

		public Point(int v, int dist) {
			super();
			this.v = v;
			this.dist = dist;
		}

		public int compareTo(Point p) {
			return Integer.compare(this.dist, p.dist);
		}
	}

}
