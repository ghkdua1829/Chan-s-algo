package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		int cnt = 0;
		// 1.배열의 하나의 인덱스를 가리키는 Start 점과 End 점 두개를 만들자.(start는 시작지점, End는 끝점을 가리킨다.)
		// 2.처음 start와 end는 0으로 초기화해준다.
		int start = 0;
		int end = 0;

		int sum = 0;
		// 3. start 점부터 end점까지의 합을 구해서 sum 에 저장해준다.
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		for (int i = 0;; i++)
			try {
				if (sum == M) {
					cnt++;
					sum = sum + arr[++end] - arr[start++];
				} else if (sum < M) {
					sum += arr[++end];
				} else {
					sum -= arr[start];
					start++;
				}

			} catch (Exception e) {
				break;
			}
		System.out.println(cnt);
	}

}
