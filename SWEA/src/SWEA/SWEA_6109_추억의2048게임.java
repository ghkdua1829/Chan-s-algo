package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_6109_추억의2048게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(token.nextToken());
			String dir = token.nextToken();
			int[][] arr = new int[N][N];
			int[][] resultarr = new int[N][N];
			for (int r = 0; r < N; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			List<Integer>[] list = new List[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}

			List<Integer>[] resultlist = new List[N];
			for (int i = 0; i < N; i++) {
				resultlist[i] = new ArrayList<>();
			}
			switch (dir) {
			case "up":
				for (int c = 0; c < N; c++) {
					for (int r = 0; r < N; r++) {
						if (arr[r][c] != 0) {
							list[c].add(arr[r][c]);
						}
					}
				}
				for (int c = 0; c < N; c++) {
					int before = -1;
					for (int i = 0; i < list[c].size(); i++) {
						if (before == list[c].get(i)) {
							resultlist[c].add(before * 2);
							before = -1;
						} else {
							if (before != -1) {
								resultlist[c].add(before);
							}
							before = list[c].get(i);
						}
					}
					if (before != -1) {
						resultlist[c].add(before);
					}
				}
				for (int c = 0; c < N; c++) {
					for (int r = 0; r < resultlist[c].size(); r++) {
						resultarr[r][c] = resultlist[c].get(r);
					}
				}
				break;
			case "down":
				for (int c = 0; c < N; c++) {
					for (int r = N - 1; r >= 0; r--) {
						if (arr[r][c] != 0) {
							list[c].add(arr[r][c]);
						}
					}
				}
				for (int c = 0; c < N; c++) {
					int before = -1;
					for (int i = 0; i < list[c].size(); i++) {
						if (before == list[c].get(i)) {
							resultlist[c].add(before * 2);
							before = -1;
						} else {
							if (before != -1) {
								resultlist[c].add(before);
							}
							before = list[c].get(i);
						}
					}
					if (before != -1) {
						resultlist[c].add(before);
					}
				}
				for (int c = 0; c < N; c++) {
					for (int i = 0, r = N - 1; i < resultlist[c].size(); i++, r--) {
						resultarr[r][c] = resultlist[c].get(i);
					}
				}

				break;
			case "right":
				for (int r = 0; r < N; r++) {
					for (int c = N - 1; c >= 0; c--) {
						if (arr[r][c] != 0) {
							list[r].add(arr[r][c]);
						}
					}
				}
				for (int r = 0; r < N; r++) {
					int before = -1;
					for (int i = 0; i < list[r].size(); i++) {
						if (before == list[r].get(i)) {
							resultlist[r].add(before * 2);
							before = -1;
						} else {
							if (before != -1) {
								resultlist[r].add(before);
							}
							before = list[r].get(i);
						}
					}
					if (before != -1) {
						resultlist[r].add(before);
					}
				}
				for (int r = 0; r < N; r++) {
					for (int i = 0, c = N - 1; i < resultlist[r].size(); i++, c--) {
						resultarr[r][c] = resultlist[r].get(i);
					}
				}
				break;
			case "left":
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (arr[r][c] != 0) {
							list[r].add(arr[r][c]);
						}
					}
				}
				for (int r = 0; r < N; r++) {
					int before = -1;
					for (int i = 0; i < list[r].size(); i++) {
						if (before == list[r].get(i)) {
							resultlist[r].add(before * 2);
							before = -1;
						} else {
							if (before != -1) {
								resultlist[r].add(before);
							}
							before = list[r].get(i);
						}
					}
					if (before != -1) {
						resultlist[r].add(before);
					}
				}
				for (int r = 0; r < N; r++) {
					for (int i = 0, c = 0; i < resultlist[r].size(); i++, c++) {
						resultarr[r][c] = resultlist[r].get(i);
					}
				}
				break;
			}
			System.out.println("#" + tc);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(resultarr[r][c] + " ");
				}
				System.out.println();
			}
		}
	}

}
