package level4;

import java.util.HashMap;

public class 호텔방배정 {

	static HashMap<Long, Long> root = new HashMap<>();

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		for (int i = 0; i < room_number.length; i++) {
			long empty = find(room_number[i]);
			root.put(empty, empty + 1);
			answer[i] = empty;

		}
		return answer;
	}

	static long find(long x) {
		if (!root.containsKey(x)) {
			return x;
		} else {
			root.put(x, find(root.get(x)));
			return root.get(x);
		}

	}


}