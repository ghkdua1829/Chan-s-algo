package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2583_영역구하기 {
	static boolean[][] board;
	static int[] searchX = { 0, 0, 1, -1 };
	static int[] searchY = { -1, 1, 0, 0 };
	static int ySize, xSize,result;
	static List<Integer> areas = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ySize = sc.nextInt();
		xSize = sc.nextInt();
		int rectNum = sc.nextInt();
		board = new boolean[ySize][xSize];

		for (int i = 0; i < rectNum; i++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			for (int x = startX; x < endX; x++) {
				for (int y = startY; y <endY; y++) {
					board[y][x] = true;
				}
			}
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(!board[i][j]) {
					bfsQueue(new Point(j,i));
				}
			}
		}
		System.out.println(result);
		Collections.sort(areas);
		for(int i=0;i<areas.size();i++) {
			System.out.print(areas.get(i)+" ");
		}
	}

	private static void bfsQueue(Point p) {
		result++;
		int area = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			if (board[top.y][top.x]) {
				continue;
			}
			area++;
			board[top.y][top.x] = true;
			for (int i = 0; i < searchX.length; i++) {
				int nx = top.x + searchX[i];
				int ny = top.y + searchY[i];
				if(isIn(ny,nx) && !board[ny][nx]) {
					queue.offer(new Point(nx,ny));
				}
			}

		}
		areas.add(area);
	}

	public static boolean isIn(int y, int x) {
		return x >= 0 && y >= 0 && x < xSize && y < ySize;
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
