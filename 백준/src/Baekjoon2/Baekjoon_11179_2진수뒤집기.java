package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11179_2진수뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String binary = Integer.toBinaryString(N);
		StringBuilder sb = new StringBuilder();
		for (int i = binary.length() - 1; i >= 0; i--) {
			char c = binary.charAt(i);
			sb.append(c);
		}
		String temp = sb.toString();
		int ten  =Integer.parseInt(temp,2);
		System.out.println(ten);
	}

}
