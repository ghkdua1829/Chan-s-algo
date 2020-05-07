package Baekjoon;

import java.util.Scanner;

public class Baekjoon_1547_공 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int result = 1;
		for(int i=0;i<count;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if(num1==result) {
				result = num2;
			}else if(num2==result){
				result = num1;
			}
		}
		System.out.println(result);
	}

}
