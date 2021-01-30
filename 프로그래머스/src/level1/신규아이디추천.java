package level1;

public class 신규아이디추천 {
	public static void main(String[] args) {
		solution("=.=");
	}

	public static String solution(String new_id) {
		String answer = "";
		// 1단계 : 소문자로 바꾸기
		new_id = new_id.toLowerCase();
		// 2단계
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.') {
				sb.append(c);
			}
		}
		new_id = sb.toString();

		// 3단계
		sb = new StringBuilder();
		boolean jum = false;
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c == '.') {
				if (!jum) {
					jum = true;
					sb.append(c);
				}
			} else {
				jum = false;
				sb.append(c);
			}
		}
		new_id = sb.toString();
		if (new_id.length() > 0 && new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}

		if (new_id.length() == 0) {
			new_id = "a";
		}
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		if (new_id.charAt(new_id.length() - 1) == '.') {
			new_id = new_id.substring(0, new_id.length() - 1);
		}
		sb = new StringBuilder();
		char last = new_id.charAt(new_id.length() - 1);
		if (new_id.length() <= 2) {
			sb.append(new_id);
			while (sb.length() != 3) {
				sb.append(last);
			}
			new_id = sb.toString();
		}

		System.out.println(new_id);
		return answer;
	}
}
