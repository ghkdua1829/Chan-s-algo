package level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 보석쇼핑3 {

	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static HashSet<String> set = new HashSet<>();

	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		for (int i = 0; i < gems.length; i++) {
			set.add(gems[i]);
		}

		Iterator<String> it = set.iterator();

		int start = 0;
		int end = 0;
		int length = Integer.MAX_VALUE;

		while (true) {

			if (set.size() == map.size()) {
				if (length > end - start) {
					answer[1] = end;
					answer[0] = start + 1;
					length = end - start;
				}
				String minusBosuk = gems[start];
				map.put(minusBosuk, map.get(minusBosuk) - 1);
				if (map.get(minusBosuk) == 0) {
					map.remove(minusBosuk);
				}

				start++;

			} else if (end >= gems.length) {
				break;
			} else {
				String gem = gems[end];
				if (map.containsKey(gem)) {
					int gemCnt = map.get(gem);
					map.put(gem, gemCnt + 1);
					end++;
				}else {
					map.put(gem, 1);
					end++;
				}
			}
			
		}
		if (length == Integer.MAX_VALUE) {
			answer[1] = end;
			answer[0] = start + 1;
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	static boolean isFour() {

		Iterator<String> it = set.iterator();
		boolean isEmpty = false;
		while (it.hasNext()) {
			if (map.get(it.next()) == 0) {
				isEmpty = true;
			}
		}
		return !isEmpty;
	}

	public static void main(String[] args) {
		String[] gemps = { "A", "A", "B"};
		System.out.println(solution(gemps));
	}

}
