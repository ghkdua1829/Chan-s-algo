package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1003_피보나치함수 {
	static Count[] fibo = new Count[41];
	static boolean[] cache = new boolean[41];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fibo[0] = new Count(1, 0);
		fibo[1] = new Count(0, 1);
		cache[0] = true;
		cache[1] = true;

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Count cnt = fibo(N);
			System.out.println(cnt.zeroCnt + " " + cnt.oneCnt);

		}
	}

	static Count fibo(int N) {
		if(N==0) {
			return fibo[0];
		}else if(N==1) {
			return fibo[1];
		}else if(fibo[N]!=null) {
			return fibo[N];
		}
		return fibo[N] = new Count(fibo(N - 1).zeroCnt + fibo(N - 2).zeroCnt, fibo(N - 1).oneCnt + fibo(N - 2).oneCnt);
	}

	static class Count {
		int zeroCnt, oneCnt;

		public Count(int zeroCnt, int oneCnt) {
			super();
			this.zeroCnt = zeroCnt;
			this.oneCnt = oneCnt;
		}

		@Override
		public String toString() {
			return "Count [zeroCnt=" + zeroCnt + ", oneCnt=" + oneCnt + "]";
		}

	}
}
