package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Long[] arr = new Long[N];
			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = (long) Integer.parseInt(token.nextToken());
			}

			int count = 0;
			Long money = 0L;
			Long max = -1L;

			for (int i = arr.length - 1; i >= 0; i--) {
				if (max < arr[i]) {
					max = arr[i];
				} else {
					money += max - arr[i];
				}
			}

			System.out.println("#" + t + " " + money);
		}
	}

}
