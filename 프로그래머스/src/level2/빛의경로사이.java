package level2;

import java.util.*;

public class 빛의경로사이 {
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][][] visited;

	public static void main(String[] args) {
		String[] strs = { "R", "R" };
		solution(strs);
	}

	public static int[] solution(String[] grid) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		visited = new boolean[grid.length][grid[0].length()][4];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length(); c++) {
				for (int d = 0; d < 4; d++) {
					if (!visited[r][c][d]) {
						answer.add(shooting(grid, new Point(r, c, d)));
					}
				}
			}
		}
		Collections.reverse(answer);
		int[] s = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			s[i] = answer.get(i);
		}
		return s;
	}

	static Integer shooting(String[] grid, Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		int cnt = 0;
		while (true) {
			Point top = queue.poll();
			if (visited[top.r][top.c][top.dir]) {
				break;
			}
			cnt++;

			visited[top.r][top.c][top.dir] = true;

			if (grid[top.r].charAt(top.c) == 'L') {
				// 다음에 가는 격자가 왼쪽으로 방향을 바꿔야한다면..
				top.dir = (top.dir + 3) % 4;

			} else if (grid[top.r].charAt(top.c) == 'R') {
				top.dir = (top.dir + 1) % 4;
			}
			int nr = (top.r + dirs[top.dir][0] + grid.length) % grid.length;
			int nc = (top.c + dirs[top.dir][1] + grid[0].length()) % grid[0].length();
			int nDir = top.dir;

			queue.offer(new Point(nr, nc, nDir));

		}
		return cnt;
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}