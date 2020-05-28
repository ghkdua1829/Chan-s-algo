package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9625_BABBA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int A = 1;
		int B = 0;
		for (int i = 0; i < K; i++) {
			int tempA = 0;
			int tempB = 0;
			tempB += A;
			tempB += B;
			tempA += B;
			A = tempA;
			B = tempB;
		}
		System.out.println(A + " " + B);
	}

}
