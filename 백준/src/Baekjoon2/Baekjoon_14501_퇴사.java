package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14501_퇴사 {
	static int N, max;
	static Sangdam[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Sangdam[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			arr[i] = new Sangdam(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int start, int sum) {
		if (start >= N) {
			max = Math.max(max, sum);
			return;
		} else if (start + arr[start].T > N) {
		} else {
			dfs(start + arr[start].T, sum + arr[start].P);

		}

		dfs(start + 1, sum);
	}

	static class Sangdam {
		int T, P;

		public Sangdam(int t, int p) {
			super();
			T = t;
			P = p;
		}

		@Override
		public String toString() {
			return "Sangdam [T=" + T + ", P=" + P + "]";
		}

	}
}
