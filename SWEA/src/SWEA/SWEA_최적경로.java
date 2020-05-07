package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_최적경로 {
	static int  companyX, companyY, houseX, houseY;
	static int N;
	static int minDistance = Integer.MAX_VALUE;
	static List<Point> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			minDistance =Integer.MAX_VALUE;
			list = new ArrayList<SWEA_최적경로.Point>();
			N = sc.nextInt();
			companyX = sc.nextInt();
			companyY = sc.nextInt();
			houseX = sc.nextInt();
			houseY = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list.add(new Point(x, y));
			}
			makePermutation(N, new boolean[N], 0, new Point[N]);

			System.out.println("#" + tc + " " + minDistance);
		}
	}

	public static void makePermutation(int r, boolean[] visited, int current, Point[] temp) {
		if (r == current) {
			int beforeX = companyX;
			int beforeY = companyY;
			int tempResult = 0;
			for (int i = 0; i < temp.length; i++) {
				int distanceX = Math.abs(temp[i].x - beforeX);
				int distanceY = Math.abs(temp[i].y - beforeY);
				tempResult+=distanceX+distanceY;
				beforeX = temp[i].x;
				beforeY = temp[i].y;
			}
			tempResult+= Math.abs(houseX - beforeX)+Math.abs(houseY-beforeY);
			if(tempResult<minDistance) {
				minDistance = tempResult;
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = list.get(i);
					makePermutation(r, visited, current + 1, temp);
					visited[i] = false;
				}
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

}
