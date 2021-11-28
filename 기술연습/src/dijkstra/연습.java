package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 연습 {

	static int[] arr = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		int num = 0;

		Point p1 = new Point(1, 1, 1);
		List<Point> list = new ArrayList<>();
		list.add(new Point(1, 2, 3));
		list.add(new Point(3, 2, 3));
		list.add(new Point(2, 2, 3));
		Collections.sort(list);
		for(Point p:list) {
			System.out.println(p.toString());
		}
	}

	static void ess(Point p) {
		p.a = 2;
	}

	static void east(int a) {
		a = 5;
	}

	static void makePermutation(int r, int current, int[] temp, boolean[] visited) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = arr[i];
					makePermutation(r, current + 1, temp, visited);
					visited[i] = false;
				}
			}
		}
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
