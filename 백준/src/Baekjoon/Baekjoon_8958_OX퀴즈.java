package Baekjoon;

import java.util.Scanner;

public class Baekjoon_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		
		for (int i = 0; i < count; i++) {
			String src = sc.next();
			String[] arr = src.split("");
			int point = 0;
			int result = 0;
			for (int k = 0; k < arr.length; k++) {
				if(arr[k].equals("O")) {
					point++;
					result+=point;
				}else {
					point=0;
				}
			}
			System.out.println(result);
		}
	}

}
