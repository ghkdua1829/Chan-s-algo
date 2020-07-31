package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11728_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int aSize = Integer.parseInt(token.nextToken());
		int bSize = Integer.parseInt(token.nextToken());
		int[] A = new int[aSize];
		int[] B = new int[bSize];

		token = new StringTokenizer(br.readLine());

		for (int a = 0; a < aSize; a++) {
			A[a] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(br.readLine());

		for (int b = 0; b < bSize; b++) {
			B[b] = Integer.parseInt(token.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int arrSzie = aSize + bSize;
		int aPoint = 0;
		int bPoint = 0;
		for (int i = 0; i < arrSzie; i++) {
			if (A[aPoint] > B[bPoint]) {
				sb.append(B[bPoint++] + " ");
			} else {
				sb.append(A[aPoint++] + " ");
			}
			if (aPoint == aSize) {
				for (int j = i + 1; j < arrSzie; j++) {
					sb.append(B[bPoint++] + " ");
				}
				break;
			}
			if (bPoint == bSize) {
				for (int j = i + 1; j < arrSzie; j++) {
					sb.append(A[aPoint++] + " ");
				}
				break;
			}
		}

		System.out.println(sb.toString());
	}

}
