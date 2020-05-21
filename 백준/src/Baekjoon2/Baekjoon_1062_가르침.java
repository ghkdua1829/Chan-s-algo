package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1062_가르침 {
	static boolean[] visited = new boolean[26];
	static int N, K, max;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.substring(4, str.length() - 4);
		}
		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		dfs(0, 0);
		System.out.println(max);

	}

	static void dfs(int start, int cnt) {
		if (cnt == K - 5) {
			int tempCnt = 0;
			for (int i = 0; i < arr.length; i++) {
				String str = arr[i];
				boolean good = false;
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					if (!visited[c - 'a']) {
						good = true;
						break;
					}
				}
				if (!good) {
					tempCnt++;
				}

			}
			max = Math.max(tempCnt, max);

		} else {
			for (int i = start; i < 26; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

}