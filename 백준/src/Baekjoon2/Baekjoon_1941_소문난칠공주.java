package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1941_소문난칠공주 {
	static char[][] arr = new char[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int r = 0; r < 5; r++) {
			String str = br.readLine();
			for (int c = 0; c < 5; c++) {
				arr[r][c] = str.charAt(c);
			}
		}

	}

	static void makeCombination(int r, Point[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {

		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	@Override
	public String toString() {
		return "Baekjoon_1941_소문난칠공주 []";
	}
}
