package level3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑2 {
	static int smallest = Integer.MAX_VALUE;

	public static void main(String[] args) {
		String[] gems = { "XYZ", "XYZ", "XYZ" };
		solution(gems);
	}

	static public int[] solution(String[] gems) {
		int[] answer = new int[2];
		Map<String, Integer> map = new HashMap<String, Integer>();
		int idx = 0;
		Set<String> set = new HashSet<String>();
		for (String gem : gems) {
			set.add(gem);
		}
		int n = set.size();
		while (idx < gems.length) {
			if (map.size() < n) {
				map.put(gems[idx], idx++);
			}
			if (map.size() == n) {
				if (smallest > Collections.max(map.values()) - Collections.min(map.values())) {
					smallest = Collections.max(map.values()) - Collections.min(map.values());
					answer[0] = Collections.min(map.values()) + 1;
					answer[1] = Collections.max(map.values()) + 1;
				}
				map.remove(gems[Collections.min(map.values())]);
			}
		}
		return answer;
	}
}
