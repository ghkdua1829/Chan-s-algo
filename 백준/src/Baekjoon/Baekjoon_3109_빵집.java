package Baekjoon;

import java.util.*;

public class Baekjoon_3109_빵집 {

	static String[][] pipe;

	static int[] searchR = { -1, 0, 1 };
	static int[] searchC = { 1, 1, 1 };

	static List<Point> tempList;

	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] RC = sc.nextLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		visited = new boolean[R][C];

		int result = 0;
		pipe = new String[R][C];
		for (int r = 0; r < R; r++) {
			String[] map = sc.nextLine().split("");
			for (int i = 0; i < map.length; i++) {
				pipe[r][i] = map[i];
			}
		}
		for (int r = 0; r < pipe.length; r++) {
			tempList = new ArrayList<>();
			boolean resultPoint = false;
			int tempR = r, tempC = 0;
			while (true) {
				int breakCount = 0;
				for (int s = 0; s < searchR.length; s++) {
					int nr = tempR + searchR[s];
					int nc = tempC + searchC[s];
					if (isIn(nr, nc) && pipe[nr][nc].equals(".")) {
						tempList.add(new Point(nr, nc));
						tempR = nr;
						tempC = nc;
						if (tempC == C - 1) {
							resultPoint = true;
						}
						break;
					} else {
						breakCount++;
					}
				}
				if (breakCount == 3) {
					break;
				}
			}
			if (resultPoint == true) {
				result++;
				for (int i = 0; i < tempList.size(); i++) {
					pipe[tempList.get(i).r][tempList.get(i).c] = "V";
				}
			}
		}
		for (String[] a : pipe) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(result);
	}

	public static void backTracking(Point start) {
		String[][] temp = pipe;
		Stack<Point> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Point top = stack.pop();
			if(visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			
		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < pipe.length && c < pipe[0].length;
	}
}
