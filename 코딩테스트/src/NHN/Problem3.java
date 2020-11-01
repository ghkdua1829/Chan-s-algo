package NHN;

import java.util.Stack;

public class Problem3 {

	public static void main(String[] args) {
		int numOfOrder = 2;
		String[] orderArr = { "3B(G())", "3(R2(GB))" };
		solution(numOfOrder, orderArr);
	}

	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for (int t = 0; t < numOfOrder; t++) {
			String order = orderArr[t];

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < order.length(); i++) {
				Character c = order.charAt(i);
				if (c == ')') {
					StringBuilder sb = new StringBuilder();
					while (true) {
						Character pop = stack.pop();
						if (pop == '(') {
							sb.append(stack.pop());
							break;
						} else {
							sb.append(pop);
						}
					}
					sb.reverse();
					String makingStr = makeString(sb.toString());
					for (int m = 0; m < makingStr.length(); m++) {
						stack.push(makingStr.charAt(m));
					}
				} else if (c >= 48 && c <= 57) {
					// 숫자일 때
					if (order.charAt(i + 1) != '(') {
						for (int j = 0; j < c - '0'; j++) {
							stack.push(order.charAt(i + 1));
						}
						i++;
					}else {
						stack.push(c);
					}
				} else {
					stack.push(c);
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

	static String makeString(String str) {
		StringBuilder sb = new StringBuilder();
		Character first = str.charAt(0);
		if (first >= 48 && first <= 57) {
			// 숫자일때
			for (int j = 0; j < first - '0'; j++) {
				sb.append(str.substring(1, str.length()));
			}
		} else {
			for (int i = 1; i < str.length(); i++) {
				sb.append(first);
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

}
