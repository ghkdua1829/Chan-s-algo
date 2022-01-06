package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2234_성곽 {
	static int[][] board;
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static int big = 0;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		board = new int[M][N];
		for (int r = 0; r < M; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		visited = new boolean[M][N];
		int roomCnt = 0;

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					bfs(new Point(r, c));
					roomCnt++;
				}
			}
		}
		System.out.println(roomCnt);
		System.out.println(big);

		int twoRoom = 0;

		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				for (int s = 0; s < search.length; s++) {
					int nr = r + search[s][0];
					int nc = c + search[s][1];
					if (isIn(nr, nc) && board[r][c] != board[nr][nc]) {
						twoRoom = Math.max(twoRoom, board[r][c] + board[nr][nc]);
					}
				}
			}
		}
		if (twoRoom == 0) {
			twoRoom = board[0][0] * 2;
		}
		System.out.println(twoRoom);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < M && c < N;
	}

	static void bfs(Point start) {
		int cnt = 1;
		visited[start.r][start.c] = true;
		List<Point> list = new ArrayList<>();
		Queue<Point> queue = new LinkedList<>();
		list.add(start);
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			String tenToTwo = String.format("%04d", Integer.parseInt(Integer.toBinaryString(board[top.r][top.c])));
			for (int s = 0; s < tenToTwo.length(); s++) {
				int a = tenToTwo.charAt(s) - '0';
				if (a == 0) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (!visited[nr][nc]) {
						queue.offer(new Point(nr, nc));
						list.add(new Point(nr, nc));
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		for (Point p : list) {
			board[p.r][p.c] = cnt;
		}
		big = Math.max(cnt, big);

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
