package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import java.io.BufferedReader;

public class Baekjoon_4485_녹색옷입은애가젤다지 {

	static int[] searchR = { 1, -1, 0, 0 };
	static int[] searchC = { 0, 0, 1, -1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while (true) {
			cnt++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int[][] arr = new int[N][N];
			int[][] D = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(token.nextToken());
					D[r][c] = Integer.MAX_VALUE;
				}
			}
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			D[0][0] = arr[0][0];
			pq.add(new Edge(0, 0, arr[0][0]));
			while (!pq.isEmpty()) {
				Edge e = pq.poll();
				int r = e.r;
				int c = e.c;
				int w = e.weight;
				if (D[r][c] < w) {
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int tempR = searchR[i] + r;
					int tempC = searchC[i] + c;
					if (isIn(tempR, tempC)) {
						if (D[tempR][tempC] > D[r][c] + arr[tempR][tempC]) {
							D[tempR][tempC] = D[r][c] + arr[tempR][tempC];
							pq.add(new Edge(tempR, tempC, D[tempR][tempC]));
						}
					}
				}
			}
			System.out.println("Problem " + cnt + ": " + D[N - 1][N - 1]);
		}
	}

	static class Edge implements Comparable<Edge> {
		int r, c, weight;

		public Edge(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return weight + "";
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
