package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_19237_어른상어 {
//	static Shark[][] board;
	static List<Shark> sharkList = new ArrayList<>();
	static int[][] search = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Smell[][] smellBoard;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

//		board = new Shark[N][N];
		smellBoard = new Smell[N][N];

		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int sharkNum = Integer.parseInt(token.nextToken());
				if (sharkNum != 0) {
					sharkList.add(new Shark(r, c, -1, sharkNum, new int[5][4]));
//					smellBoard[r][c] = new Smell(board[r][c], K);
				}
			}
		}
		sharkList.sort(new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				return o1.num - o2.num;
			}
		});

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sharkList.get(i).dir = Integer.parseInt(token.nextToken());
//			board[shark.r][shark.c] = shark;
		}

		int n = 0;
		while (n < sharkList.size()) {
			int[][] arr = new int[4][4];
			for (int i = 0; i < 4; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
				}

			}
			for (int r = 1; r < 5; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					sharkList.get(n).priority[r][c] = arr[r - 1][c];
				}
			}
			n++;
		}

//		for (Shark s : sharkList) {
//			System.out.println(s);
//		}
//		for (Smell[] s : smellBoard) {
//			System.out.println(Arrays.toString(s));
//		}

		int num = sharkList.size();
		int time = 0;
		while (num != 1) {
			time++;
			List<Shark> tempSharkList = new ArrayList<>();

			// 1. 자신의 자리에 냄새를 뿌린다.

			for (int i = 0; i < sharkList.size(); i++) {
				Shark shark = sharkList.get(i);
				smellBoard[shark.r][shark.c] = new Smell(shark.num, K);
			}

			// 2. 상어를 이동시킨다.

			// 2-1. 상어들이 아무런 냄새가 없는 곳을 찾는다.

//			System.out.println("____________");
//			for(Smell[] s : smellBoard) {
//				System.out.println(Arrays.toString(s));
//			}
			for (int i = 0; i < sharkList.size(); i++) {
				boolean outToken = false;
				Shark shark = sharkList.get(i);

				int[] sharkSearch = shark.priority[shark.dir];
//				System.out.println(Arrays.toString(sharkSearch));
//				System.out.println(shark);
				for (int s : sharkSearch) {
					int nr = shark.r + search[s][0];
					int nc = shark.c + search[s][1];
					if (isIn(nr, nc) && smellBoard[nr][nc] == null) {
						tempSharkList.add(new Shark(nr, nc, s, shark.num, shark.priority));
						outToken = true;
						break;
					}
				}
				if (outToken) { // 아무런 냄새가 없는곳을 찾아서 이동성공
					continue;
				}

				// 냄새가 없는 곳을 못찾았다면 자신의 냄새가 있는 곳을간다.

				for (int s : sharkSearch) {
					int nr = shark.r + search[s][0];
					int nc = shark.c + search[s][1];
					if (isIn(nr, nc) && smellBoard[nr][nc].sharkNum == shark.num) {
						tempSharkList.add(new Shark(nr, nc, s, shark.num, shark.priority));
						outToken = true;
						break;
					}
				}
				if (outToken) {
					continue;
				} else {
					tempSharkList.add(shark);
				}

			}
//			System.out.println("Asds"+tempSharkList);

			tempSharkList.sort(new Comparator<Shark>() {

				@Override
				public int compare(Shark o1, Shark o2) {
					return o1.num - o2.num;
				}
			});
//			System.out.println(tempSharkList);
			Shark[][] tempBoard = new Shark[N][N];
			sharkList.clear();

			for (Shark s : tempSharkList) {
				if (tempBoard[s.r][s.c] == null) {
					tempBoard[s.r][s.c] = s;
					sharkList.add(s);
				}
			}

			// 3. 냄새지속시간 1을 줄인다.

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (smellBoard[r][c] != null) {
						smellBoard[r][c].time--;
						if (smellBoard[r][c].time == 0) {
							smellBoard[r][c] = null;
						}
					}
				}
			}

			num = sharkList.size();
		}
		System.out.println(time);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Shark {
		int r, c, dir, num;
		int[][] priority;

		public Shark(int r, int c, int dir, int num, int[][] priority) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.num = num;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", dir=" + dir + ", num=" + num + ", priority="
					+ Arrays.deepToString(priority) + "]";
		}

	}

	static class Smell {
		int sharkNum, time;

		public Smell(int sharkNum, int time) {
			super();
			this.sharkNum = sharkNum;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Smell [sharkNum=" + sharkNum + ", time=" + time + "]";
		}

	}

}
