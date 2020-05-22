package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			makePermutation(0, 0, 0, visited, arr);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static void makePermutation(int left, int right, int current, boolean[] visited, int[] arr) {
		if (arr.length == current) {
			cnt++;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {

					if (left >= right + arr[i]) {
						visited[i] = true;
						makePermutation(left, right + arr[i], current + 1, visited, arr);
						visited[i] = false;

					}
					visited[i] = true;
					makePermutation(left + arr[i], right, current + 1, visited, arr);
					visited[i] = false;
				}
			}
		}
	}
}
