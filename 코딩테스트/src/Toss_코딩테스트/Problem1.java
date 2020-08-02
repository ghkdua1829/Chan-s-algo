package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List[] list = new List[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<String>();
			String str = br.readLine();
			String[] arr = str.split("[.]");
			for (int j = 0; j < arr.length; j++) {
				list[i].add(arr[j]);
			}
		}
		if (N <= 1) {
			System.out.println("없음");
			return;
		}
		List<String> result = new ArrayList<String>();
		for (int j = 0;; j++) {
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < list.length; i++) {
				
				if (j == list[i].size()-1) {
					break;
				}
				if (j == list[i].size()) {
					if (result.size() == 0 || result.size() == 1) {
						System.out.println("없음");
						return;
					}
					StringBuilder sb = new StringBuilder();
					for (int r = 0; r < result.size() - 1; r++) {
						if (r == result.size() - 2) {
							sb.append(result.get(r));
						} else {
							sb.append(result.get(r) + ".");
						}
					}
					System.out.println(sb.toString());
					return;
				}
				set.add((String) list[i].get(j));
			}
			if (set.size() == 1) {
				Iterator<String> it = set.iterator();
				while (it.hasNext()) {
					result.add(it.next());
				}
			} else {
				break;
			}
		}
		if (result.size() == 0) {
			System.out.println("없음");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			if (i != result.size() - 1) {
				sb.append(result.get(i) + ".");
			} else {
				sb.append(result.get(i));
			}
		}
		System.out.println(sb.toString());

	}

}
