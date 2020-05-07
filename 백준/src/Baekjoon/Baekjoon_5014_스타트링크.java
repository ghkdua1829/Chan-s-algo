package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_5014_스타트링크 {
	static int F, S, G, U, D, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();

		bfsQueue(S);
	}

	public static boolean isIn(int s) {
		return s > 0 && s <= F;
	}

	public static void bfsQueue(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[F + 1];
		queue.offer(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int top = queue.poll();
				if (top == G) {
					System.out.println(result);
					return;
				}
				if (visited[top]) {
					continue;
				}
				visited[top] = true;
				if (isIn(top + U) && !visited[top + U]) {
					queue.offer(top + U);
				}

				if (isIn(top - D) && !visited[top - D]) {
					queue.offer(top - D);
				}
			}
			result++;
		}
		System.out.println("use the stairs");
	}
}
