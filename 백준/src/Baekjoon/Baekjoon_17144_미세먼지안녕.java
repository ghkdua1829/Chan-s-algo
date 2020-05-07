package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17144_미세먼지안녕 {
	static int[][] arr;
	static int R, C, T, result;
	static ArrayList<Point> list = new ArrayList<>();
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Point machineOne, machineTwo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		T = Integer.parseInt(token.nextToken());
		arr = new int[R][C];
		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				if (arr[r][c] == -1) {
					machineTwo = new Point(r, c, arr[r][c]);
				}
			}
		}
		machineOne = new Point(machineTwo.r - 1, machineTwo.c, arr[machineTwo.r - 1][machineTwo.c]);
		for (int t = 0; t < T; t++) {
			list = new ArrayList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (arr[r][c] >= 5) {
						list.add(new Point(r, c, arr[r][c]));
					}
				}
			}
			bfsQueue(list);
			for (int r = machineOne.r - 1; r >= 1; r--) {
				arr[r][0] = arr[r - 1][0];
			}
			for (int c = 0; c < C - 1; c++) {
				arr[0][c] = arr[0][c + 1];
			}
			for (int r = 0; r <= machineOne.r - 1; r++) {
				arr[r][C - 1] = arr[r + 1][C - 1];
			}
			for (int c = C - 1; c >= 1; c--) {
				if (c == 1) {
					arr[machineOne.r][c] = 0;
				} else {
					arr[machineOne.r][c] = arr[machineOne.r][c - 1];
				}
			}

			for (int r = machineTwo.r + 1; r < R - 1; r++) {
				arr[r][0] = arr[r + 1][0];
			}
			for (int c = 0; c < C - 1; c++) {
				arr[R - 1][c] = arr[R - 1][c + 1];
			}

			for (int r = R - 1; r >= machineTwo.r + 1; r--) {
				arr[r][C - 1] = arr[r - 1][C - 1];
			}

			for (int c = C - 1; c >= 1; c--) {
				if (c == 1) {
					arr[machineTwo.r][c] = 0;
				} else {
					arr[machineTwo.r][c] = arr[machineTwo.r][c - 1];
				}
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] != -1) {
					result += arr[r][c];
				}
			}
		}
		System.out.println(result);
	}

	static void bfsQueue(ArrayList<Point> start) {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < start.size(); i++) {
			queue.offer(start.get(i));
		}
		while (!queue.isEmpty()) {
			int count = 0;
			Point top = queue.poll();
			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && arr[nr][nc] != -1) {
					count++;
					arr[nr][nc] += top.value / 5;
				}
			}
			arr[top.r][top.c] -= (top.value / 5) * count;
		}
	}

	static class Point {

		public Point(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		int r, c, value;

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
