package Baekjoon2;

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

		boolean[] visited = new boolean[V + 1];
		Edge[] D = new Edge[V + 1];
		List<Edge>[] list = new List[V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			list[start].add(new Edge(end, weight));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i < V + 1; i++) {
			if (i == startV) {
				D[i] = new Edge(i, 0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while (!pq.isEmpty()) {
			Edge shortest = pq.poll();
			visited[shortest.v] = true;
			for (Edge next : list[shortest.v]) {
				if (!visited[next.v] && D[next.v].weight > next.weight + D[shortest.v].weight) {
					D[next.v].weight = next.weight + D[shortest.v].weight;
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
		}
		System.out.println(Arrays.toString(D));
	}

	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", weight=" + weight + "]";
		}

	}

}
