package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_16994_로프와쿼리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String src = br.readLine();
		StringBuilder sb= new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(token.nextToken());
			switch (W) {
			case 1:
			case 2:
				int S = Integer.parseInt(token.nextToken());
				int E = Integer.parseInt(token.nextToken());
				String a = src.substring(0, S );
				String b = src.substring(S, E + 1);
				String c = src.substring(E + 1, src.length());
				if (W == 1) {
					src = b + a + c;
				} else if (W == 2) {
					src = a + c + b;
				}
				break;
			case 3:
				int I = Integer.parseInt(token.nextToken());
				sb.append(src.charAt(I)+"\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
