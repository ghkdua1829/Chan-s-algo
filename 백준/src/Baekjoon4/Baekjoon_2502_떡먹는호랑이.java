package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2502_떡먹는호랑이 {
	static Point[] arr = new Point[30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < 30; i++) {
			arr[i] = new Point(-1, -1);
		}
		int D = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		Point result = pibo(D - 1);
		for(int a=0;;a++) {
			int tempA = result.A*a;
			int tempSum = K-tempA;
			if(tempSum%result.B==0) {
				System.out.println(a);
				System.out.println(tempSum/result.B);
				return;
			}
		}
	}

	static Point pibo(int d) {
		if (arr[d].A != -1 && arr[d].B != -1) {
			return arr[d];
		}
		if (d == 0) {
			return new Point(1, 0);
		} else if (d == 1) {
			return new Point(0, 1);
		}
		return arr[d] = new Point(pibo(d - 1).A + pibo(d - 2).A, pibo(d - 1).B + pibo(d - 2).B);
	}

	static class Point {
		int A, B;

		public Point(int a, int b) {
			super();
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Point [A=" + A + ", B=" + B + "]";
		}

	}

}
