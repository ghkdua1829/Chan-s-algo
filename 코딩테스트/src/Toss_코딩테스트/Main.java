package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		int idx = 100;
		String[] hexs = new String[101];
		for (double i = 1; i >= 0; i -= 0.01) {

			i = Math.round(i * 100) / 100.0d;
			int rounded = (int) Math.round(i * 255);
			String hex = Integer.toHexString(rounded).toUpperCase();

			if (hex.length() == 1)
				hex = "0" + hex;

			int percent = (int) (i * 100);

			hexs[idx] = hex;
			idx--;
			System.out.println(String.format("%d%% — %s", percent, hex));
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(",");
		StringBuilder sb= new StringBuilder();
		sb.append("#").append(hexs[Integer.parseInt(str[1])]).append(str[0].substring(1));
		System.out.println(sb.toString());
	}
}
