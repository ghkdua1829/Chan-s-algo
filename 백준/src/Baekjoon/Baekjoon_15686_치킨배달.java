package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_15686_치킨배달 {
	static ArrayList<Point> list = new ArrayList<>();
	static ArrayList<Point> listOne = new ArrayList<>();
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int temp = Integer.parseInt(token.nextToken());
				if (temp != 2) {
					arr[r][c] = temp;
					if (temp == 1) {
						listOne.add(new Point(r, c));
					}
				} else {
					list.add(new Point(r, c));
				}
			}
		}
		makeCombination(M, new Point[M], 0, 0);
		System.out.println(min);
	}

	static void makeCombination(int qr, Point[] temp, int current, int start) {
		if (qr == current) {
			int sum = 0;
			for (int i = 0; i < listOne.size(); i++) {
				int minTemp = Integer.MAX_VALUE;
				for (int j = 0; j < temp.length; j++) {
					int a = Math.abs(listOne.get(i).r - temp[j].r) + Math.abs(listOne.get(i).c - temp[j].c);
					if (a < minTemp) {
						minTemp = a;
					}
				}
				sum += minTemp;
			}
			if (sum < min) {
				min = sum;
			}

		} else {
			for (int i = start; i < list.size(); i++) {
				temp[current] = list.get(i);
				makeCombination(qr, temp, current + 1, i + 1);
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
