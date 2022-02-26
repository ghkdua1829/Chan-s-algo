package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1922_네트워크연결 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int t = 0; t < M; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int dist = Integer.parseInt(token.nextToken());
			list.add(new Point(start, end, dist));
		}
		Collections.sort(list);
		int[] root = new int[N + 1];

		for (int i = 0; i < root.length; i++) {
			root[i] = i;
		}
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Point point = list.get(i);
			int start = point.start;
			int end = point.end;
			int dist = point.dist;
			start = find(root,start);
			end = find(root,end);
			if(start!= end) {
				union(root,start,end);
				result += dist;
			}
		}
		System.out.println(result);

	}

	static int find(int[] parent, int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return find(parent, parent[x]);
		}
	}

	static void union(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	static class Point implements Comparable<Point> {
		int start, end, dist;

		public Point(int start, int end, int dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		public int compareTo(Point p) {
			return Integer.compare(this.dist, p.dist);
		}
	}

}
