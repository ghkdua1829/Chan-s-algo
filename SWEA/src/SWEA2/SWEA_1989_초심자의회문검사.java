package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989_초심자의회문검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int s = str.length() - 1; s >= 0; s--) {
				sb.append(str.charAt(s));
			}
			int result = 0;
			if (str.equals(sb.toString())) {
				result = 1;
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
