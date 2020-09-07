package level3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑 {
	static int[] result = { Integer.MAX_VALUE, Integer.MAX_VALUE };
	static int finalSmallSize = Integer.MAX_VALUE;
	static Map<String, Integer> jewelry = new HashMap<>();

	public static void main(String[] args) {
		String[] gems = { "DIA", "SSS", "SSS", "DIA", "DIA", "WWW", "SSS" };
		solution(gems);
	}

	static public int[] solution(String[] gems) {
		int[] answer = new int[2];
		Set<String> set = new HashSet<String>();
		for (String gem : gems) {
			set.add(gem);
		}
		int n = set.size();
		int rIdx = 0;
		while (rIdx < gems.length) {
			if (jewelry.size() < n) {
				jewelry.put(gems[rIdx], rIdx++);
			}
			if (jewelry.size() == n) {
				if (finalSmallSize > Collections.max(jewelry.values()) - Collections.min(jewelry.values())) {
					finalSmallSize = Collections.max(jewelry.values()) - Collections.min(jewelry.values());
					answer[0] = Collections.min(jewelry.values()) + 1;
					answer[1] = Collections.max(jewelry.values()) + 1;
				}
				int minIdx = Collections.min(jewelry.values());
				jewelry.remove(gems[minIdx]);
			}
		}
//		System.out.println(answer[0]);
//		System.out.println(answer[1]);
		return answer;
	}
}
