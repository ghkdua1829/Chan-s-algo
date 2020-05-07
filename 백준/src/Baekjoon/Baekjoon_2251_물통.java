package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2251_물통 {
	static int[] arr = { 1, 2, 3, 4, 5 };
	static boolean[][][] visited = new boolean[201][201][201];
	static HashSet<Integer> result = new HashSet<Integer>();
	static int ASize, BSize, CSize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ASize = sc.nextInt();
		BSize = sc.nextInt();
		CSize = sc.nextInt();
		bfsQueue(new Point(0, 0, CSize));
		List<Integer> list = new ArrayList<Integer>(result);
		Collections.sort(list);
		for(int e:list) {
			System.out.print(e+" ");
		}
	}

	public static void bfsQueue(Point p) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(p);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (visited[top.A][top.B][top.C]) {
				continue;
			}
			visited[top.A][top.B][top.C] = true;
			if (top.A == 0) {
				// A가 0일 때
				result.add(top.C);
			}

			// A가 0보다 클때 다른 것에 부을 수 있다.
			if (top.A > 0) {

				// A->B 붓기
				if (top.A >= BSize) {
					queue.offer(new Point(top.A - (BSize - top.B), BSize, top.C));
				} else {
					if (BSize - top.B <= top.A) {
						queue.offer(new Point(top.A - (BSize - top.B), BSize, top.C));
					} else {
						queue.offer(new Point(0, top.A + top.B, top.C));
					}
				}

				// A->C 붓기
				if (top.A >= CSize) {
					queue.offer(new Point(top.A - (CSize - top.C), top.B, CSize));
				} else {
					if (CSize - top.C <= top.A) {
						queue.offer(new Point(top.A - (CSize - top.C), top.B, CSize));
					} else {
						queue.offer(new Point(0, top.B, top.A + top.C));
					}
				}

			}

			if (top.B > 0) {

				// B->A 붓기
				if (top.B >= ASize) {
					queue.offer(new Point(ASize, top.B - (ASize - top.A), top.C));
				} else {
					if (ASize - top.A <= top.B) {
						queue.offer(new Point(ASize, top.B - (ASize - top.A), top.C));
					} else {
						queue.offer(new Point(top.A + top.B, 0, top.C));
					}
				}

				// B->C 붓기
				if (top.B >= CSize) {
					queue.offer(new Point(top.A, top.B - (CSize - top.C), CSize));
				} else {
					if (CSize - top.C <= top.B) {
						queue.offer(new Point(top.A, top.B - (CSize - top.C), CSize));
					} else {
						queue.offer(new Point(top.A, 0, top.B + top.C));
					}
				}
			}

			if (top.C > 0) {
				// C->A 붓기
				if (top.C >= ASize) {
					queue.offer(new Point(ASize, top.B, top.C - (ASize - top.A)));
				} else {
					if (ASize - top.A <= top.C) {
						queue.offer(new Point(ASize, top.B, top.C - (ASize - top.A)));
					} else {
						queue.offer(new Point(top.A + top.C, top.B, 0));
					}
				}

				// C->B 붓기
				if (top.C >= BSize) {
					queue.offer(new Point(top.A, BSize, top.C - (BSize - top.B)));
				} else {
					if (BSize - top.B <= top.C) {
						queue.offer(new Point(top.A, BSize, top.C - (BSize - top.B)));
					} else {
						queue.offer(new Point(top.A, top.B + top.C, 0));
					}
				}
			}

		}
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [A=" + A + ", B=" + B + ", C=" + C + "]";
		}

		int A, B, C;

		public Point(int a, int b, int c) {
			A = a;
			B = b;
			C = c;
		}

	}
}
