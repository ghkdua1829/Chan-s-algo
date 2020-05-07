package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14890_경사로 {
	static int N, L, result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		L = Integer.parseInt(token.nextToken());
		arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		for (int r = 0; r < N; r++) {
			result++;
			int sameCount = 0;
			int tempValue = arr[r][0];
			boolean down = false;
			boolean first = true;
			for (int c = 0; c < N; c++) {
				if (tempValue == arr[r][c]) {
					sameCount++;
				} else if (tempValue - arr[r][c] == 1) {
					if (down) {
						if (sameCount < L) {
							result--;
							break;
						}
					}
					sameCount = 1;
					tempValue = arr[r][c];
					down = true;
				} else if (tempValue - arr[r][c] == -1) {
					if (down) {
						if (sameCount < L * 2) {
							result--;
							break;
						}
					} else {
						if (sameCount < L) {
							result--;
							break;
						}
					}
					sameCount = 1;
					tempValue = arr[r][c];
					down = false;
				} else {
					result--;
					break;
				}
				if (c == N - 1) {
					if (down) {
						if (sameCount < L) {
							result--;
							break;
						}
					}
				}
			}
		}
		for (int c = 0; c < N; c++) {
			result++;
			int sameCount = 0;
			int tempValue = arr[0][c];
			boolean down = false;
			for (int r = 0; r < N; r++) {
				if (tempValue == arr[r][c]) {
					sameCount++;
				} else if (tempValue - arr[r][c] == 1) {
					if (down) {
						if (sameCount < L) {
							result--;
							break;
						}
					}
					sameCount = 1;
					tempValue = arr[r][c];
					down = true;
				} else if (tempValue - arr[r][c] == -1) {
					if (down) {
						if (sameCount < L * 2) {
							result--;
							break;
						}
					} else {
						if (sameCount < L) {
							result--;
							break;
						}
					}
					sameCount = 1;
					tempValue = arr[r][c];
					down = false;
				} else {
					result--;
					break;
				}
				if (r == N - 1) {
					if (down) {
						if (sameCount < L) {
							result--;
							break;
						}
					}
				}
			}
		}
		System.out.println(result);
	}

}
