package level1;

public class 일이사나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	static public String solution(int n) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		while (true) {
			int nam = n % 3;
			n = n / 3;
			String num = "";
			switch (nam) {
			case 1:
				num = "1";
				break;
			case 2:
				num = "2";
				break;
			case 0:
				num = "4";
				n--;
				break;
			}
			sb.append(num);
			if (n == 0) {
				break;
			}
		}
		answer = sb.toString();
		answer = (new StringBuffer(answer)).reverse().toString();
		return answer;
	}
}
