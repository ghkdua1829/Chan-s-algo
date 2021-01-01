package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1926_간단한369게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= num; i++) {
			String number = String.valueOf(i);
			int count = 0;
			for (int s = 0; s < number.length(); s++) {
				int n = number.charAt(s) - '0';
				if(n==0) {
					continue;
				}
				if (n % 3 == 0) {
					count++;
				}
			}
			if (count > 0) {
				for (int c = 0; c < count; c++) {
					sb.append("-");
				}
				sb.append(" ");
			} else {
				sb.append(number + " ");
			}
		}
		System.out.println(sb.toString().trim());
	}

}
