package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon_2531_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int d = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		int c = Integer.parseInt(token.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		set.add(c);
		int start = 0;
		int end = 0;

		for (int i = 0; i < k; i++) {
			set.add(arr[i]);
			end++;
		}
		max = Math.max(max, set.size());
		for (int i = 0; i < N; i++) {
			if (arr[start] == c) {
				start++;
			} else {
				set.remove(arr[start++]);
			}

			set.add(arr[end++ % N]);
			max = Math.max(max, set.size());
		}
		System.out.println(max);
	}

}


