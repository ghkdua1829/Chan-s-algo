package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2309_일곱난쟁이 {
	static int[] arr = new int[9];
	static int minus;
	static boolean token = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		minus = sum - 100;
		makeCombination(2, new int[2], 0, 0);

	}

	static void makeCombination(int r, int[] temp, int current, int start) {
		if (token) {
			return;
		}
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int tempSum = 0;
			for (int i = 0; i < temp.length; i++) {
				tempSum += temp[i];
			}
			if (tempSum == minus) {
				token = true;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == temp[0] || arr[i] == temp[1]) {

					} else {
						System.out.println(arr[i]);
					}
				}
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}
}
