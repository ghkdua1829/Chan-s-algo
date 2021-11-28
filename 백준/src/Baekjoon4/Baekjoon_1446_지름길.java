package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1446_지름길 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int D = Integer.parseInt(token.nextToken());
		List[] roads = new List[D + 1];
		int[] minLength = new int[D + 1];

		for (int i = 0; i < D + 1; i++) {
			roads[i] = new ArrayList<Road>();
			minLength[i] = i;
		}

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int length = Integer.parseInt(token.nextToken());
			if (start > D) {
				continue;
			}
			roads[start].add(new Road(end, length));
		}

		for (int i = 0; i < D + 1; i++) {
			List<Road> temp = roads[i];
			for (int j = 0; j < temp.size(); j++) {
				int next = temp.get(j).end;
				if (next <= D && minLength[next] >= minLength[i] + temp.get(j).length) {
					minLength[next] = minLength[i] + temp.get(j).length;
				}
			}
			if (i != D) {
				if (minLength[i + 1] >= minLength[i] + 1)
					minLength[i + 1] = minLength[i] + 1;
			}
		}
		System.out.println(minLength[D]);
	}

	static class Road {
		int end, length;

		public Road(int end, int length) {
			super();
			this.end = end;
			this.length = length;
		}

	}
}
