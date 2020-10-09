package 코드챌린지2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem3 {
	static int N, result = Integer.MIN_VALUE;
	static int board[][];

	public static void main(String[] args) {
//		N = 4;
//		makeCombination(3, new int[3], 0, 1);

	}

	static public int solution(int n, int[][] edges) {
		int answer = 0;
		N = n;
		board = new int[n + 1][n + 1];
		List[] list = new List[n + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			list[start].add(end);
			list[end].add(start);
		}
		boolean[] visited = new boolean[n + 1];

		for (int start = 1; start < n + 1; start++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(start);
			for(int i=0;i<n+1;i++) {
				visited[i] =false;
			}
			visited[start] = true;
			int time = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				time++;
				for (int i = 0; i < size; i++) {
					int top = queue.poll();

					for (int s = 0; s < list[top].size(); s++) {
						int next = (int) list[top].get(s);
						if (!visited[next]) {
							board[start][next] = time;
							visited[next] = true;
							queue.offer(next);
						}
					}

				}
			}
		}
		for (int[] arr : board) {
			System.out.println(Arrays.toString(arr));
		}
		List<Integer> tempList = new ArrayList<Integer>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < r; c++) {
				tempList.add(board[r][c]);
			}
		}
		Collections.sort(tempList);
		answer = tempList.get(tempList.size() - 2);

		return answer;
	}

	static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int[] arr = new int[3];
			arr[0] = board[temp[0]][temp[1]];
			arr[1] = board[temp[0]][temp[2]];
			arr[2] = board[temp[1]][temp[2]];
			Arrays.sort(arr);
			result = Math.max(result, arr[1]);

		} else {
			for (int i = start; i <= N; i++) {
				temp[current] = i;
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}
}
