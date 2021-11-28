package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260_DFS와BFS2 {
	static List[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());

		list = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int t = 0; t < M; t++) {
			token = new StringTokenizer(br.readLine());
			int startV = Integer.parseInt(token.nextToken());
			int endV = Integer.parseInt(token.nextToken());
			list[startV].add(endV);
			list[endV].add(startV);
		}
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(list[i]);
		}
		// DFS
		dfs(V, new boolean[N+1]);
		System.out.println();
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		boolean[] visited = new boolean[N + 1];
		visited[V] = true;
		while (!queue.isEmpty()) {
			int top = queue.poll();
			System.out.print(top + " ");
			List<Integer> temp = list[top];
			for (int i = 0; i < temp.size(); i++) {
				int nextV = temp.get(i);
				if (!visited[nextV]) {
					queue.offer(nextV);
					visited[nextV] = true;
				}
			}
		}
	}

	static void dfs(int V, boolean[] visited) {
		System.out.print(V+" ");
		visited[V] = true;
		List<Integer> temp = list[V];
		for (int i = 0; i < temp.size(); i++) {
			int nextV = temp.get(i);
			if (!visited[nextV]) {
				visited[nextV] = true;
				dfs(nextV, visited);
			}
		}
	}
}
