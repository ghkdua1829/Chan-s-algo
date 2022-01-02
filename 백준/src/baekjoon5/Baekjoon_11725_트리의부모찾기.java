package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_11725_트리의부모찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		int[] root = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int s = 0; s < list[top].size(); s++) {
				int next = list[top].get(s);
				if (!visited[next]) {
					root[next] = top;
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		for(int i=2;i<root.length;i++) {
			System.out.println(root[i]);
		}

	}

}
