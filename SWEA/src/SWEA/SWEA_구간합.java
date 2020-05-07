package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());

			for (int i = start; i <= end; i++) {
				String str = Integer.toString(i);
				for (int s = 0; s < str.length(); s++) {
					sum += (int) str.charAt(s)-48;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}

}
