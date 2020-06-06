package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon_5567_결혼식 {
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list[a].add(b);
			if (a != 1)
				list[b].add(a);
		}
		int result = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < list[1].size(); i++) {
			int friend = list[1].get(i);
			set.add(friend);
			for (int j = 0; j < list[friend].size(); j++) {
				set.add(list[friend].get(j));
			}
		}
		result += set.size();
		System.out.println(result);

	}

}
