package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260_DFS와BFS {

	static int N, M, V;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		V = Integer.parseInt(token.nextToken());
		board = new int[1001][1001];

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			board[start][end] = 1;
			board[end][start] = 1;
		}
		dfs(V, new boolean[N + 1]);
		System.out.println();
		bfs(V);
	}

	static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && board[start][i] == 1) {
				dfs(i, visited);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int top = queue.poll();
			System.out.print(top+ " ");
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && board[top][i] == 1) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
