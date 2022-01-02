package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_10282_해킹 {
	static int INF = 12345678;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			int k = Integer.parseInt(token.nextToken());
			List<Point>[] list = new List[n + 1];
			for (int i = 0; i < n + 1; i++) {
				list[i] = new ArrayList<Point>();
			}
			for (int i = 0; i < d; i++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				int s = Integer.parseInt(token.nextToken());
				list[b].add(new Point(a, s));
			}
			int[] dist = new int[n + 1];
			Arrays.fill(dist, INF);
			dist[k] = 0;
			boolean[] visited = new boolean[n + 1];
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.offer(new Point(k, dist[k]));
			while (!pq.isEmpty()) {
				Point top = pq.poll();
				for (int s = 0; s < list[top.v].size(); s++) {
					int nextV = list[top.v].get(s).v;
					int nextD = list[top.v].get(s).d;
					
					if (dist[nextV] > top.d + nextD && !visited[nextV]) {
						dist[nextV] = top.d + nextD;
						pq.offer(new Point(nextV, dist[list[top.v].get(s).v]));
					}
				}
				visited[top.v] = true;
			}
			int cnt = 0;
			int maxTime = 0;
			for (int i = 0; i < dist.length; i++) {
				if (dist[i] != INF) {
					cnt++;
					maxTime = Math.max(maxTime, dist[i]);
				}
			}
			System.out.println(cnt + " " + maxTime);
		}
	}

	static class Point implements Comparable<Point> {
		int v, d;

		public Point(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}

		public int compareTo(Point o) {
			return Integer.compare(this.d, o.d);
		}

	}

}
