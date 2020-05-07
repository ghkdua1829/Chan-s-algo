package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기 {
	static int N, W, H, result, min;
	static boolean token;
	static int[][] arr, tempArr;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			token = false;
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			arr = new int[H][W];
			tempArr = new int[H][W];
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					arr[r][c] = sc.nextInt();
					tempArr[r][c] = arr[r][c];
				}
			}
			makePermutation(N, new int[N], 0);
			System.out.println("#" + tc + " " + min);

		}
	}

	public static void makePermutation(int r, int[] temp, int current) {
		if (r == current) {
			if(token) {
				
			}else {
				bomb(temp);
			}

		} else {
			for (int i = 0; i < arr[0].length; i++) {
				temp[current] = i;
				makePermutation(r, temp, current + 1);
			}
		}
	}

	private static void bomb(int[] bombC) {
		for (int i = 0; i < bombC.length; i++) {
			int c = bombC[i];
			for (int r = 0; r < H; r++) {
				Queue<Point> queue = new LinkedList<>();
				boolean[][] visited = new boolean[H][W];
				if (arr[r][c] != 0) {
					queue.offer(new Point(r, c));
					while (!queue.isEmpty()) {
						Point top = queue.poll();
						int n = arr[top.r][top.c];
//						if (visited[top.r][top.c]) {
//							continue;
//						}
//						visited[top.r][top.c] = true;
						arr[top.r][top.c] = 0;

						for (int b = 1; b < n; b++) {
							for (int d = 0; d < dir.length; d++) {
								int nr = top.r + b * dir[d][0];
								int nc = top.c + b * dir[d][1];
								if (isIn(nr, nc) &&!visited[nr][nc]) {
									visited[nr][nc]=true;
									queue.offer(new Point(nr, nc));
								}
							}
						}
					}

					break;
				}
			}
			// 블록들 밑으로 모으기.
//			for (int[] a : arr) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			for (int w = 0; w < W; w++) {
				int r = H - 1;
				int nr = H - 1; // 0인 부분
				while (r >= 0) {
					if (arr[r][w] != 0) {
						if (arr[nr][w] == 0) {
							int temp = arr[r][w];
							arr[r][w] = arr[nr][w];
							arr[nr][w] = temp;
						}
						r--;
						nr--;
					} else {
						r--;
					}

				}
			}
		}
		result = 0;

		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (arr[r][c] != 0) {
					result++;
				}
				arr[r][c] =tempArr[r][c];
			}
		}

		if (result==0) {
			token = true;
			min = result;
			return;
		}
		if (result < min) {
			min = result;
		}
		
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}

}
