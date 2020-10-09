package 코드챌린지2;

public class Problem1 {

	public static void main(String[] args) {
		solution(45);
	}

	static public int solution(int n) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int nam = n % 3;
			sb = sb.insert(0, nam);
			n = n / 3;
			if (n == 0) {
				break;
			}
		}
//		System.out.println(sb.toString());
		StringBuilder sb2 = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			sb2.append(sb.charAt(i));
		}
//		System.out.println(sb2.toString());
		int size = 0;
		for (int i = sb2.length()-1; i >= 0; i--,size++) {
			int num = (int) Math.pow(3, size);
			answer += num*(sb2.charAt(i)-'0');
		}
//		System.out.println(answer);
		return answer;

	}
}
