package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		System.out.println(Arrays.toString(solution(id_list, report, 2)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Map<String, Integer> order = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			order.put(id_list[i], i);
		}

		Set<String> orders = new HashSet<>();
		for (int i = 0; i < report.length; i++) {
			orders.add(report[i]);
		}

		Map<String, Set<String>> map = new HashMap<>();

		Map<String, Integer> cntName = new HashMap<>();
		Map<String, Integer> result = new HashMap<>();
		for (String name : id_list) {
			map.put(name, new HashSet<>());
			cntName.put(name, 0);
			result.put(name, 0);
		}
		Iterator<String> iit = orders.iterator();

		while (iit.hasNext()) {
			String[] strs = iit.next().split(" ");
			String from = strs[0];
			String to = strs[1];
			cntName.put(to, cntName.get(to) + 1);
			map.get(to).add(from);
		}
		Iterator<String> it = cntName.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			int num = cntName.get(key);
			if (num >= k) {
				Iterator itt = map.get(key).iterator();
				while (itt.hasNext()) {
					String value = (String) itt.next();
					result.put(value, result.get(value) + 1);
				}
			}
		}
		int i = 0;
		for (String keySet : result.keySet()) {
			System.out.println(result.get(keySet) + " : " + keySet);
			answer[order.get(keySet)] = result.get(keySet);
		}
		return answer;
	}
}
