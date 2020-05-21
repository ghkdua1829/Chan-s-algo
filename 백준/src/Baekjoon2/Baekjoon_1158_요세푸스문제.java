package Baekjoon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1158_요세푸스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] arr = new boolean[N];
		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		int start = 0;
		while (list.size() != N) {
			int tempCnt = 0;
			cnt = 0;
			while (cnt != 1) {
				for (int i = start; i < start + N; i++) {
					if (!arr[i % N]) {
						tempCnt++;
					}

					if (tempCnt == K) {
						list.add(i % N + 1);
						arr[i % N] = true;
						start = i;
						cnt = 1;
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sb.append(list.get(i)).append(">");
			} else {
				sb.append(list.get(i)).append(", ");
			}
		}
		System.out.println(sb.toString());
	}

}
