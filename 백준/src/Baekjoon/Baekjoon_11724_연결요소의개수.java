package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_11724_연결요소의개수 {

	private static List<Integer>[] graph;
	private static boolean[] visited;
	static int M;
	static Scanner sc;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		graph = new List[N + 1];
		visited = new boolean[N + 1];
		makeGraph();
		bfsQueue();
	}

	public static void bfsQueue() {
		int count = 0;
		for (int a = 1; a < visited.length; a++) {
			if (!visited[a]) {
				queue.offer(a);
				while (!queue.isEmpty()) {
					Integer top = queue.poll();
					if (visited[top]) {
						continue;
					}
					visited[top] = true;
					List<Integer> childs = graph[top];
					for (int i = 0; i < childs.size(); i++) {
						Integer child = childs.get(i);
						if (!visited[child]) {
							queue.offer(child);
						}
					}
				}
				count++;
			}
		}
		System.out.println(count);

	}

	private static void makeGraph() {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}
	}
}
