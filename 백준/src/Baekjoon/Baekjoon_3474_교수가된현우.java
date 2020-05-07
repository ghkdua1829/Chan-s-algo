package Baekjoon;

import java.util.Scanner;

public class Baekjoon_3474_교수가된현우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			int num = sc.nextInt();
			int count_five = 0;
			for(int j=1;j<=num;j++) {
				int temp =j;
				while(true) {
					if(temp%5==0) {
						temp = temp/5+temp%5;
						count_five++;
					}
					else {
						break;
					}
				}
			}
			System.out.println(count_five);
		}
	}

}
