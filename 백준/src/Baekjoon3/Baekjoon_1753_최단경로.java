package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int[][] board = new int[V + 1][V + 1];
		int startV = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int value = Integer.parseInt(token.nextToken());
			board[start][end] = value;
		}

		boolean[] visited = new boolean[V + 1];
		visited[startV] = true;
		int[] D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);

		D[startV] = 0;

		for (int i = 1; i < V + 1; i++) {
			int min = Integer.MAX_VALUE;
			int target = -1;
			for(int j=1;j<V+1;j++) {
				if(!visited[j]&& min>D[j]) {
					target = j;
					min = D[j];
				}
			}
			
		}
	}

}
