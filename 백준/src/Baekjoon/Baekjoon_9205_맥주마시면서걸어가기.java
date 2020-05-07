package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_9205_맥주마시면서걸어가기 {
	static List<Point> stores;
	static int startX, startY, endX, endY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			stores = new ArrayList<>();
			int storeNum = sc.nextInt();
			startX = sc.nextInt();
			startY = sc.nextInt();
			stores.add(new Point(startX, startY));
			for (int i = 0; i < storeNum; i++) {
				int storeX = sc.nextInt();
				int storeY = sc.nextInt();
				stores.add(new Point(storeX, storeY));
			}
			endX = sc.nextInt();
			endY = sc.nextInt();
			stores.add(new Point(endX, endY));
			bfsQueue(new Point(stores.get(0).x, stores.get(0).y));
			boolean token=false;
			for(int i=0;i<stores.size();i++) {
				if(stores.get(i).x==endX && stores.get(i).y==endY) {
					System.out.println("sad");
					token = true;
					break;
				}
			}
			if(!token) {
				System.out.println("happy");
			}
			
		}
	}

	public static void bfsQueue(Point start) {
		stores.remove(0);
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Point top = queue.poll();
			for (int i = 0; i < stores.size(); i++) {
				if (Math.abs(top.x - stores.get(i).x) + Math.abs(top.y - stores.get(i).y) <= 1000) {
					queue.offer(new Point(stores.get(i).x, stores.get(i).y));
					stores.remove(i);
					i--;
				}
			}
		}
	}
	
	static class Point {
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
