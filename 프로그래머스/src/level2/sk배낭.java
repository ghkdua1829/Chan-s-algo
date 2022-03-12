package level2;

import java.util.Arrays;

public class sk배낭 {

	static int[] value = { 1, 5, 10, 50, 100, 500 };

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
		for (int i = costs.length - 1; i >= 0; i--) {
			int mok = money / value[i];
			money = money % value[i];
			answer += costs[i] * mok;

		}
		return answer;
	}
}
