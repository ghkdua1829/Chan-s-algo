package practice;

public class P {
	static long[] arr = new long[81];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(7));
	}

	static public long solution(int n) {
		arr[0]= 0;
		arr[1]= 1;
		
		return pibo(n);
	}

	static long pibo(int n) {
		if (arr[n] != 0) {
			return arr[n];
		}
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return arr[n] = pibo(n - 1) + pibo(n - 2);
	}
}
