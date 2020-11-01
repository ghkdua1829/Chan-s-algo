package SW통합;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem6 {
	static Character[] arr = { 'a', 'e', 'i', 'o', 'u' };
	static Map<Character, Character[]> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(countPerms(26));
	}

	public static int countPerms(int n) {
		// Write your code here
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 5;
		}
		Character[] aArr = { 'e' };
		Character[] eArr = { 'a', 'i' };
		Character[] iArr = { 'a', 'e', 'o', 'u' };
		Character[] oArr = { 'i', 'u' };
		Character[] uArr = { 'a' };
		map.put('a', aArr);
		map.put('e', eArr);
		map.put('i', iArr);
		map.put('o', oArr);
		map.put('u', uArr);
		int result = 0;

		Queue<Text> queue = new LinkedList<>();
		queue.offer(new Text('a', 1));
		queue.offer(new Text('e', 1));
		queue.offer(new Text('i', 1));
		queue.offer(new Text('o', 1));
		queue.offer(new Text('u', 1));
		while (!queue.isEmpty()) {
			Text top = queue.poll();
			Character[] next = map.get(top.last);
			for (int i = 0; i < next.length; i++) {
				if (top.length + 1 == n) {
					result = (result + 1) % 100000007;
				} else {
					queue.offer(new Text(next[i], top.length + 1));
				}
			}
		}
		return result;
	}

	static class Text {
		Character last;
		int length;

		public Text(Character last, int length) {
			super();
			this.last = last;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Text [last=" + last + ", length=" + length + "]";
		}

	}
}
