package SW통합;

import java.util.List;

public class Problem5 {
	public static void main(String[] args) {

	}

	public static int minX(List<Integer> arr) {
		// Write your code here
		int minSum = Integer.MAX_VALUE;
		int tempSum = 0;
		for (int i = 0; i < arr.size(); i++) {
			tempSum += arr.get(i);
			minSum = Math.min(minSum, tempSum);
		}
		return Math.abs(minSum) + 1;
	}
}
