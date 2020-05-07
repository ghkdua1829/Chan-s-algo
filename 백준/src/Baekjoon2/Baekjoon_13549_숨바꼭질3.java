package Baekjoon2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13549_숨바꼭질3 {
	static int N, K, result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if (N == K) {
			System.out.println(0);
		} else if (N > K) {
			System.out.println(N - K);
		} else {
			bfsQueue(N, 0);
		}
	}

	static class Point {
		int nowPoint, doubleCount;

		public Point(int nowPoint, int doubleCount) {
			super();
			this.nowPoint = nowPoint;
			this.doubleCount = doubleCount;
		}

	}

	static void bfsQueue(int start, int doubleCount) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[] visited = new boolean[100001];
		queue.offer(new Point(start, doubleCount));
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (!isIn(top.nowPoint) || visited[top.nowPoint]) {
					continue;
				}
				visited[top.nowPoint] = true;
				if (top.nowPoint * 2 != K) {
					queue.offer(new Point(top.nowPoint * 2, top.doubleCount + 1));
				} else {
					System.out.println(count - (top.doubleCount + 1));
					return;
				}
				if (top.nowPoint - 1 != K) {
					queue.offer(new Point(top.nowPoint - 1, top.doubleCount));
				} else {
					System.out.println(count - top.doubleCount);
					return;
				}
				if (top.nowPoint + 1 != K) {
					queue.offer(new Point(top.nowPoint + 1, top.doubleCount));
				} else {
					System.out.println(count - top.doubleCount);
					return;
				}

			}
		}

	}

	static boolean isIn(int point) {
		return point >= 0 && point < 100001;
	}
}
