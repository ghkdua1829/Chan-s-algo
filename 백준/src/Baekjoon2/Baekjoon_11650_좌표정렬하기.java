package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_11650_좌표정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			pq.add(new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
		}
		while (!pq.isEmpty()) {
			Point top = pq.poll();
			System.out.println(top.r + " " + top.c);
		}
	}

	static class Point implements Comparable<Point> {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		@Override
		public int compareTo(Point o) {
			if (this.r != o.r) {
				return Integer.compare(this.r, o.r);
			} else {
				return Integer.compare(this.c, o.c);
			}
		}

	}

}
