package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13913_숨바꼭질4 {
	static int N, M, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if(N>M) {
			System.out.println(N-M);
			for(int i=N;i>=M;i--) {
				System.out.print(i+" ");
			}
			return;
		}
		bfsQueue(N);
	}

	public static void bfsQueue(int start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start, ""));
		boolean[] visited = new boolean[100001];
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (top.n == M) {
				System.out.println(top.str.length());
				System.out.print(N + " ");
				for (int j = 0; j < top.str.length(); j++) {
					switch (top.str.charAt(j)) {
					case 'P':
						N++;
						break;
					case 'M':
						N--;
						break;
					case 'G':
						N *= 2;
						break;
					}
					System.out.print(N + " ");
				}
				return;
			}

			if (visited[top.n]) {
				continue;
			}
			visited[top.n] = true;
			if (isIn(top.n + 1)) {
				queue.offer(new Point(top.n + 1, top.str.concat("P")));
			}
			if (isIn(top.n - 1)) {
				queue.offer(new Point(top.n - 1, top.str.concat("M")));
			}
			if (isIn(top.n * 2)) {
				queue.offer(new Point(top.n * 2, top.str.concat("G")));
			}
			result++;

		}
	}

	public static boolean isIn(int n) {
		return n >= 0 && n <= 100000;
	}

	static class Point {
		int n;
		String str;

		public Point(int n, String str) {
			this.n = n;
			this.str = str;
		}

	}
}
