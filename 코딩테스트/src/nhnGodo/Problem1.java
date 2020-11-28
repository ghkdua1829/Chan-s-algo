package nhnGodo;

import java.util.*;

public class Problem1 {

	public static void main(String[] args) {
		int[] goods= {50,62,93};
		// TODO Auto-generated method stub
		System.out.println(solution(goods));
	}

	static public int solution(int[] goods) {
		Arrays.sort(goods);
		int tempSum = 0;
		int sum = 0;
		for (int i = 0; i < goods.length; i++) {
			tempSum += goods[i];
			sum += goods[i];
			if (tempSum >= 50) {
				sum -= 10;
				tempSum = 0;
			}
		}
		return sum;
	}

}
