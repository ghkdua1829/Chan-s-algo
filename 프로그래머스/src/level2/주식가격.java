package level2;

public class 주식가격 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int[] solution(int[] prices) {
		int[] answer = {};
		answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int value = prices[i];
			int temp = 1;
			for (int j = i + 1; j < prices.length; j++) {
				if (j == prices.length - 1) {
					answer[i] = temp;
					break;
				}
				if (value > prices[j]) {
					answer[i] = temp;
					break;
				} else {
					temp++;
				}
			}
		}
		return answer;
	}

}
