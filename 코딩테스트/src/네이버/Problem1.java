package 네이버;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		solution("kkaxbyacyz", "abc");
	}

	static public String solution(String m, String k) {
		String answer = "";
		Map<Character, Point> map = new HashMap<Character, Point>();
		int temp = 0;
		for (int i = 0; i < k.length(); i++) {
			Character c = k.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, new Point(temp++, map.get(c).value + 1));
			} else {
				map.put(c, new Point(temp++, 1));
			}
		}
//		System.out.println(map.toString());
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < m.length(); i++) {
			Character c = m.charAt(i);
			if (map.containsKey(c) && map.get(c).idx == idx) {
				if (map.get(c).value == 1) {
					map.remove(c);
				} else {
					map.put(c, new Point(map.get(c).idx, map.get(c).value -1));
				}
				idx++;
			} else {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
		return answer;

	}

	static class Point {
		int idx, value;

		public Point(int idx, int value) {
			super();
			this.idx = idx;
			this.value = value;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
