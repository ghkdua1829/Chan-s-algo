package recursion;

public class 재귀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		arr[0] = 0;
		arr[1] = 1;

		long start = System.currentTimeMillis();

		System.out.println("1. 재귀를 이용하여 그냥 구하기.");
		System.out.println("답 : " + fibo(45));
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);

		System.out.println("-------------------------------------");

		start = System.currentTimeMillis();
		System.out.println("2. 메모이제이션을 이용하여 구하기.");

		System.out.println("답 : " + fiboMemoization(45));
		end = System.currentTimeMillis();

		System.out.println("실행 시간 : " + (end - start) / 1000.0);

	}

	static long fibo(int N) {
		if (N <= 1) {
			return N;
		} else {
			return fibo(N - 1) + fibo(N - 2);
		}
	}

	static long[] arr = new long[51];

	static long fiboMemoization(int N) {
		if (N == 0) {
			return arr[0];
		} else if (N == 1) {
			return arr[1];
		} else if (arr[N] != 0) {
			return arr[N];
		} else {
			return arr[N] = fiboMemoization(N - 1) + fiboMemoization(N - 2);
		}
	}
}
