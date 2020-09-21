package level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {

	public static void main(String[] args) {

	}

	public int solution(int[] A, int[] B) {
		int answer = 0;

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("Hello Java");
		Arrays.sort(A);
		Arrays.sort(B);

		int a = 0;
		int b = B.length - 1;
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));

		for(int i=0;i<A.length;i++) {
			answer += A[a++] * B[b--];
		}
//		while (a < A.length / 2) {
//			answer += A[a++] * B[b--];
//		}

//		if (A.length % 2 != 0) {
//			int idx = A.length / 2 + 1;
//			answer += A[idx] * B[idx];
//		}

		return answer;
	}
}
