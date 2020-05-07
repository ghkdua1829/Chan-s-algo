package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			int num = sc.nextInt();
			int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#" + tc + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
