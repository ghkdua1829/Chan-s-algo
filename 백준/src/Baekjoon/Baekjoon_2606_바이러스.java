package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2606_바이러스 {
	static List<Integer>[] list;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computerNum = sc.nextInt();
		int connectNum = sc.nextInt();
		list = new List[computerNum + 1];
		visited = new boolean[computerNum + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < connectNum; i++) {
			int startCom = sc.nextInt();
			int endCom = sc.nextInt();
			list[startCom].add(endCom);
			list[endCom].add(startCom);
		}
		bfsQueue(1);
	}

	public static void bfsQueue(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Integer top = queue.poll();
			if (visited[top]) {
				continue;
			}
			visited[top] = true;
			result++;
			for(int i=0;i<list[top].size();i++) {
				if(visited[list[top].get(i)]) {
					continue;
				}
				queue.offer(list[top].get(i));
			}
		}
		System.out.println(--result);
	}

}
