package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4366_정식이의은행업무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String two = br.readLine();
			String three = br.readLine();
			int[] arrTwo = new int[two.length()];
			int[] arrThree = new int[three.length() * 2];
			int twoCnt = 0;
			int threeCnt = 0;
			for (int i = 0; i < two.length(); i++) {
				String str = "";
				if (two.charAt(i) == '0') {
					str = two.substring(0, i) + "1" + two.substring(i + 1, two.length());
				} else {
					str = two.substring(0, i) + "0" + two.substring(i + 1, two.length());

				}
				arrTwo[twoCnt++] = Integer.parseInt(str, 2);

			}
			for (int i = 0; i < three.length(); i++) {
				String str1 = "";
				String str2 = "";

				if (three.charAt(i) == '0') {
					str1 = three.substring(0, i) + "1" + three.substring(i + 1, three.length());
					str2 = three.substring(0, i) + "2" + three.substring(i + 1, three.length());
				} else if (three.charAt(i) == '1') {
					str1 = three.substring(0, i) + "0" + three.substring(i + 1, three.length());
					str2 = three.substring(0, i) + "2" + three.substring(i + 1, three.length());
				} else if (three.charAt(i) == '2') {
					str1 = three.substring(0, i) + "1" + three.substring(i + 1, three.length());
					str2 = three.substring(0, i) + "0" + three.substring(i + 1, three.length());
				}
				arrThree[threeCnt++] = Integer.parseInt(str1, 3);
				arrThree[threeCnt++] = Integer.parseInt(str2, 3);
			}
			int result = 0;
			for (int i = 0; i < arrTwo.length; i++) {
				for (int j = 0; j < arrThree.length; j++) {
					if (arrTwo[i] == arrThree[j]) {
						result = arrTwo[i];
						i=arrTwo.length;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
