package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1389_케빈베이컨의6단계법칙 {
	static List[] friends;
	static int resultNum;
	static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		friends = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			friends[start].add(end);
			friends[end].add(start);
		}
		for (int i = 1; i <= N; i++) {
			int tempCnt = 0;
			for (int j = 1; j <= N; j++) {
				if (j == i) {

				} else {
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.offer(i);
					boolean[] visited = new boolean[N + 1];
					visited[i] = true;
					while (!queue.isEmpty()) {
						int size = queue.size();
						tempCnt++;
						for (int q = 0; q < size; q++) {
							int top = queue.poll();
							if (top == j) {
								queue.clear();
								break;
							}
							for (int l = 0; l < friends[top].size(); l++) {
								if (!visited[(int) friends[top].get(l)]) {
									visited[(int) friends[top].get(l)] = true;
									queue.offer((int) friends[top].get(l));
								}
							}
						}
					}

				}
			}
			if (MAX > tempCnt) {
				MAX = tempCnt;
				resultNum = i;
			}
		}
		System.out.println(resultNum);
	}

}
