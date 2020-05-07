package SWEA;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1861_정사각형방 {
	static int[] searchR = { -1, 0, 0, 1 };
	static int[] searchC = { 0, -1, 1, 0 };
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			size = sc.nextInt();
			int[][] arr = new int[size][size];
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int result = 1;
			int dap = 0;
			int min = Integer.MAX_VALUE;
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					result = 1;

					Stack<Point> stack = new Stack<>();

					stack.push(new Point(r, c));
					while (!stack.isEmpty()) {
						Point top = stack.pop();
						for (int s = 0; s < searchC.length; s++) {
							int nr = top.r + searchR[s];
							int nc = top.c + searchC[s];
							if (isIn(nr, nc) && arr[nr][nc] == arr[top.r][top.c] + 1) {
								stack.push(new Point(nr, nc));
								++result;
								break;
							}
						}
					}
					if (result > dap) {
						dap = result;
						min = arr[r][c];

					} else if (result == dap) {
						if (min > arr[r][c]) {
							min = arr[r][c];
						} else {

						}
					}
					if (arr[r][c] < min && result >= dap) {
						dap = result;
						min = arr[r][c];
					}
				}
			}
			System.out.println("#" + tc + " " + min + " " + dap);
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}

	
}
