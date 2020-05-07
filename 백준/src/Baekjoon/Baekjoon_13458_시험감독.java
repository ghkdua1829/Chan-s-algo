package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger result = new BigInteger("0");
		int[] arr = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(token.nextToken());
		int C = Integer.parseInt(token.nextToken());

		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			sum -= B;
			result = result.add(BigInteger.ONE);
			if (sum > 0) {
				result = result.add(BigInteger.valueOf(sum / C));
				if (sum % C > 0) {
					result = result.add(BigInteger.ONE);
				}
			}
		}
		System.out.println(result);
	}

}
