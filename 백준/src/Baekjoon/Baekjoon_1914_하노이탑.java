package Baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon_1914_하노이탑 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		BigInteger result = new BigInteger("1");
		if (count == 1) {
			System.out.println(1);
		} else {
			for (int i = 0; i < count; i++) {
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			System.out.println(result);
		}
		if (count <= 20) {
			hanoi(count, 1, 2, 3);
		}
	}

	public static void hanoi(int num, int start, int middle, int end) {
		if (num == 1) {
			System.out.println(start + " " + end);
		} else {
			hanoi(num - 1, start, end, middle);
			System.out.println(start + " " + end);
			hanoi(num - 1, middle, start, end);
		}
	}

}
