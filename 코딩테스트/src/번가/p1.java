package 번가;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("ba"));

	}

	static public int solution(String S) {
		// write your code in Java SE 8
		if (S.contains("aaa")) {
			return -1;
		}
		int result = 0;
		int aCnt = 0;
		for (int i = 0; i <= S.length(); i++) {
			if(i==S.length()) {
				result += 2 - aCnt;
				break;
			}
			Character c = S.charAt(i);
			if (c == 'a') {
				aCnt++;
			} else {
				result += 2 - aCnt;
				aCnt = 0;
			}
		}
		return result;
	}

}
