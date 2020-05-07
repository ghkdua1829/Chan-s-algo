package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1647_도시분할계획 {
	static int[] root;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		root = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			root[i] = i;
		}
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			pq.add(new Point(start, end, weight));
		}
		int last=0;
		while (!pq.isEmpty()) {
			Point top = pq.poll();
			if (find(top.start) == find(top.end)) {
				continue;
			}
			union(top.start, top.end);
			result += top.weight;
			last = top.weight;
		}
		System.out.println(result-last);
	}

	static int find(int x) {
		if (x == root[x]) {
			return x;
		}
		return root[x] = find(root[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		root[x] = y;
	}

	static class Point implements Comparable<Point> {
		int start, end, weight;

		public Point(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Point [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}

	}
}
