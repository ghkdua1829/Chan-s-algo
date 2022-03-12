package SK_ICT;

import java.util.Arrays;

public class Problem1 {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 99, 35, 50, 1000 };
// TODO Auto-generated method stub
		solution(4578, arr);
	}

	public static int solution(int money, int[] costs) {
		int answer = 0;
		costs[1] = Math.min(costs[0] * 5, costs[1]);
		costs[2] = Math.min(costs[1] * 2, costs[2]);
		costs[3] = Math.min(costs[2] * 5, costs[3]);
		costs[4] = Math.min(costs[3] * 2, costs[4]);
		costs[5] = Math.min(costs[4] * 5, costs[5]);
		System.out.println(Arrays.toString(costs));
		return answer;
	}

}
