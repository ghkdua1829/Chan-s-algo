package 라인코테;

public class Problem3 {

	public static void main(String[] args) {
		solution(73425);
//		System.out.println("13".substring(1, 2));
	}

	static public int[] solution(int n) {
		int[] answer = new int[2];
		int time = 0;
		String numStr = String.valueOf(n);
		while (numStr.length() != 1) {
			int temp = minGu(numStr);
			numStr = String.valueOf(temp);
			time++;
		}
		answer[0] = time;
		answer[1] = Integer.parseInt(numStr);
		return answer;
	}

	static int minGu(String num) {
		int tempMin = Integer.MAX_VALUE;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i) != '0') {
				int frontNum = Integer.parseInt(num.substring(0, i));
				int backNum = Integer.parseInt(num.substring(i, num.length()));
				int sum = frontNum + backNum;
				tempMin = Math.min(tempMin, sum);
			}
		}
		return tempMin;
	}

}
