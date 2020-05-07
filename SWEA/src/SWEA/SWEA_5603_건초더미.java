package SWEA;

import java.util.Scanner;

/**
 * @author 김찬영
 * @since 2020. 1. 31.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGEbd6cjMDFAUo&categoryId=AWXGEbd6cjMDFAUo&categoryType=CODE
 * @mem 71,012 kb
 * @time 226 ms
 * @caution 같게 만들려면 평균을 구해서 평균보다 큰값들만 평균에서 뺀 값이 정답이다.(아니면 평균보다 작은값들만 뺀 값도 가능)
 */
public class SWEA_5603_건초더미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			int hayCount = sc.nextInt();
			int[] arr = new int[hayCount];
			int sum = 0;
			for (int j = 0; j < hayCount; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			int avg = sum / hayCount;
			int result = 0;
			for (int j = 0; j < hayCount; j++) {
				if (arr[j] > avg) {
					result += arr[j] - avg;
				}
			}
			System.out.println("#" + (i + 1) + " " + result);
		}
	}

}
