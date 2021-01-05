package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public interface SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			Double sum = (double) 0;
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(token.nextToken());
				sum += num;
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
			sum = sum - min - max;

			System.out.println("#" + t + " " + (int)Math.round((sum / 8)));
		}
	}

}
