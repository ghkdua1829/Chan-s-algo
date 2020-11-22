package Baekjoon4;

import java.io.*;
import java.util.*;

public class Baekjoon_14889_스타트와링크 {
	static int N, count = 0, min = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		makeCombination(N / 2, new boolean[N], 0, 0);
		System.out.println(min);
	}

	static void makeCombination(int r, boolean[] temp, int current, int start) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int[] startTeam = new int[N / 2];
			int[] linkTeam = new int[N / 2];
			int startIdx = 0;
			int linkIdx = 0;
			int startPoint = 0;
			int linkPoint = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i]) {
					startTeam[startIdx++] = i;
				} else {
					linkTeam[linkIdx++] = i;
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i < j) {
						startPoint += arr[startTeam[i]][startTeam[j]] + arr[startTeam[j]][startTeam[i]];
						linkPoint += arr[linkTeam[i]][linkTeam[j]] + arr[linkTeam[j]][linkTeam[i]];
					}
				}
			}
			min = Math.min(min, Math.abs(startPoint - linkPoint));

		} else {
			for (int i = start; i < N; i++) {
				temp[i] = true;
				makeCombination(r, temp, current + 1, i + 1);
				temp[i] = false;
			}
		}
	}

}
