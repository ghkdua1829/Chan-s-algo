package level2;

import java.util.Stack;

public class N진수게임 {

	public static void main(String[] args) {
		System.out.println(change(15, 16));
	}

	static public String solution(int n, int t, int m, int p) {
		String answer = "";
		int order = 1;
		boolean token = false;
		if(m==p) {
			p=0;
		}
		for (int i = 0;; i++) {
			String number = change(i, n);
			for (int k = 0; k < number.length(); k++) {
				if (order % m == p) {
					answer += number.charAt(k);
					if (answer.length() == t) {
						token = true;
						break;
					}
				}
				order++;
			}
			if (token) {
				break;
			}
		}
		return answer;
	}

	static String change(int num, int su) {
		Stack<Object> stack = new Stack<Object>();
		String result = "";
		while (num > 0) {
			if (num % su > 9) {
				stack.add((char) (num % su + 55));
			} else {
				stack.add(num % su);
			}
			num = num / su;
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		if (result.equals("")) {
			result = "0";
		}
		return result;
	}
}
