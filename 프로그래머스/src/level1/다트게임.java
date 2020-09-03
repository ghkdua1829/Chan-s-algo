package level1;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {

	public static void main(String[] args) {
		System.out.println((int) 'A');
		solution("1D2S0T");
	}

	static public int solution(String dartResult) {
		int answer = 0;
		dartResult = dartResult.replaceAll("10", "A");
		List<String> list = new ArrayList<String>();
		int startIdx = 0;
		for (int i = 1; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if ((c >= 48 && c <= 67) || c == 65) {
				list.add(dartResult.substring(startIdx, i));
				startIdx = i;
			}
			if (i == dartResult.length() - 1) {
				list.add(dartResult.substring(startIdx, dartResult.length()));
			}
		}
		List<Integer> score = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int tempSum = 0;
			int num = list.get(i).charAt(0) - '0';
			if (list.get(i).charAt(0) == 'A') {
				num = 10;
			}
			char bonus = list.get(i).charAt(1);
			switch (bonus) {
			case 'S':
				tempSum = num;
				break;
			case 'D':
				tempSum = num * num;
				break;
			case 'T':
				tempSum = num * num * num;
				break;
			}
			if (list.get(i).length() == 3) {
				char option = list.get(i).charAt(2);
				switch (option) {
				case '*':
					if (i != 0) {
						score.set(i - 1, score.get(i - 1) * 2);
					}
					tempSum *= 2;
					break;
				case '#':
					tempSum *= -1;
					break;
				}
			}
			score.add(tempSum);
		}
		for (int s : score) {
			answer += s;
		}
		return answer;
	}
}
