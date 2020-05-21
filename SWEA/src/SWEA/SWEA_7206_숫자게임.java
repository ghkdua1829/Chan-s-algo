package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7206_숫자게임 {
	static String num;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			num = br.readLine();
			max = 0;
//			int cnt = splitNum(num);
			if (num.length() == 1) {
				System.out.println("#" + tc + " 0");
				continue;
			}
			for (int i = 1; i < num.length(); i++) {
				makeCombination(i, new int[i], 0, 0, 0,num);
			}
			System.out.println("#" + tc + " "+max);
		}
	}

	static void makeCombination(int r, int[] temp, int start, int current, int cnt, String tempN) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int startIdx = 0;
			int tempSum = 1;
			for (int i = 0; i < temp.length; i++) {
				int endIdx = temp[i] + 1;
				tempSum *= Integer.parseInt(tempN.substring(startIdx, endIdx));
				startIdx = endIdx;

			}
			tempSum *= Integer.parseInt(tempN.substring(startIdx, tempN.length()));
			cnt++;
			String strSum = String.valueOf(tempSum);
//			System.out.println(strSum+" : "+strSum.length());
			if (strSum.length() == 1) {
				max = Math.max(max, cnt);
			} else {
				for (int i = 1; i < strSum.length(); i++) {
					makeCombination(i, new int[i], 0, 0, cnt, strSum);
				}
			}
		} else {
			for (int i = start; i < tempN.length() - 1; i++) {
				temp[current] = i;
				makeCombination(r, temp, i + 1, current + 1, cnt, tempN);
			}
		}
	}

	private static int splitNum(int num) {

		return 0;
	}

}
