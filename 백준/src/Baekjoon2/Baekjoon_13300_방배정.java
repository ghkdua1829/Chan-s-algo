package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());

		List<Integer>[][] arr = new List[6][2];
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 2; c++) {
				arr[r][c] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(token.nextToken());
			int Y = Integer.parseInt(token.nextToken()) - 1;
			arr[Y][S].add(0);
		}
		int sum = 0;
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 2; c++) {
				sum += arr[r][c].size() / K;
				if (arr[r][c].size() % K > 0) {
					sum++;
				}
			}
		}

		System.out.println(sum);
	}

}
