package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Baekjoon4.Baejoon_1753_최단경로.Point;

public class Baejoon_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(br.readLine());

		List[] list = new List[V + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int startV = Integer.parseInt(token.nextToken());
			int endV = Integer.parseInt(token.nextToken());
			int height = Integer.parseInt(token.nextToken());
			list[startV].add(new Point(endV, height));
		}

		int[] amt = new int[V + 1];
		Arrays.fill(amt, Integer.MAX_VALUE);
		amt[K] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<Baejoon_1753_최단경로.Point>();
		boolean[] visited = new boolean[V + 1];
		pq.offer(new Point(K, 0));

		while (!pq.isEmpty()) {
			Point top = pq.poll();
			if (visited[top.endV]) {
				continue;
			}

			List temp = list[top.endV];

			for (int i = 0; i < temp.size(); i++) {
				Point next = (Point) temp.get(i);
				if (amt[next.endV] > amt[top.endV] + next.height) {
					amt[next.endV] = amt[top.endV] + next.height;
					pq.offer(new Point(next.endV, next.height));
				}
			}
			visited[top.endV] = true;
		}
		System.out.println(Arrays.toString(amt));
	}

	static class Point implements Comparable<Point> {
		int endV, height;

		public int compareTo(Point o1) {
			return Integer.compare(this.height, o1.height);
		}

		public Point(int endV, int height) {
			super();
			this.endV = endV;
			this.height = height;
		}

	}
}
