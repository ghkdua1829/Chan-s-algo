package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1267_핸드폰요금 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int M = 0;
		int Y = 0;
		for (int i = 0; i < N; i++) {
			int time = Integer.parseInt(token.nextToken());
			Y += time / 30 * 10 + 10;
			M += time / 60 * 15 + 15;
		}
		if (Y < M) {
			System.out.println("Y " + Y);
		} else if (Y > M) {
			System.out.println("M " + M);
		} else {
			System.out.println("Y M " + Y);
		}

	}

}
