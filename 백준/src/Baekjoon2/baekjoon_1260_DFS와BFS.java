package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_1260_DFS와BFS {
	static int N, M, V;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		V = Integer.parseInt(token.nextToken());
		list = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		for (int i = 0; i <= N; i++) {
			Collections.sort(list[i]);
		}
		dfsStack(V);
		bfsQueue(V);
	}

	static void bfsQueue(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[N + 1];
		while (!queue.isEmpty()) {
			Integer top = queue.poll();
			if (visited[top]) {
				continue;
			}
			visited[top] = true;
			sb.append(top + " ");
			for (int i = 0; i < list[top].size(); i++) {
				queue.offer(list[top].get(i));
			}
		}
		System.out.println(sb);
	}

	static void dfsStack(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[N + 1];
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			if (visited[top]) {
				continue;
			}
			visited[top] = true;
			sb.append(top + " ");
			for (int i = list[top].size()-1; i >= 0; i--) {
				if (!visited[list[top].get(i)]) {
					stack.push(list[top].get(i));
				}
					
			}
		}
		System.out.println(sb);
	}
}
