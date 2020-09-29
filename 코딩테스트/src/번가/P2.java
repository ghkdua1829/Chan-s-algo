package 번가;

import java.util.Arrays;

public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int[] solution(String[] S) {
		// write your code in Java SE 8

		for (int i = 0; i < S.length; i++) {
			String targetStr = S[i];
			for (int j = i + 1; j < S.length; j++) {
				String tempStr = S[j];
				for (int s = 0; s < tempStr.length(); s++) {
					if (S[i].charAt(s) == S[j].charAt(s)) {
						int[] result = new int[3];
						result[0] = i;
						result[1] = j;
						result[2] = s;
						return result;
					}
				}
			}
		}
		int[] empty = new int[0];

		return empty;

	}

//	static void makeCombination(int r,int current,int[] temp,int start) {
//		if(r==current ) {
//			System.out.println(Arrays.toString(temp));
//		}else {
//			for(int i=start;i<temp.length;i++) {
//				
//			}
//		}
//	}
}
