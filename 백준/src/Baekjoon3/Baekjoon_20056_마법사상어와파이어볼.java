package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_20056_마법사상어와파이어볼 {
	static int[][] search = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		Queue<Ball> queue = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			int m = Integer.parseInt(token.nextToken());
			int s = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			Ball ball = new Ball(r - 1, c - 1, m, s, d);
			queue.offer(ball);
		}

		// 명령 반복
		int tempM = 0;

		for (int k = 0; k < K; k++) {
			tempM = 0;

			List<Ball>[][] cntBall = new List[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cntBall[r][c] = new ArrayList<>();
				}
			}

			// 1 단계 : 모든 파이어볼 이동
			while (!queue.isEmpty()) {
				Ball top = queue.poll();
				int nr = top.r + top.s * search[top.d][0];
				int nc = top.c + top.s * search[top.d][1];
				cntBall[(nr + N) % N][(nc + N) % N].add(new Ball((nr + N) % N, (nc + N) % N, top.m, top.s, top.d));
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (cntBall[r][c].size() > 1) {
						int averageM = 0;
						int averageS = 0;
						boolean directionOdd = false;
						boolean directionEven = false;
						for (int i = 0; i < cntBall[r][c].size(); i++) {
							if (cntBall[r][c].get(i).d % 2 == 0) {
								directionEven = true;
							} else {
								directionOdd = true;
							}
							averageM += cntBall[r][c].get(i).m;
							averageS += cntBall[r][c].get(i).s;
						}
						averageM = (int) Math.floor(averageM / 5);
						averageS = (int) Math.floor(averageS / cntBall[r][c].size());
						if (averageM > 0) {
							tempM += averageM * 4;

							if (directionEven && directionOdd) {
								queue.offer(new Ball(r, c, averageM, averageS, 1));
								queue.offer(new Ball(r, c, averageM, averageS, 3));
								queue.offer(new Ball(r, c, averageM, averageS, 5));
								queue.offer(new Ball(r, c, averageM, averageS, 7));
							} else {
								queue.offer(new Ball(r, c, averageM, averageS, 0));
								queue.offer(new Ball(r, c, averageM, averageS, 2));
								queue.offer(new Ball(r, c, averageM, averageS, 4));
								queue.offer(new Ball(r, c, averageM, averageS, 6));
							}
						}
					} else if (cntBall[r][c].size() == 1) {
						Ball b = cntBall[r][c].get(0);
						tempM += b.m;
						queue.offer(new Ball(r, c, b.m, b.s, b.d));
					}
				}
			}

		}
		System.out.println(tempM);
	}

	static class Ball {
		int r, c, m, s, d;

		public Ball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ball [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}

	}

}
