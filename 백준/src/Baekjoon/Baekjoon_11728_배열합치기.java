package Baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11728_배열합치기 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());

		int[] left = new int[A];
		int[] right = new int[B];
		tokens = new StringTokenizer(in.readLine());
		for (int i = 0; i < A; i++) {
			left[i] = (Integer.parseInt(tokens.nextToken()));
		}
		tokens = new StringTokenizer(in.readLine());
		for (int i = 0; i < B; i++) {
			right[i] = (Integer.parseInt(tokens.nextToken()));
		}
		merge(left, right);
	}

	private static void merge(int[] left, int[] right) {
		int l = 0, r = 0;
		while (true) {
			if (left[l] < right[r]) {
				sb.append(left[l]).append(" ");
				l++;
				if (l == left.length) {
					for (int i = r; i < right.length; i++) {
						sb.append(right[i]).append(" ");
					}
					break;
				}
			} else {
				sb.append(right[r]).append(" ");
				r++;
				if (r == right.length) {
					for (int i = l; i < left.length; i++) {
						sb.append(left[i]).append(" ");
					}
					break;
				}
			}

		}
		System.out.println(sb);
	}
}
