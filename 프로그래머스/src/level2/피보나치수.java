package level2;

public class 피보나치수 {
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(8);
	}

	static public int solution(int n) {
		int answer = 0;
		arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}else {
			return arr[n];
		}
		System.out.println(arr[n]);
		return 1234567%arr[n];
	}

}
