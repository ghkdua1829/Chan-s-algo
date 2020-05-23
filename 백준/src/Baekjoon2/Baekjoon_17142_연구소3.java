package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.MARSHAL;

public class Baekjoon_17142_연구소3 {
	static int N, M, MIN = Integer.MAX_VALUE;
	static int[][] arr;
	static List<Point> list;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N][N];
		list = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				if (arr[r][c] == 2) {
					list.add(new Point(r, c));
				}
			}
		}
		if(isEnd(arr)) {
			System.out.println(0);
			return;
		}
		makeCombination(M, new Point[M], 0, 0);
		if(MIN==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(MIN-1);

	}

	static void makeCombination(int rr, Point[] temp, int current, int start) {
		if (rr == current) {
			int[][] tempArr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					tempArr[r][c] = arr[r][c];
				}
			}
			for (int i = 0; i < temp.length; i++) {
				int r = temp[i].r;
				int c = temp[i].c;
				tempArr[r][c] = -1;
			}

			Queue<Point> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < temp.length; i++) {
				queue.offer(temp[i]);
				visited[temp[i].r][temp[i].c] = true;
			}
			int time = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				time++;
				if (isEnd(tempArr)) {
					MIN = Math.min(MIN, time);
				}
				for (int i = 0; i < size; i++) {
					Point top = queue.poll();
					for (int s = 0; s < search.length; s++) {
						int nr = top.r + search[s][0];
						int nc = top.c + search[s][1];
						if (isIn(nr, nc) && !visited[nr][nc] && tempArr[nr][nc] != 1 ) {
							if (tempArr[nr][nc] == 2) {
								queue.offer(new Point(nr, nc));
								tempArr[nr][nc] = -1;
								visited[nr][nc] = true;
							} else if (tempArr[nr][nc] == 0) {
								queue.offer(new Point(nr, nc));
								tempArr[nr][nc] = -1;
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
			return;
		} else {
			for (int i = start; i < list.size(); i++) {
				temp[current] = list.get(i);
				makeCombination(rr, temp, current + 1, i + 1);
			}
		}
	}

	static boolean isEnd(int[][] temp) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (temp[r][c] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
