package Baekjoon2;

import java.util.Arrays;

public class Kakao {
	static int n, m, result, mod = 1000000007;
	static String[] arr= {"A B C D","A D","A Q W","SDSDA A","AAA A","CAC D"};
	int k = 4;
	public static void main(String[] args) {
//		arr = new int[n+m];
		System.out.println(solution(3, 8, 4));
		System.out.println(factorial(150));
	}

	static public int solution(int n, int m, int k) {
		int answer = -1;
		answer = (int) (factorial(n+m-n)/factorial(m-n));
		return answer;
	}

	public static long factorial(long n) {

		if (n <= 1) {

			return n;

		}

		else {

			return (factorial(n-1)%mod) * (n%mod)%mod;

		}

	}



}
