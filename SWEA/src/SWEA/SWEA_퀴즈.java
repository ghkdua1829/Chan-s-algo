package SWEA;

import java.util.Scanner;

public class SWEA_퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			long result = 0;
			int N = sc.nextInt();
			for(int i=1;i<=N;i++) {
				result += quiz(i,i);
			}
			System.out.println("#" + tc + " ");
		}
	}

	public static long quiz(int n,int k) {
		if (k == 0) {
			return 1;
		}
		if(k==1) {
			return n;
		}
		return k;
	}
}
