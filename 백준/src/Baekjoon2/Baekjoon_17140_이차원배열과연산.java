package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_17140_이차원배열과연산 {
	static int r, c, k, rSize, cSize;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(token.nextToken()) - 1;
		int c = Integer.parseInt(token.nextToken()) - 1;
		int k = Integer.parseInt(token.nextToken());
		rSize = 3;
		cSize = 3;
		arr = new int[101][101];

		for (int i = 0; i < 3; i++) {
			token = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
			arr[i][2] = Integer.parseInt(token.nextToken());
		}
		int time = 0;
		while (true) {
			if (arr[r][c] == k) {
				break;
			}
			if (rSize >= cSize) {
				rCal();
			} else {
				cCal();
			}
			if (time > 100) {
				time = -1;
				break;
			}
			time++;
		}
		System.out.println(time);
	}

	static void rCal() {
		int maxC = 0;

		for (int r = 0; r < rSize; r++) {
			int[] tempArr = new int[101];
			List<Point> list = new ArrayList<>();
			for (int c = 0; c < cSize; c++) {
				tempArr[arr[r][c]]++;
			}

			for (int i = 1; i < tempArr.length; i++) {
				if (tempArr[i] > 0) {
					list.add(new Point(i, tempArr[i]));
				}
				if (list.size() == 50) {
					break;
				}
			}
			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.cnt == o2.cnt) {
						return o1.i.compareTo(o2.i);
					} else {
						return o1.cnt.compareTo(o2.cnt);
					}
				}
			});
			int k = 0;
			for (int i = 0; i < 101; i++) {
				arr[r][i] = 0;
			}

			for (int i = 0; i < list.size(); i++) {
				arr[r][k++] = list.get(i).i;
				arr[r][k++] = list.get(i).cnt;

			}
			if (maxC < k) {
				maxC = k;
			}
		}

		cSize = maxC;
	}

	static void cCal() {
		int maxR = 0;

		for (int c = 0; c < cSize; c++) {
			int[] tempArr = new int[101];
			List<Point> list = new ArrayList<>();
			for (int r = 0; r < rSize; r++) {
				tempArr[arr[r][c]]++;
			}

			for (int i = 1; i < tempArr.length; i++) {
				if (tempArr[i] > 0) {
					list.add(new Point(i, tempArr[i]));
				}
				if (list.size() == 50) {
					break;
				}
			}
			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.cnt == o2.cnt) {
						return o1.i.compareTo(o2.i);
					} else {
						return o1.cnt.compareTo(o2.cnt);
					}
				}
			});
			int k = 0;
			for (int i = 0; i < 101; i++) {
				arr[i][c] = 0;
			}

			for (int i = 0; i < list.size(); i++) {
				arr[k++][c] = list.get(i).i;
				arr[k++][c] = list.get(i).cnt;

			}
			if (maxR < k) {
				maxR = k;
			}
		}

		rSize = maxR;
	}

	static class Point {
		Integer i, cnt;

		public Point(int i, int cnt) {
			super();
			this.i = i;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", cnt=" + cnt + "]";
		}

	}
}
