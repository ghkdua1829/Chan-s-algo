package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2252_줄세우기 {
	static List<Integer>[] arr;
	static int[] parentCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		StringBuilder sb = new StringBuilder();
		arr = new List[N];
		parentCount = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int tc = 0; tc < M; tc++) {
			token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken()) - 1;
			int B = Integer.parseInt(token.nextToken()) - 1;
			arr[A].add(B);
			parentCount[B]++;
		}
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean bb = false;
		while (!bb) {
			bb = true;
			for (int i = 0; i < arr.length; i++) {
				if (parentCount[i] == 0 && !visited[i]) {
					queue.offer(i + 1);
					bb = false;
					visited[i] = true;
					for (int s = 0; s < arr[i].size(); s++) {
						parentCount[arr[i].get(s)]--;
					}
				}
			}
		}
		while (!queue.isEmpty()) {
			sb.append(queue.poll() + " ");
		}
		System.out.println(sb);
	}

	static class Point {
		Integer index, parentNum;

	}
}
