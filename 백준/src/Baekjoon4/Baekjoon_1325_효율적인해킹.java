package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon_1325_효율적인해킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		List<Integer>[] list = new List[N + 1];
		int[] arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			list[end].add(start);
		}
		for (int i = 1; i < N + 1; i++) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			int count = 0;
			boolean[] visited = new boolean[N + 1];
			visited[i] = true;
			while (!queue.isEmpty()) {
				int top = queue.poll();
				for (int next : list[top]) {
					if (!visited[next]) {
						count++;
						queue.offer(next);
						visited[next] = true;
					}
				}
				arr[i] = count;
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, arr[i]);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

}
