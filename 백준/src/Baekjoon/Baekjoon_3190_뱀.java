package Baekjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_3190_뱀 {
	static int size;
	static int[][] board;
	static int time=0;
	static int[] dirR = { 0, 1, 0, -1 };
	static int[] dirC = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		board = new int[size+2][size+2];
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board.length;c++) {
				if(r==0 || r==size+1 || c==0 || c==size+1) {
					board[r][c] = 1;
				}
			}
		}
//		for (int[] a : board) {
//			System.out.println(Arrays.toString(a));
//		}
		int appleNum = sc.nextInt();
		for (int i = 0; i < appleNum; i++) {
			int appleR = sc.nextInt();
			int appleC = sc.nextInt();
			board[appleR][appleC] = 2;
		}
		int dirNum = sc.nextInt();
		HashMap<Integer, Character> dirMap = new HashMap();

		for (int i = 0; i < dirNum; i++) {
			int dirTime = sc.nextInt();
			char dirWay = sc.next().charAt(0);
			dirMap.put(dirTime, dirWay);
		}
		snake snake = new snake(1, 1, 0);
		int headR = snake.r;
		int headC = snake.c;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(1, 1));
		board[1][1] = 1;
		outer: while (true) {

			int nr = headR + dirR[snake.dir];
			int nc = headC + dirC[snake.dir];
			if (isIn(nr, nc) && board[nr][nc] != 1) {
				if (board[nr][nc] == 2) {

				} else {
					Point temp = queue.poll();
					board[temp.r][temp.c] = 0;
				}
				queue.offer(new Point(nr, nc));
				board[nr][nc] = 1;
				headR += dirR[snake.dir];
				headC += dirC[snake.dir];
				time++;
			} else {
				System.out.println(++time);
				break outer;
			}

			Character a = dirMap.get(time);
			if (a != null) {
				if (a == 'D') {
					snake.dir = (snake.dir + 1) % 4;
				} else if (a == 'L') {
					if (snake.dir == 0) {
						snake.dir = 3;
					} else {
						snake.dir--;
					}
				}
			}
		}
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

	static class snake {
		@Override
		public String toString() {
			return "snake [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

		int r, c;
		int dir;

		public snake(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < size+2 && c < size+2;
	}

}
