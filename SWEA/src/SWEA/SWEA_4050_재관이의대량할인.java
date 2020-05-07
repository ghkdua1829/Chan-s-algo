package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_4050_재관이의대량할인 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			Integer[] arr = new Integer[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			Arrays.sort(arr, Collections.reverseOrder());
			for (int i = 0; i < arr.length; i++) {
				if (i % 3 != 2) {
					result += arr[i];
				}
			}
		}
	}

}
