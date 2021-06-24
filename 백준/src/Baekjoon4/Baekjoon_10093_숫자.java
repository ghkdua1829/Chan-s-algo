package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10093_숫자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		long A = Long.parseLong(token.nextToken());
		long B = Long.parseLong(token.nextToken());

		if (A > B) {
			long num = B;
			B = A;
			A = num;
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (long i = A + 1; i < B; i++) {
			cnt++;
			sb.append(i + " ");
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}
