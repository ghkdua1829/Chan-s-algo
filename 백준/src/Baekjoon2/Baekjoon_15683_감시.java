package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_15683_감시 {
	static int R, C;
	static int[][] arr;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Point> list;
	static int[][] dirs = { {}, { 1, 2, 3, 4 }, { 1, 2 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		arr = new int[R][C];

		list = new ArrayList<>();

		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				if (arr[r][c] != 0 && arr[r][c] != 6) {
					list.add(new Point(r, c, arr[r][c], 0));
				}
			}
		}
//		System.out.println(list);
		makeCombination(list.size(), new Point[list.size()], 0, 0, arr);
	}

	static void makeCombination(int r, Point[] temp, int current, int start, int[][] copy) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
			Stack<Point> stack = new Stack<>();
			for (int i = 0; i < temp.length; i++) {
				stack.push(temp[i]);
			}

			while(!stack.isEmpty()) {
				
			}
		} else {
			for (int i = start; i < list.size(); i++) {
				for (int j = 0; j < dirs[list.get(i).num].length; j++) {
					temp[current] = new Point(list.get(i).r, list.get(i).c, list.get(i).num, dirs[list.get(i).num][j]);
					makeCombination(r, temp, current + 1, i + 1, copy);
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c, num, dir;

		public Point(int r, int c, int num, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", num=" + num + ", dir=" + dir + "]";
		}

	}

}
