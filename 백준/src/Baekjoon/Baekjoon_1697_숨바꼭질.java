package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697_숨바꼭질 {
	static int time = 0;
	static boolean[] visited = new boolean[100000 + 1];
	static int end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		end = sc.nextInt();
		if (start == end) {
			System.out.println(0);
		} else {
			bfsQueue(start);
		}
	}

	public static void bfsQueue(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int temp = queue.poll();
				if (visited[temp]) {
					continue;
				}
				visited[temp] = true;
				if (temp == end) {
					System.out.println(time);
					return;
				}
				if (temp + 1 <= 100000 && !visited[temp + 1]) {
					queue.add(temp + 1);
				}
				if (temp - 1 >= 0 && !visited[temp - 1]) {
					queue.add(temp - 1);
				}
				if (temp * 2 <= 100000 && !visited[temp * 2] && start < end) {
					queue.add(temp * 2);
				}
			}
			time++;

		}
	}

}
