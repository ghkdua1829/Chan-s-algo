package dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 연습 {

	public static void main(String[] args) {

		PriorityQueue<Point> pq = new PriorityQueue<연습.Point>();
		Point[] D = new Point[3];
		for (int i = 0; i < 3; i++) {
			D[i] = new Point(i, 2, 3);
			pq.add(D[i]);
		}
		System.out.println(System.identityHashCode(D[0]));
		D[0] = new Point(0,2,3);
		System.out.println(System.identityHashCode(D[0]));

		pq.remove(D[0]);
		System.out.println(pq.peek());
	}

	static class Point implements Comparable<Point> {
		int a, b, c;

		public Point(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		

		@Override
		public String toString() {
			return "Point [a=" + a + ", b=" + b + ", c=" + c + "]";
		}


		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.a, o.a);
		}

	}
}
