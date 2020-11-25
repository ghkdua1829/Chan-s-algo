package 이스트소프트;

import java.util.Arrays;

public class Problem1 {

	public static void main(String[] args) {
		String[] card_numbers = { "3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245",
				"3285376499342459", "3285-3764-9934-2452" };
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(card_numbers)));
	}

	static public int[] solution(String[] card_numbers) {
		int[] answer = new int[card_numbers.length];

		for (int i = 0; i < card_numbers.length; i++) {
			String number = card_numbers[i];
			if (number.contains("-")) {
				
				if (number.length() == 19 && number.charAt(4) == '-' && number.charAt(9) == '-'
						&& number.charAt(14) == '-') {
					boolean temp = true;
					for (int k = 0; k < number.length(); k++) {
						if (number.charAt(k) == '-') {
							if (k != 4 && k != 9 && k != 14) {
								answer[i] = 0;
								temp = false;
								break;
							}

						}
					}
					if (temp &&isGood(number)) {
						answer[i] = 1;
					} else {
						answer[i] = 0;
					}
				} else {
					answer[i] = 0;
				}

			} else {
				if (number.length() == 16) {
					if (isGood(number)) {
						answer[i] = 1;
					} else {
						answer[i] = 0;
					}

				} else {
					answer[i] = 0;
				}
			}
		}
		return answer;
	}

	static boolean isGood(String number) {
		int sum = 0;
		boolean jak = true;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == '-') {
				continue;
			}
			int num = number.charAt(i) - '0';
			if (jak) {
				num *= 2;
				if (num / 10 == 1) {
					sum += num / 10;
				}
				sum += num % 10;
			} else {
				sum += num;
			}
			jak = !jak;
		}
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
