package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice {
	static int[][] search = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int TC, N, M, start_i, start_j, next_i, next_j, time, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start_i = Integer.parseInt(st.nextToken());
			start_j = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 1;
			bfs(new Point(start_i, start_j, time - 1));
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(Point before) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(before);
		visited = new boolean[N][M];
		visited[before.i][before.j] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int cap = map[tmp.i][tmp.j];

			if (cap == 1) {
				for (int k = 0; k < 4; k++) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 2) {
				for (int k = 1; k < 4; k += 2) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 3) {
				for (int k = 0; k < 4; k += 2) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 4) {
				for (int k = 0; k < 4; k += 3) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 5) {
				for (int k = 0; k < 2; k++) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 6) {
				for (int k = 1; k < 3; k++) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			} else if (cap == 7) {
				for (int k = 2; k < 4; k++) {
					next_i = tmp.i + search[k][0];
					next_j = tmp.j + search[k][1];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
						continue;

					if (k == 0 && (map[next_i][next_j] == 2 || map[next_i][next_j] == 4 || map[next_i][next_j] == 5))
						continue;
					else if (k == 1
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 5 || map[next_i][next_j] == 6))
						continue;
					else if (k == 2
							&& (map[next_i][next_j] == 2 || map[next_i][next_j] == 6 || map[next_i][next_j] == 7))
						continue;
					else if (k == 3
							&& (map[next_i][next_j] == 3 || map[next_i][next_j] == 4 || map[next_i][next_j] == 7))
						continue;

					if (!visited[next_i][next_j] && tmp.dist > 0 && map[next_i][next_j] != 0) {
						visited[next_i][next_j] = true;
						q.offer(new Point(next_i, next_j, tmp.dist - 1));
						ans++;
					}
				}
			}
		}
	}

	static class Point {
		int i, j, dist;

		public Point(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
}