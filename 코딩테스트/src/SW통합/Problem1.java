package SW통합;

import java.util.List;

public class Problem1 {
	public static void main(String[] args) {

	}

	public static int balancedSum(List<Integer> arr) {
		// Write your code here
		int pivot = 1;
		int leftSum = 0;
		int rightSum = 0;
		for (int l = 0; l < pivot; l++) {
			leftSum += arr.get(l);
		}
		for (int r = pivot + 1; r < arr.size(); r++) {
			rightSum += arr.get(r);
		}
		while (true) {
			if (leftSum == rightSum) {
				break;
			}
			leftSum += arr.get(pivot++);
			rightSum -= arr.get(pivot);

		}
		
		System.out.println(pivot);
		return pivot;
	}

}
