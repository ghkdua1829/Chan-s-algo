package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		PriorityQueue<Point> pq = new PriorityQueue();
		for (int tc = 0; tc < N; tc++) {
			token = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(token.nextToken());
			int V = Integer.parseInt(token.nextToken());
			pq.offer(new Point(W, V));

		}
		System.out.println(pq.size());
		int size = pq.size();
		int tempW = 0;
		int result = 0;
		for (int i = 0; i < size; i++) {
			Point p = pq.poll();
			if (p.w + tempW <= K) {
				tempW += p.w;
				result += p.v;
			} else {
				break;
			}
		}
		System.out.println(result);

	}

	static class Square implements Comparator<Square> {
		int height, width;

		@Override
		public int compare(Square o1, Square o2) {
			return Integer.compare(o2.width, o1.width); // width 내림차순 정렬
		}

	}

	static class Point implements Comparable<Point> {
		double w, v;

		public Point(double w, double v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Point [w=" + w + ", v=" + v + "]";
		}

		@Override
		public int compareTo(Point o) {
			double one = this.v / this.w;
			double two = o.v / o.w;
			if (one > two) {
				return -1;
			} else if (one < two) {
				return 1;
			} else {
				if (this.v > o.v) {
					return -1;
				} else {
					return 1;
				}
			}
		}

	}

}
