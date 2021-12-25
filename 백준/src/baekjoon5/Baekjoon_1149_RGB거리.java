package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1149_RGB거리 {
	static int[][] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		house = new int[N + 1][3];
		for (int t = 1; t < N + 1; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(token.nextToken());
			int G = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			house[t][0] = Math.min(house[t - 1][1], house[t - 1][2]) + R;
			house[t][1] = Math.min(house[t - 1][0], house[t - 1][2]) + G;
			house[t][2] = Math.min(house[t - 1][0], house[t - 1][1]) + B;
		}
		System.out.println(Math.min(house[N][0], Math.min(house[N][1], house[N][2])));
	}

}
