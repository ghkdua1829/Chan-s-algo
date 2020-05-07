package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_2644_촌수계산 {
	static List<Integer>[] list;
	static boolean visited[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");

		int peopleNum = Integer.parseInt(tokens.nextToken());
		list = new List[peopleNum + 1];
		visited = new boolean[peopleNum + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		tokens = new StringTokenizer(in.readLine());
		int searchStart = Integer.parseInt(tokens.nextToken());
		int searchEnd = Integer.parseInt(tokens.nextToken());

		tokens = new StringTokenizer(in.readLine());
		int connectNum = Integer.parseInt(tokens.nextToken());
		for (int i = 0; i < connectNum; i++) {
			tokens = new StringTokenizer(in.readLine());

			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		bfsQueue(searchStart, searchEnd);
	}

	public static void bfsQueue(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer top = queue.poll();
				if(top==end) {
					System.out.println(--result);
					return;
				}
				if (visited[top]) {
					continue;
				}
				visited[top] = true;
				for (int j = 0; j < list[top].size(); j++) {
					if (visited[list[top].get(j)]) {
						continue;
					}
					queue.offer(list[top].get(j));
				}
			}

		}
		System.out.println(-1);
	}

}
