package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

	}

	static void makeNumber(Long number) {
		Long inputNumber = number;
		char[] unitWords = { ' ', '만', '억', '조', '경' };
		int splitunit = 10000;
		int splitCount = unitWords.length;
		List<Integer> resultArray = new ArrayList<Integer>();
		String resultString = "";
	}
}
