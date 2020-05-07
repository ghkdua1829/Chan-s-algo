package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_단순2진암호코드 {
	static String[] secret = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };
	static String tempStr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= count; tc++) {
			String[] g = sc.nextLine().split(" ");
			int N = Integer.parseInt(g[0]);
			int M = Integer.parseInt(g[1]);
			int s = -1;
			String tempStr = "";
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();

				for (s = str.length() - 1; s >= 0; s--) {
					if (str.charAt(s) == '1') {
						break;
					}
				}
				if (s != -1) {
					tempStr = str.substring(s - 55, s + 1);
				}

			}
			List<Integer> list = new ArrayList<Integer>();

			System.out.print("#" + tc + " ");

			for (int i = 0; i < tempStr.length(); i += 7) {
				String oneCode = tempStr.substring(i, i + 7);
				for (int k = 0; k < secret.length; k++) {
					if (secret[k].equals(oneCode)) {
						list.add(k);
					}
				}

			}
			int holSum = 0;
			int jjakSum = 0;
			int resultSum = 0;
			for (int i = 0; i < list.size(); i += 2) {
				holSum += list.get(i);
			}
			for (int i = 1; i < list.size()-1; i += 2) {
				jjakSum += list.get(i);
			}
			holSum *= 3;
//			System.out.println(holSum + jjakSum+list.get(7));
			if ((holSum + jjakSum +list.get(7)) % 10 == 0) {
				for (int i = 0; i < list.size(); i++) {
					resultSum += list.get(i);
				}
				System.out.println(resultSum);
			} else {
				System.out.println(0);
			}
		}
	}

	
}
