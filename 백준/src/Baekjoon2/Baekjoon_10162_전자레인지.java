package Baekjoon2;

import java.util.Scanner;

public class Baekjoon_10162_전자레인지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A = 300;
		int B = 60;
		int C = 10;
		int[] arr = new int[3];
		if(T/A>0) {
			arr[0] = T/A;
			T = T%A;
		}
		if(T/B>0) {
			arr[1]=T/B;
			T=T%B;
		}
		if(T/C>0) {
			arr[2]=T/C;
			T=T%C;
		}
		if(T!=0) {
			System.out.println(-1);
		}else {
			for(int i=0;i<3;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
