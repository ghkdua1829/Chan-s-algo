package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 김찬영
 * @since 2020. 1. 31.
 * @see https://www.acmicpc.net/problem/15649
 * @mem 55780
 * @time 408
 * @caution 백트래킹을 이용한다.
 */
public class Baekjoon_N과M {

	static int N;
	static int M;
	static Boolean[] checked;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		N = nums[0];
		M = nums[1];
		checked = new Boolean[N + 1];
		Arrays.fill(checked, false);
		sb = new StringBuilder();
		NM(0, "");
		System.out.println(sb);
	}

	public static void NM(int dist, String str) {
		if (dist == M) {
			sb.append(str.trim() + '\n');
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				if (checked[i] == false) {
					checked[i] = true;
					NM(dist + 1, str + " " + i);
					checked[i] = false;
				}
			}
		}
	}
}