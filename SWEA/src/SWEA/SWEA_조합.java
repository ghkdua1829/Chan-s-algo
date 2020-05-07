package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_조합 {

	public static void main(String[] args) throws IOException {
		long mods = 1234567891;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			long[] fact = new long[N + 1];
			fact[0] = 1;	//0!
			fact[1] = 1;	//1!
			for (int i = 2; i <= N; i++) {
				fact[i] = fact[i - 1] * i % mods;
			}
			long bunmo = fact[M] * fact[N - M] % mods;
			long n = mods - 2;
			long num = 1;
			//재귀로 거듭제곱 구하기.(분모의 mods -2 제곱)
			while (n > 0) {
				// n이 홀수 일 때만 분모값을 곱해준다.
				if (n % 2 == 1) {
					num *= bunmo;
					num %= mods;
				}
				//
				bunmo = (bunmo * bunmo) % mods;
				n /= 2;
			}
			long result = ((fact[N] % mods) * (num % mods)) % mods;
			System.out.println("#" + t + " " + result);
		}
	}

}
