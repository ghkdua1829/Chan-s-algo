package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_1644_소수의연속합 {
	static boolean prime[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> sosu = new ArrayList<>();
//
//		if (N == 1) {
//			System.out.println(1);
//			return;
//		}
//		for (int i = 2; i <= N; i++) {
//			boolean token = false;
//			for (int j = 2; j * j <= i; j++) {
//				if (i % j == 0) {
//					token = true;
//					break;
//				}
//			}
//			if (!token) {
//				sosu.add(i);
////				System.out.println(i);
//			}
//		}
		prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i])
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
		}
		for (int i = 1; i <= N; i++) {
			if (!prime[i])
				sosu.add(i);
		}
		int start = 0;
		int end = 0;
		int cnt = 0;
		int sum = 0;
		while (true) {
			if (end == sosu.size()) {
				if (sum < N) {
					break;
				} else if (sum > N) {
					sum -= sosu.get(start++);
				} else {
					cnt++;
					break;
				}
			} else {
				if (sum < N) {
					sum += sosu.get(end++);
				} else if (sum > N) {
					sum -= sosu.get(start++);
				} else {
					cnt++;
					sum -= sosu.get(start++);
					sum += sosu.get(end++);
				}
			}
		}
		System.out.println(cnt);
	}

}
