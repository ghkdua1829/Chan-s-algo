package Baekjoon;

import java.util.Scanner;

public class Baekjoon_1120_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= num2.length() - num1.length(); i++) {
			int result = 0;
			for (int k = 0; k < num1.length(); k++) {
				if (num1.charAt(k) != num2.charAt(k + i)) {
					result++;
				}
			}
			if (result < min) {
				min = result;
			}
		}
		System.out.println(min);
	}

}
