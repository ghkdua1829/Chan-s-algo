package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_10808_알파벳개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		List<Point> list = new ArrayList<>();
		for (int i = 'a'; i <= 'z'; i++) {
			list.add(new Point(0, (char) i));
		}
		for(int i=0;i<str.length();i++) {
			char c= str.charAt(i);
			for(int j=0;j<list.size();j++) {
				if(c==list.get(j).alpha) {
					list.get(j).count++;
				}
			}
		}
		for(int j=0;j<list.size();j++) {
				System.out.print(list.get(j).count+" ");
		}

	}

	private static class Point {
		int count;
		char alpha;

		public Point(int count, char alpha) {
			super();
			this.count = count;
			this.alpha = alpha;
		}

	}

}
