package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Dijkstra {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<Point>[] list = new List[V + 1];
		boolean[] visited = new boolean[V + 1];
		Point[] D = new Point[V + 1];
		for (int v = 1; v < V + 1; v++) {
			list[v] = new ArrayList<>();
			if (v == start) {
				D[v] = new Point(v, 0);
			} else {
				D[v] = new Point(v, INF);
			}
			pq.add(D[v]);
		}

		for (int e = 0; e < E; e++) {
			token = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			list[u].add(new Point(v, w));
		}
		while (!pq.isEmpty()) {
			Point top = pq.poll();
			for (Point next : list[top.v]) {
				if (!visited[next.v] && D[next.v].d > D[top.v].d + next.d) {
					System.out.println("before "+D[next.v]);
					D[next.v].d = D[top.v].d + next.d;
					System.out.println("after "+D[next.v]);

					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			visited[top.v] = true;
		}
		StringBuilder sb =new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (D[i].d == INF) {
				sb.append("INF\n");
//				System.out.println("INF");
			} else {
				sb.append(D[i].d+"\n");
//				System.out.println(D[i].d);
			}
		}

		System.out.println(sb.toString());
	}

	static class Point implements Comparable<Point> {
		int v, d;

		public Point(int idx, int d) {
			super();
			this.v = idx;
			this.d = d;
		}

		public int compareTo(Point p) {
			return Integer.compare(this.d, p.d);
		}

		@Override
		public String toString() {
			return "Point [idx=" + v + ", d=" + d + "]";
		}

	}
}
