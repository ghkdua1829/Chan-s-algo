package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1986_지그재그숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			int result = 0;
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0) {
					result -= i;
				} else {
					result += i;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
