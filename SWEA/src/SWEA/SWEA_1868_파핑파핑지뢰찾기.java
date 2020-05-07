package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int size;
	static int[][] search = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static char[][] arr;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			result = 0; // 횟수 초기화
			size = Integer.parseInt(br.readLine()); // 사이즈 할당
			arr = new char[size][size]; // 배열 만들기
			// 배열 집어넣기
			for (int r = 0; r < size; r++) {
				String str = br.readLine();
				for (int c = 0; c < size; c++) {
					arr[r][c] = str.charAt(c);

				}
			}
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (arr[r][c] == '.') {
						boolean token = false;
						for (int s = 0; s < search.length; s++) {
							int nr = r + search[s][0];
							int nc = c + search[s][1];
							if (isIn(nr, nc) && arr[nr][nc] == '*') {
								token = true;
								break;
							}
						}
						if (!token) {
							arr[r][c] = '0';
						}
					}
				}
			}
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (arr[r][c] == '0') {
						bfsQueue(new Point(r, c));
					}
				}
			}

			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (arr[r][c] == '.') {
						result++;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	static void bfsQueue(Point start) {
		result++;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (arr[top.r][top.c] != '0') {
				arr[top.r][top.c] = '1';
				continue;
			}
			arr[top.r][top.c] = '1';

			for (int s = 0; s < search.length; s++) {
				int nr = top.r + search[s][0];
				int nc = top.c + search[s][1];
				if (isIn(nr, nc) && arr[nr][nc] != '*') {
					queue.offer(new Point(nr, nc));
				}
			}
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
