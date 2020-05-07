package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1753_최단경로 {
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(br.readLine());
		List<Edge>[] adj = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken()) - 1;
			int end = Integer.parseInt(token.nextToken()) - 1;
			int value = Integer.parseInt(token.nextToken());
			adj[start].add(new Edge(end, value));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] D = new Edge[V];
		for (int i = 0; i < V; i++) {
			// 원하는 출발지
			if (i == K - 1) {
				D[i] = new Edge(i, 0);
			} else {
				D[i] = new Edge(i, INF);
			}
			pq.add(D[i]);
		}
		boolean[] visited = new boolean[V];
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			for (Edge next : adj[edge.v]) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if (!visited[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					// decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			visited[edge.v] = true;
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < D.length; i++) {
			if ( INF==D[i].weight) {
				sb.append("INF\n");
			} else {
				sb.append(D[i].weight + "\n");

			}
		}
		System.out.println(sb);
	}

	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return weight + "";
		}

	}
}
