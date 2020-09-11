package 코드챌린지;

public class Problem3 {

	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	static public int solution(int[] a) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int smallIdx = -1;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				smallIdx = i;
				min = a[i];
			}
		}
		int tempMin = a[0];
		for (int i = 1; i < smallIdx; i++) {
			if (tempMin < a[i]) {
				answer++;
			} else {
				tempMin = a[i];
			}
		}
		tempMin = a[a.length - 1];
		for (int i = a.length - 2; i > smallIdx; i--) {
			if (tempMin < a[i]) {
				answer++;
			} else {
				tempMin = a[i];
			}
		}
		answer = a.length - answer;
		return answer;
	}

}
