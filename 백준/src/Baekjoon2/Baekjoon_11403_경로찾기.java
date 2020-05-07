package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_11403_경로찾기 {
	static int N;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new List[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int idx = Integer.parseInt(token.nextToken());
				if (idx == 1) {
					list[i].add(j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(dfsStack(i, j)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int dfsStack(int start, int end) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		boolean[] visited = new boolean[N];
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			if (visited[top]) {
				continue;
			}
			visited[top] = true;
			for (int i = 0; i < list[top].size(); i++) {
				if (list[top].get(i) == end) {
					return 1;
				}
				if (!visited[list[top].get(i)]) {
					stack.push(list[top].get(i));
				}
			}
		}
		return 0;
	}
}
