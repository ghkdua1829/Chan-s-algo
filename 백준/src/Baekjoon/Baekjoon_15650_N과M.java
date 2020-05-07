package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15650_N과M {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}
		makePermutaion(M, new int[M], 0, 0);
	}

	static void makePermutaion(int r, int[] temp, int current, int start) {
		if (r == current) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = start; i < N; i++) {
				temp[current] = arr[i];
				makePermutaion(r, temp, current + 1, i + 1);
			}
		}
	}
}
