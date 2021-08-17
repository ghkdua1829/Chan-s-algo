package Baekjoon4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15652_N과M_4 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		makeAnswer(M, 0, new int[M], 0, N);
		bw.flush();

	}

	static void makeAnswer(int r, int current, int[] temp, int start, int N)  throws IOException {
		if (r == current) {
			for (int i : temp) {
				bw.write(i + " ");
			}
			bw.newLine();
		} else {
			for (int i = start; i < N; i++) {
				temp[current] = i + 1;
				makeAnswer(r, current + 1, temp, i, N);
			}
		}
	}

}
