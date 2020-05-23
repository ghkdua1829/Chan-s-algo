package summerCoding;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	static public long solution(long n) {
		Map<Long, Long> map = new HashMap<Long, Long>();

		long temp = 1L;
		int up = 0;
		while (true) {
			temp *= 3;
			up++;
			if (temp > n) {
				break;
			}
		}
		System.out.println(up);
		map.put(0L, 1L);
		map.put(1L, 3L);
		long idx = 1;
		int upNum = 2;
		if (n == 1) {
			return map.get(0L);
		} else if (n == 2) {
			return map.get(1L);
		}

		while (true) {
			long tempidx = idx;
			for (long i = 0L; i < tempidx; i++) {
				idx += 1;
				map.put(idx, map.get((long) i) + map.get(tempidx));
				if (idx == n) {
					return map.get(n - 1L);
				}
			}
			Long tempNum = 1L;
			for (int s = 0; s < upNum; s++) {
				tempNum *= 3;
			}
			upNum++;
			idx += 1;
			map.put(idx, tempNum);
			if (idx == n) {
				return map.get(n - 1L);
			}

		}
	}
}
