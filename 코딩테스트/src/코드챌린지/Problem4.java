package 코드챌린지;

import java.util.Arrays;

public class Problem4 {

	public static void main(String[] args) {

	}

	static public int solution(int[][] a) {
		int answer = -1;
		
		return answer;
	}

	static void makeCombination(int r, int[] temp, int current,int start ,int[][] a) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for(int i=start;i<a.length;i++) {
				temp[current] = a[i][0];
			}
		}
	}
}
