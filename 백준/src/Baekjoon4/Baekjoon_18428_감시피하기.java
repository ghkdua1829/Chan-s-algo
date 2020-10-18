package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_18428_감시피하기 {

	static List<Point> wallList = new ArrayList<>();
	static List<Point> teacherList = new ArrayList<>();
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[][] board;
	static boolean studentSave = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int r = 0; r < N; r++) {
			String[] arr = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = arr[c].charAt(0);
				if (board[r][c] == 'X') {
					wallList.add(new Point(r, c));
				}
				if (board[r][c] == 'T') {
					teacherList.add(new Point(r, c));
				}
			}
		}

//		for (char[] c : board) {
//			System.out.println(Arrays.toString(c));
//		}

		makeCombination(3, new Point[3], 0, 0);
		
//		System.out.println(studentSave);
		if(studentSave) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	static void makeCombination(int r, Point[] temp, int current, int start) {
		if(studentSave) {
			return;
		}
		if (r == current) {
			boolean tempStudentSave = true;
//			System.out.println(Arrays.toString(temp));
			for (int i = 0; i < temp.length; i++) {
				Point wall = temp[i];
				board[wall.r][wall.c] = 'O';
			}

			for (int t = 0; t < teacherList.size(); t++) {
				for (int s = 0; s < search.length; s++) {
					Point teacher = teacherList.get(t);
					int teacherR = teacher.r;
					int teacherC = teacher.c;
					while (true) {
						teacherR = teacherR + search[s][0];
						teacherC = teacherC + search[s][1];
						if (isIn(teacherR, teacherC)) {
							if (board[teacherR][teacherC] == 'O') {
								break;
							} else if (board[teacherR][teacherC] == 'S') {
								tempStudentSave = false;
								break;
							}
						}else {
							break;
						}
					}
				}

			}
			
			if(tempStudentSave) {
				studentSave = tempStudentSave;
			}else {
			}

			for (int i = 0; i < temp.length; i++) {
				Point wall = temp[i];
				board[wall.r][wall.c] = 'X';
			}
		} else {
			for (int i = start; i < wallList.size(); i++) {
				temp[current] = wallList.get(i);
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}
}
