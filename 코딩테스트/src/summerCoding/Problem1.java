package summerCoding;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) {
		System.out.println(solution(10000));
	}

	static public int solution(int p) {
		int i = 0;
		for (i = p + 1;; i++) {
			String str = String.valueOf(i);
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < str.length(); j++) {
				set.add(str.charAt(j));
			}
			if (set.size() == str.length()) {
				break;
			}
		}
		return i;
	}

}
