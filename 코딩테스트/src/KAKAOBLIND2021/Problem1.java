package KAKAOBLIND2021;

public class Problem1 {

	public static void main(String[] args) {
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

	static public String solution(String new_id) {
		String answer = "";
		// 1. 소문자로 치환하기
		new_id = new_id.toLowerCase();

		// 2. 주어진 문자외에 다 제거하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if ((c <= 122 && c >= 97) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
				sb.append(c);
			}
		}
		new_id = sb.toString();

		// 3. .이 두개이상 된부분 하나의 . 으로 바꾸기
		int idx = -21;
		sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c == '.') {
				if (i == idx + 1) {

				} else {
					sb.append(c);
				}
				idx = i;
			} else {
				sb.append(c);
			}
		}
		new_id = sb.toString();

		// 4. .이 맨앞과 뒤이면 지워라
		if (new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		
		if (new_id.length()>=1&&new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}

		// 5. 빈문자열이면 a를 대입하라
		if (new_id.length() == 0) {
			new_id = "a";
		}
		// 6. 길이가 16이상이면 15개만 남겨라
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		if (new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		if (new_id.length()>=1&&new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}
		// 7. 길이가 2이하라면 마지막문자를 3이될때까지 붙여라
		if (new_id.length() <= 2) {
			char last = new_id.charAt(new_id.length()-1);
			while(new_id.length()<3) {
				new_id+=last;
			}
		}
		answer = new_id;
		return answer;
	}
}
