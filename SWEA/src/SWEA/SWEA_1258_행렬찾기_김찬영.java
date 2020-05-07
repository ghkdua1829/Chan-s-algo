package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1258_행렬찾기_김찬영 {
	static int size;

	static Queue<Point> queue;
	static int[][] arr;

	static int[] searchR = { -1, 0, 0, 1 };
	static int[] searchC = { 0, -1, 1, 0 };
	static List<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			queue = new LinkedList<>();
			list = new ArrayList<>();
			size = sc.nextInt();
			arr = new int[size][size];
			int resultCount = 0;
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					if (arr[r][c] != 0) {
						int resultR = 0;
						int resultC = 0;
						int tempR = r;
						int tempC = c;
						while (isIn(tempR, tempC) && arr[tempR][tempC] != 0) {
							tempR++;
							resultR++;
						}
						tempR--;
						while (isIn(tempR, tempC) && arr[tempR][tempC] != 0) {
							tempC++;
							resultC++;
						}
						list.add(new Point(resultR, resultC));
						resultCount++;
						bfsQueue(r, c);
					}
				}
			}

			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					Integer r1 = o1.r;
					Integer r2 = o2.r;
					Integer p1 = o1.r * o1.c;
					Integer p2 = o2.r * o2.c;
					if (o1.r * o1.c == o2.r * o2.c) {
						return r1.compareTo(r2);
					}
					return p1.compareTo(p2);
				}
			});
			System.out.print("#" + tc + " " + resultCount);
			for (Point a : list) {
				System.out.print(a);
			}
			System.out.println();
		}
	}

	public static void bfsQueue(int r, int c) {
		queue.offer(new Point(r, c));
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (arr[top.r][top.c] == 0) {
				continue;
			}
			arr[top.r][top.c] = 0;
			for (int i = 0; i < searchR.length; i++) {
				int nr = top.r + searchR[i];
				int nc = top.c + searchC[i];
				if (isIn(nr, nc) && arr[nr][nc] != 0) {
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < arr.length && c < arr[0].length;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return " " + r + " " + c;
		}

	}

}
