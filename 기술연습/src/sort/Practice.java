package sort;

import java.util.*;

public class Practice {

	public static void main(String[] args) {
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		// TODO Auto-generated method stub
		solution(4, 5, board);
	}

	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int rSize, cSize;
	static char[][] arr;

	static public int solution(int m, int n, String[] board) {
		rSize = m;
		cSize = n;
		int answer = 0;

		arr = new char[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				arr[r][c] = board[r].charAt(c);
			}
		}
		for (char[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		while (true) {
			boolean boomOk = false;
			Set<Point> set = new HashSet<>();
			for (int r = 0; r < rSize - 1; r++) {
				for (int c = 0; c < cSize - 1; c++) {
					int num = arr[r][c];
					if (num == arr[r + 1][c] && num == arr[r][c + 1] && num == arr[r + 1][c + 1]) {
						boomOk = true;
						set.add(new Point(r, c));
						set.add(new Point(r + 1, c));
						set.add(new Point(r, c + 1));
						set.add(new Point(r + 1, c + 1));
					}
				}
			}
			if (!boomOk) {
				break;
			}
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Point next = (Point) it.next();
				arr[next.r][next.c] = '-';
				answer++;
			}

			// 내리기
			for (int c = 0; c < cSize; c++) {
				List<Character> list = new ArrayList<>();
				for (int r = rSize - 1; r >= 0; r--) {
					if (arr[r][c] != '-') {
						list.add(arr[r][c]);
					}
					arr[r][c] = '-';
				}
				int rr = rSize - 1;
				for (int l = 0; l < list.size(); l++) {
					arr[rr--][c] = list.get(l);
				}
			}
		}
		return answer;
	}

	static class Point {
		int r, c;
		

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < rSize && c < cSize;
	}
}
