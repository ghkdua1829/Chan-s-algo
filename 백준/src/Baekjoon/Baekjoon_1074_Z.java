package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1074_Z {
	static int time, rr, cc, R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		int Size = (int) Math.pow(2, N);
		read(Size, 0, 0);
	}

	public static void read(int size, int startR, int startC) {
		if (size == 2) {

			for (int tempR = 0; tempR < 2; tempR++) {
				for (int tempC = 0; tempC < 2; tempC++) {
					if (startC + tempC == C && startR + tempR == R) {
						System.out.println(time);
					}
					time++;
				}
			}

		} else {
			read(size / 2, startR, startC); // 1사분면
			read(size / 2, startR, startC + size / 2); // 2사분면
			read(size / 2, startR + size / 2, startC); // 3사분면
			read(size / 2, startR + size / 2, startC + size / 2); // 4사분면
		}
	}

}
