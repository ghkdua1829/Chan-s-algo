package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_18808_스티커붙이기 {
	static int R, C;
	static int[][] bigArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		bigArr = new int[R][C];
		int K = Integer.parseInt(token.nextToken());
		for (int tc = 0; tc < K; tc++) {
			token = new StringTokenizer(br.readLine());
			int rSize = Integer.parseInt(token.nextToken());
			int cSize = Integer.parseInt(token.nextToken());
			for (int r = 0; r < rSize; r++) {
				for (int c = 0; c < cSize; c++) {

				}
			}
		}
	}

}
