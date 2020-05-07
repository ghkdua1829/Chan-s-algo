package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16236_아기상어 {
	static int N, sharkSize, time, eatCount;
	static int[][] arr;
	static Point shark;
	static boolean token;
	static int[][] search = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int oneR = -1, oneC = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sharkSize = 2;
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				if (arr[r][c] == 9) {
					shark = new Point(r, c);
				}
			}
		}

		while (true) {
			int eatFish = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 9) {
						shark.r = r;
						shark.c = c;
					}
					if (arr[r][c] <= 6 && arr[r][c] > 0) {
						if (sharkSize > arr[r][c]) {
							eatFish++;
						}
					}

				}
			}
			if (eatFish >= 1) {
				bfsQueue(shark.r, shark.c);
				if (token) {
					System.out.println(time);
					return;
				}
			} else {
				System.out.println(time);
				return;
			}
		}

	}

	static void bfsQueue(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(new Point(r, c));
		int tempTime = -1;
		int resultR = 21, resultC = 21;
		boolean tt = false;
		while (!queue.isEmpty()) {
			int s = queue.size();
			tempTime++;
			for (int i = 0; i < s; i++) {
				Point top = queue.poll();
				if (visited[top.r][top.c]) {
					continue;
				}
				if (arr[top.r][top.c] > 0 && arr[top.r][top.c] < sharkSize && arr[top.r][top.c] != 9) {
					tt =true;
					if (top.r < resultR) {
						resultR = top.r;
						resultC = top.c;
					} else if (top.r == resultR) {
						if (top.c < resultC) {
							resultR = top.r;
							resultC = top.c;
						}
					}
				}
				visited[top.r][top.c] = true;
				for (int a = 0; a < search.length; a++) {
					int nr = top.r + search[a][0];
					int nc = top.c + search[a][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						if (sharkSize >= arr[nr][nc]) {
							queue.offer(new Point(nr, nc));
						}
					}
				}
			}
			if(tt) {
				eatCount++;
				if (sharkSize == eatCount) {
					sharkSize++;
					eatCount = 0;
				}
				arr[r][c] = 0;
				arr[resultR][resultC] = 9;
				time += tempTime;
				return;
			}
		}
		token = true;
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Shark {
		@Override
		public String toString() {
			return "shark [r=" + r + ", c=" + c + ", size=" + size + "]";
		}

		int r, c, size;

		public Shark(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}

	}

}
