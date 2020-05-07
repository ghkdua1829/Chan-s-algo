package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Beakjoon_2667_단지번호붙이기 {
	static int[] searchR = { 0, -1, 1, 0 };
	static int[] searchC = { -1, 0, 0, 1 };
	static int size;
	private static Queue<Point> queue = new LinkedList<Point>();
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = Integer.parseInt(sc.nextLine());
		String[][] map = new String[size + 2][size + 2];
		for (String[] a : map) {
			Arrays.fill(a, "0");
		}
		for (int r = 1; r < map.length - 1; r++) {
			String src = sc.nextLine();
			src = "0" + src + "0";
			map[r] = src.split("");
		}

		for (int r = 1; r < map.length - 1; r++) {
			for (int c = 1; c < map.length - 1; c++) {
				int sum = 0;
				if (map[r][c].equals("1")) {
					queue.offer(new Point(r, c));
					while (!queue.isEmpty()) {
						Point top = queue.poll();
						if (map[top.r][top.c].equals("0")) {
							continue;
						}
						map[top.r][top.c] = "0";
						sum++;
						for (int s = 0; s < searchR.length; s++) {
							if (map[top.r + searchR[s]][top.c + searchC[s]].equals("1")) {
								queue.offer(new Point(top.r + searchR[s], top.c + searchC[s]));
							}
						}
					}
				}

				if (sum != 0) {
					list.add(sum);
				}
			}
		}
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static boolean isIn(int r, int c) {
		return 0 <= r && r < size && 0 <= c && c < size;
	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

}
