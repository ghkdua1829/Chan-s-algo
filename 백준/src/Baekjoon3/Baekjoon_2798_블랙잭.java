package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2798_블랙잭 {
	static int[] arr;
	static int M,result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		arr = new int[N];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		makeCombination(3, new int[3], 0, 0);
		System.out.println(result);

	}

	static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			int sum = 0;
			for(int i=0;i<temp.length;i++) {
				sum+=temp[i];
			}
			if(sum<=M) {
				result = Math.max(result, sum);
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

}
