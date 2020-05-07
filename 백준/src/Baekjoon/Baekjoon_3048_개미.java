package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_3048_개미 {
	static char[] g1, g2, g;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		String G1 = sc.next();
		String G2 = sc.next();
		int N = N1 + N2;
		g = new char[N];
		int[] dir = new int[N1 + N2];
		for (int i = N1 - 1; i >= 0; i--) {
			g[i] = G1.charAt(N1 - 1 - i);
		}
		for (int i = N1; i < N; i++) {
			g[i] = G2.charAt(i - N1);
		}
		for (int i = 0; i < N1; i++) {
			dir[i] = 1; // 0이 왼쪽, 1이 오른쪽
		}
		Point[] p = new Point[N];
		for(int i=0;i<N;i++) {
			p[i]= new Point(g[i],dir[i]);
		}
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < p.length - 1; j++) {
				if (p[j].dir == 1 && p[j + 1].dir == 0) {
					list.add(j);
				}
			}
			for (int l = 0; l < list.size(); l++) {
				int s = list.get(l);
				Point temp = p[s];
				p[s] = p[s+1];
				p[s+1]=temp;
			}
			
		}
		for(int i=0;i<p.length;i++) {
			System.out.print(p[i].c);
		}

	}

	static class Point {
		char c;
		int dir;

		public Point(char c, int dir) {
			this.c = c;
			this.dir = dir;
		}

	}
}
