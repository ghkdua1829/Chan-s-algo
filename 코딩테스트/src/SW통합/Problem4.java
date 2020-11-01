package SW통합;

public class Problem4 {
	public static void main(String[] args) {
		long l =11111111113L;
		System.out.println(isPrime(l));
	}

	public static int isPrime(long n) {
		// Write your code here
		long zeNum = 0;
		for (long l = 2; l < n/2; l++) {
			if (n % l == 0) {
				zeNum = l;
				return (int) zeNum;
			}
		}
		return 1;

	}
}
