package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1546_평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double big = 0;
		double[] nums = new double[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Double.parseDouble(token.nextToken());
			if (big < nums[i]) {
				big = nums[i];
			}
		}
		double sum = 0;
		for(int i=0;i<N;i++) {
			double num = nums[i];
			sum+= num/big*100;
		}
		System.out.println(sum/N);
	}

}
