package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_9372_상근이의여행 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			List[] list = new List[N + 1];
			for (int a = 0; a <= N; a++) {
				list[a] = new ArrayList<Integer>();
			}

			for (int j = 0; j < M; j++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(1);
			boolean[] visited = new boolean[N + 1];
			visited[1] = true;
			int count = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int k = 0; k < size; k++) {
					int top = queue.poll();
					for (int s = 0; s < list[top].size(); s++) {
						int next = (int) list[top].get(s);
						if (!visited[next]) {
							count++;
							queue.offer(next);
							visited[next] =true;
						}
					}
				}
			}
			System.out.println(count);
		}
	}

}
