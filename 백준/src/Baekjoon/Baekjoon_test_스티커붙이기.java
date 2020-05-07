package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_test_스티커붙이기 {
	static int rSize, cSize, K;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		rSize = Integer.parseInt(token.nextToken());
		cSize = Integer.parseInt(token.nextToken());
		arr = new int[rSize][cSize];
		K = Integer.parseInt(token.nextToken());
		for (int tc = 0; tc < K; tc++) {
			
		}
	}

}
