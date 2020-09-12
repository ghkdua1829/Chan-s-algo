package KAKAOBLIND2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem4 {
	static int V;
	static List<Edge>[] adj;

	public static void main(String[] args) {
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
		solution(6, 4, 6, 2, fares);
	}

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		V = n;
		int E = fares.length;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			// 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치ㅋ
			adj[fares[i][0] - 1].add(new Edge(fares[i][1] - 1, fares[i][2]));
			adj[fares[i][1] - 1].add(new Edge(fares[i][0] - 1, fares[i][2]));
		}
		//
		// dijkstra
		int[] ss = new int[n];
		Edge[] A = dikArr(a);
		Edge[] B = dikArr(b);
		Edge[] S = dikArr(s);
		for(int i=0;i<n;i++) {
			ss[i] = A[i].weight+B[i].weight+S[i].weight;
		}
		Arrays.sort(ss);
		System.out.println(Arrays.toString(ss));
		for(int i=0;i<ss.length;i++) {
			if(ss[i]>=0) {
				return ss[i];
			}
		}
		return answer;
	}

	static Edge[] dikArr(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		// 0번에서 출발하는걸로.
		for (int i = 0; i < V; i++) {
			// 원하는 출발지
			if (i == start-1) {
				D[i] = new Edge(i, 0);
			} else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			for (Edge next : adj[edge.v]) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if (!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					// decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		return D;
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
