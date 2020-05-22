package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int D, W, K, MIN, tempK;
	static int[][] arr;
	static boolean[] visited;
	static int[] nums = { 1, 0 };
	static int[][] tempArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			MIN = Integer.MAX_VALUE;
			StringTokenizer token = new StringTokenizer(br.readLine());
			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			visited = new boolean[D];
			arr = new int[D][W];
			tempArr = new int[D][W];

			for (int r = 0; r < D; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					arr[r][c] = Integer.parseInt(token.nextToken());
					tempArr[r][c] = arr[r][c];
				}
			}
			if (inspect()) {
				System.out.println("#" + tc + " 0");
				continue;
			}

			for (int i = 1; i <= K; i++) {
				tempK = i;
				makeCombination(i, new int[i], 0, 0);
			}
			System.out.println("#" + tc + " " + MIN);
		}

	}

	static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			dfs(temp, 0, new int[temp.length]);

		} else {
			for (int i = start; i < D; i++) {
				if (tempK == MIN) {
					return;
				}
				temp[current] = i;
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

	static void dfs(int[] row, int current, int[] yak) {
		if (current == row.length) {
//			System.out.println("row : " + Arrays.toString(row));
//			System.out.println("yak : " + Arrays.toString(yak));
			for (int r = 0; r < row.length; r++) {
				for (int c = 0; c < W; c++) {
					tempArr[row[r]][c] = yak[r];
				}
			}
			if (inspect()) {
				MIN = Math.min(MIN, tempK);
//				System.out.println("!!!!!!!!!!!@@@@@");
			}
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					tempArr[r][c] = arr[r][c];
				}
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			yak[current] = nums[i];
			dfs(row, current + 1, yak);
			yak[current] = nums[i];

		}
	}

	static boolean inspect() {
		for (int c = 0; c < W; c++) {
			int conStack = 1;
			int before = tempArr[0][c];
			for (int r = 1; r < D; r++) {
				if (before == tempArr[r][c]) {
					conStack++;
				} else {
					before = tempArr[r][c];
					conStack = 1;
				}
				if (conStack == K) {
					break;
				}
			}
			if (conStack < K) {
				return false;
			}
		}
		return true;
	}

}
