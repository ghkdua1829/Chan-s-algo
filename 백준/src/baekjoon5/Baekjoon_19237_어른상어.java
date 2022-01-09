package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_19237_어른상어 {
	static int[][] search = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Board[][] board;
	static Shark[] sharks;
	static int N, M, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		board = new Board[N][N];
		sharks = new Shark[M + 1];
		sharks[0] = new Shark(0, 0, 0);
		int z = 1;
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(token.nextToken());
				if (num != 0) {
					sharks[z++] = new Shark(r, c, num);
					board[r][c] = new Board(num, k);
				} else {
					board[r][c] = null;
				}
			}
		}

		Arrays.sort(sharks);

		token = new StringTokenizer(br.readLine());

		for (int i = 1; i < M + 1; i++) {
			Shark shark = sharks[i];
			shark.dir = Integer.parseInt(token.nextToken());
		}
		for (int t = 1; t < M + 1; t++) {
			Shark shark = sharks[t];
			for (int i = 1; i < 5; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					shark.dirs[i][j] = Integer.parseInt(token.nextToken());
				}
			}
		}

		int t = 0;
		while (t < 1000) {
			t++;
			// 냄새 1씩 줄이기.
			minusSmell();

			// 상어들이 이동을 한다.
			moveSharks();

			// 냄새 0 인거 없애기.
			deleteSmell();

			int cnt = 0;
			for (int i = 1; i < sharks.length; i++) {
				Shark s = sharks[i];
				if (s.num != 0) {
					cnt++;
				}
			}

			if (cnt == 1) {
				System.out.println(t);
				return;
			}
//			System.out.println(sharks.size());
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					if (board[r][c] != null && board[r][c].time == k) {
//						System.out.print(board[r][c].num);
//					} else {
//						System.out.print(0);
//					}
//				}
//				System.out.println();
//			}
		}
		System.out.println(-1);
		return;
	}

	static void minusSmell() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != null)
					board[r][c].time--;
			}
		}

	}

	static void moveSharks() {
		Board[][] arr = new Board[N][N];
		for (int s = sharks.length - 1; s >= 1; s--) {
			if (sharks[s].num == 0) {
				continue;
			}
			Shark shark = sharks[s];
			int[] d = shark.dirs[shark.dir];
			boolean p1 = false;
			for (int i = 0; i < d.length; i++) {
				int dNum = d[i];
				int nr = shark.r + search[dNum][0];
				int nc = shark.c + search[dNum][1];
				if (isIn(nr, nc)) {
					if (board[nr][nc] == null) { // 갈곳이 비엇을떄
//						board[nr][nc] = new Board(shark.num, k);
						arr[nr][nc] = new Board(shark.num, k);
						shark.r = nr;
						shark.c = nc;
						shark.dir = dNum;
						p1 = true;
						break;
					}

				}
			}

			if (p1) {
				continue;
			}
			for (int i = 0; i < d.length; i++) {
				int dNum = d[i];
				int nr = shark.r + search[dNum][0];
				int nc = shark.c + search[dNum][1];
				if (isIn(nr, nc) && board[nr][nc] != null && board[nr][nc].num == shark.num) {
					board[nr][nc] = new Board(shark.num, k);
//					list.add(new Shark(nr, nc, shark.num));
					shark.r = nr;
					shark.c = nc;
					shark.dir = dNum;
					break;
				}
			}
		}
		
		for(int i=1;i<sharks.length;i++) {
			sharks[i].num = 0;
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(arr[r][c] !=null) {
					sharks[arr[r][c].num].num = arr[r][c].num;
				}
			}
		}

	}

	static void deleteSmell() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != null && board[r][c].time == 0) {
					board[r][c] = null;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Board {
		int num, time;

		public Board(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Board [num=" + num + ", time=" + time + "]";
		}

	}

	static class Shark implements Comparable<Shark> {

		int r, c, num, dir;
		int[][] dirs = new int[5][4];

		public Shark(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Shark o) {
			return Integer.compare(this.num, o.num);
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", num=" + num + ", dir=" + dir + ", dirs="
					+ Arrays.deepToString(dirs) + "]";
		}

	}
}
