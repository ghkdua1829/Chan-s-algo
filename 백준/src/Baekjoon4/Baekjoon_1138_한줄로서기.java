package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1138_한줄로서기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int t = 1; t <= N; t++) {
			int jumpCnt = Integer.parseInt(token.nextToken());
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (jumpCnt == cnt) {
					for (int j = cnt; j < arr.length; j++) {
						if (arr[j] == 0) {
							arr[j] = t;
							break;
						}
					}
					break;
				}
				if (arr[i] == 0) {
					cnt++;
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb.toString());

	}

}
