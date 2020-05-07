package SWEA;

import java.util.Scanner;

public class SWEA_부분수열의합 {
	static int size;
	static int[] arr;
	static int k,result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			result = 0;
			size = sc.nextInt();
			k = sc.nextInt();
			arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			for(int r=0;r<=arr.length;r++) {
				powerSet(r,new boolean[arr.length],0,0);

			}
			System.out.println("#"+tc+" "+result);
		}
	}

	public static void powerSet(int r, boolean[] visited, int current, int start) {
		if (r == current) {
			int sum = 0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					sum+=arr[i];
				}
			}
			if(sum==k) {
				result++;
			}
		} else {
			for (int i = start; i < size; i++) {
				if (!visited[i]) {
					visited[i] = true;
					powerSet(r, visited, current + 1, i + 1);
					visited[i] = false;
				}
			}
		}
	}
}
