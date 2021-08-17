package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1726_로봇 {

//	입력
//	5 6
//	0 0 0 0 0 0
//	0 1 1 0 1 0
//	0 1 0 0 0 0
//	0 0 1 1 1 0
//	1 0 0 0 0 0
//	4 2 3
//	2 4 1

	static int N, M;
	static int[][] board;
	static boolean[][][] visited;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		M = Integer.parseInt(token.nextToken()); // height
		N = Integer.parseInt(token.nextToken()); // width

		board = new int[M][N];
		visited = new boolean[4][M][N];

		for (int r = 0; r < M; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
			}
		}

		token = new StringTokenizer(br.readLine());

		int startR = Integer.parseInt(token.nextToken());
		int startC = Integer.parseInt(token.nextToken());
		int startDir = Integer.parseInt(token.nextToken());
		if (startDir == 3) {
			startDir = 2;
		} else if (startDir == 2) {
			startDir = 3;
		}

		Point start = new Point(startR - 1, startC - 1, startDir - 1);

		token = new StringTokenizer(br.readLine());

		int endR = Integer.parseInt(token.nextToken());
		int endC = Integer.parseInt(token.nextToken());
		int endDir = Integer.parseInt(token.nextToken());

		if (endDir == 3) {
			endDir = 2;
		} else if (endDir == 2) {
			endDir = 3;
		}

		Point end = new Point(endR - 1, endC - 1, endDir - 1);

		Queue<Point> queue = new LinkedList<>();

		queue.offer(start);
		visited[start.dir][start.r][start.c] = true;

		int cnt = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for (int count = 0; count < size; count++) {

				Point top = queue.poll();

				if (top.r == end.r && top.c == end.c && top.dir == end.dir) {
					queue.clear();
					break;
				}

				int nLeftDir = (4 + (top.dir - 1)) % 4;
				if (!visited[nLeftDir][top.r][top.c]) {
					visited[nLeftDir][top.r][top.c] = true;
					queue.offer(new Point(top.r, top.c, nLeftDir));
				}

				int nRightDir = (4 + (top.dir + 1)) % 4;
				if (!visited[nRightDir][top.r][top.c]) {
					visited[nRightDir][top.r][top.c] = true;
					queue.offer(new Point(top.r, top.c, nRightDir));
				}

				int nr = top.r + dir[top.dir][0];
				int nc = top.c + dir[top.dir][1];
				if (isIn(nr, nc) && !visited[top.dir][nr][nc] && board[nr][nc] != 1) {
					visited[top.dir][nr][nc] = true;
					queue.offer(new Point(nr, nc, top.dir));
				}
				
				if (!isIn(nr, nc) || board[nr][nc] == 1) {
					continue;
				}
				
				nr = top.r + 2 * dir[top.dir][0];
				nc = top.c + 2 * dir[top.dir][1];
				if (isIn(nr, nc) && !visited[top.dir][nr][nc] && board[nr][nc] != 1) {
					visited[top.dir][nr][nc] = true;
					queue.offer(new Point(nr, nc, top.dir));
				}
				
				if (!isIn(nr, nc) || board[nr][nc] == 1) {
					continue;
				}
				
				nr = top.r + 3 * dir[top.dir][0];
				nc = top.c + 3 * dir[top.dir][1];
				if (isIn(nr, nc) && !visited[top.dir][nr][nc] && board[nr][nc] != 1) {
					visited[top.dir][nr][nc] = true;
					queue.offer(new Point(nr, nc, top.dir));
				}
			}
		}
		System.out.println(cnt);

	}

	static boolean isIn(int r, int c) {
		return r < M && r >= 0 && c < N && c >= 0;
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}

}
