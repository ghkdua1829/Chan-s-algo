package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int min, N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer token = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(token.nextToken());
				}
			}

			makeCombination(N / 2, new int[N / 2], 0, 0, new boolean[N]);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void makeCombination(int r, int[] firstCook, int current, int start, boolean[] visited) {
		if (r == current) {
			int[] secondCook = new int[N / 2];
			int a = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					secondCook[a] = i;
					a++;
				}
			}
			int sumA = 0, sumB = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sumA+=arr[firstCook[i]][firstCook[j]];
					sumB+=arr[secondCook[i]][secondCook[j]];
				}
			}
			if(min>Math.abs(sumA-sumB)) {
				min = Math.abs(sumA-sumB);
			}

		} else {
			for (int i = start; i < N; i++) {
				firstCook[current] = i;
				visited[i] = true;
				makeCombination(r, firstCook, current + 1, i + 1, visited);
				visited[i] = false;

			}
		}
	}
}
