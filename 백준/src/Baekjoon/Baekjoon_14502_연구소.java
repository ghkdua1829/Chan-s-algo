package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_14502_연구소 {
	static int[][] lab;
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visited;
	static int[] searchR = { 0, -1, 1, 0 };
	static int[] searchC = { -1, 0, 0, 1 };
	static int rSize, cSize, result, min = Integer.MIN_VALUE;
	static List<Point> wallList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rSize = sc.nextInt();
		cSize = sc.nextInt();
		visited = new boolean[rSize][cSize];
		lab = new int[rSize][cSize];
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				lab[r][c] = sc.nextInt();
			}
		}
		List<Point> virusList = new ArrayList<>();
		wallList = new ArrayList<>();
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				if (lab[r][c] == 2) {
					virusList.add(new Point(r, c));
				}
				if (lab[r][c] == 0) {
					wallList.add(new Point(r, c));
				}
			}
		}
		makeCombination(3, new Point[3], 0, 0);
		System.out.println(min);

	}

	public static void bfsQueue(List<Point> plist, int[][] tempLab) {
		visited = new boolean[rSize][cSize];
		for (int i = 0; i < plist.size(); i++) {
			queue.offer(plist.get(i));
		}
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			tempLab[top.r][top.c] = 2;
			if (visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			for (int s = 0; s < searchR.length; s++) {
				int nr = top.r + searchR[s];
				int nc = top.c + searchC[s];
				if (isIn(nr, nc) && !visited[nr][nc] &&tempLab[nr][nc]==0) {
					queue.offer(new Point(nr, nc));
				}
			}
		}
		result = 0;
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				if (tempLab[r][c] == 0) {
					result++;
				}
			}
		}
		if(result>min) {
			min = result;
		}
	}

	public static void makeCombination(int A, Point[] temp, int current, int start) {
		if (A == current) {
			int[][] tempLab =new int[rSize][cSize];
			for(int i =0;i<rSize;i++) {
				for(int j=0;j<cSize;j++) {
					tempLab[i][j]=lab[i][j];
				}
			}
			for (int i = 0; i < temp.length; i++) {
				tempLab[temp[i].r][temp[i].c] = 1;
			}
			List<Point> virusList = new ArrayList<>();
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {
					if (tempLab[r][c] == 2) {
						virusList.add(new Point(r, c));
					}
					if (tempLab[r][c] == 1) {
						visited[r][c] = true;
					}
				}
			}
			bfsQueue(virusList, tempLab);
		} else {
			for (int i = start; i < wallList.size(); i++) {
				temp[current] = wallList.get(i);
				makeCombination(A, temp, current + 1, i + 1);
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < rSize && c >= 0 && c < cSize;
	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
