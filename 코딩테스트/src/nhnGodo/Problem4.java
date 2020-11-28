package nhnGodo;

import java.util.*;

public class Problem4 {

	public static void main(String[] args) {
		String cardNumber = "21378";
		// TODO Auto-generated method stub
		solution(cardNumber);
	}

	static public String solution(String cardNumber) {
		boolean jjak = false;
		if (cardNumber.length() % 2 == 0) {
			jjak = true;
		}
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < cardNumber.length(); i++) {
			if (jjak) {
				if (i % 2 == 0) {
					sum += ((cardNumber.charAt(i) - '0') * 2) % 10 + ((cardNumber.charAt(i) - '0') * 2) / 10;
				} else {
					sum += (cardNumber.charAt(i) - '0');
				}
			} else {
				if (i % 2 == 1) {
					sum += ((cardNumber.charAt(i) - '0') * 2) % 10 + ((cardNumber.charAt(i) - '0') * 2) / 10;
				} else {
					sum += (cardNumber.charAt(i) - '0');
				}
			}
		}
		if(sum%10==0) {
			return "VALID";
		}else {
			return "INVALID";
		}
	}

}
