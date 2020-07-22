package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_6118_숨바꼭질 {

	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		visited = new boolean[N+1];

		List[] list = new List[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			if (i == 1) {
				list[start].add(new Point(end, 0));
			} else {
				list[start].add(new Point(end, Integer.MAX_VALUE));
			}
		}
		for (int i = 0; i <= N; i++) {
			System.out.println(list[i].toString());
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();
		

	}

	static class Point implements Comparator<Point> {
		int v, weight;

		public Point(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compare(Point o1, Point o2) {
			return Integer.compare(o1.weight, o2.weight);
		}

		@Override
		public String toString() {
			return "Point [v=" + v + ", weight=" + weight + "]";
		}

	}

	static void bfsQueue() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int top = queue.poll();
				if (visited[top]) {
					continue;
				}
				visited[top] = true;

			}
		}
	}

}
