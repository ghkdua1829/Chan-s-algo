package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2174_로봇시뮬레이션 {
	static int xSize, ySize;
	static Point[][] board;
	static char[] dirs = { 'E', 'N', 'W', 'S' };
	static Dir[] moves = { new Dir(1, 0), new Dir(0, -1), new Dir(-1, 0), new Dir(0, 1) };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		xSize = sc.nextInt();
		ySize = sc.nextInt();
		board = new Point[ySize][xSize];
		int robotCount = sc.nextInt();
		int orderNum = sc.nextInt();
		for (int i = 1; i <= robotCount; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			char dir = sc.next().charAt(0);
			board[ySize - y][x - 1] = new Point(i, dir);
		}
//		for (Point[] a : board) {
//			System.out.println(Arrays.toString(a));
//		}
		for (int i = 0; i < orderNum; i++) {
			int robotNum = sc.nextInt();
			char dir = sc.next().charAt(0);
			int dirNum = sc.nextInt();
			int tempX = -1, tempY = -1;
			char tempDir = 'Z';
			outer: for (int y = 0; y < ySize; y++) {
				for (int x = 0; x < xSize; x++) {
					try {
						if (board[y][x].robotNum == robotNum) {
							tempX = x;
							tempY = y;
							tempDir = board[y][x].dir;
							break outer;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
			int index = -1;
			for (int d = 0; d < dirs.length; d++) {
				if (tempDir == dirs[d]) {
					index = d;
				}
			}
			switch (dir) {
			case 'F':
				board[tempY][tempX] = null;
				for (int f = 0; f < dirNum; f++) {
					tempX += moves[index].x;
					tempY += moves[index].y;
					if (!isIn(tempX, tempY)) {
						System.out.printf("Robot %d crashes into the wall", robotNum);
						return;
					}
					if (board[tempY][tempX] != null) {
						System.out.printf("Robot %d crashes into robot %d", robotNum, board[tempY][tempX].robotNum);
						return;
					}
				}
				board[tempY][tempX] = new Point(robotNum,tempDir);
//				for (Point[] a : board) {
//					System.out.println(Arrays.toString(a));
//				}
				break;
			case 'R':
				for (int r = 0; r < dirNum; r++) {
					index--;
					if (index == -1) {
						index = 3;
					}
				}
				board[tempY][tempX].dir = dirs[index];
				break;
			case 'L':
				for (int l = 0; l < dirNum; l++) {
					index++;
					if (index == 4) {
						index = 0;
					}
				}
				board[tempY][tempX].dir = dirs[index];
				break;
			}
		}
		System.out.println("OK");
	}

	public static boolean isIn(int x, int y) {
		return x < xSize && y < ySize && x >= 0 && y >= 0;
	}

	static class Dir {
		@Override
		public String toString() {
			return "Dir [x=" + x + ", y=" + y + "]";
		}

		int x, y;

		public Dir(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Point {

		int robotNum;
		char dir;

		@Override
		public String toString() {
			return "Point [robotNum=" + robotNum + ", dir=" + dir + "]";
		}

		public Point(int robotNum, char dir) {
			super();
			this.robotNum = robotNum;
			this.dir = dir;
		}

	}
}
