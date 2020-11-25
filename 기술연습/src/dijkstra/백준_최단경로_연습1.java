package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_최단경로_연습1 {
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<Point>[] list = new List[V + 1];
		int[] D = new int[V + 1];
		for (int v = 1; v < V + 1; v++) {
			list[v] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			token = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			list[u].add(new Point(v, w));
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(K,0));
		boolean[] visited = new boolean[V + 1];

		for (int v = 1; v < V + 1; v++) {
			if (v == K) {
				D[v] = 0;
			} else {
				D[v] = INF;
			}
		}

		while (!pq.isEmpty()) {
			Point top = pq.poll();
			for (Point next : list[top.v]) {
				if (!visited[next.v] && D[next.v] > D[top.v] + next.weight) {
					D[next.v] = D[top.v] + next.weight;
					pq.add(new Point(next.v,D[next.v]));
				}
			}
			visited[top.v] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (D[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(D[i] + "\n");
			}
		}
		System.out.println(sb.toString());

	}

	static class Point implements Comparable<Point> {
		int v, weight;

		public Point(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		public int compareTo(Point p) {
			return Integer.compare(this.weight, p.weight);
		}

		@Override
		public String toString() {
			return "Point [v=" + v + ", weight=" + weight + "]";
		}
		

	}

}
