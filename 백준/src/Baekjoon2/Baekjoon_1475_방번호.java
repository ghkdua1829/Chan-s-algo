package Baekjoon2;

import java.util.Scanner;

public class Baekjoon_1475_방번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int[] arr = new int[9];
		int max = 0;
		int maxidx = -1;
		for (int i = 0; i < N.length(); i++) {
			int s = N.charAt(i) - '0';
			if (s == 9) {
				s = 6;
			}
			arr[s]++;
			
		}
		for (int s = 0; s < 9; s++) {
			if (s >= 7) {
				if (arr[s] >= max) {
					max = arr[s];
					maxidx = s;
				}
			} else {
				if (arr[s] > max) {
					max = arr[s];
					maxidx = s;
				}
			}
			
		}
		int result = 0;
		if (maxidx == 6) {
			if (arr[maxidx] % 2 == 1) {
				result = arr[maxidx] / 2 + 1;
			} else {
				result = arr[maxidx] / 2;
			}
		} else {
			result = arr[maxidx];
		}
		System.out.println(result);
	}

}
