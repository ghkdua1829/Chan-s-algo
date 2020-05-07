package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_14503_로봇청소기 {
	static int[][] arr;
	static int result;
	static int[] searchR = { 0, -1, 0, 1 };
	static int[] searchC = { -1, 0, 1, 0 };

	static int[] backR = { 1, 0, -1, 0 };
	static int[] backC = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		int rSize = Integer.parseInt(tokens.nextToken());
		int cSize = Integer.parseInt(tokens.nextToken());
		arr = new int[rSize][cSize];

		tokens = new StringTokenizer(in.readLine(), " ");
		int nowRobotR = Integer.parseInt(tokens.nextToken());
		int nowRobotC = Integer.parseInt(tokens.nextToken());
		int nowRobotDir = Integer.parseInt(tokens.nextToken());

		for (int r = 0; r < rSize; r++) {
			tokens = new StringTokenizer(in.readLine(), " ");
			for (int c = 0; c < cSize; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		cleaning(new Point(nowRobotR, nowRobotC, nowRobotDir));
	}

	public static void cleaning(Point start) {

		int R = start.r;
		int C = start.c;
		int Dir = start.dir;

		int stopToken = 0; // 4이고 후진을 할수 없으면 정지
		while (true) {
			if (stopToken == 4 && arr[R + backR[Dir]][C + backC[Dir]] == 1) {
				for(int r=0;r<arr.length;r++) {
					for(int c=0;c<arr[0].length;c++) {
						if(arr[r][c]==2) {
							result++;
						}
					}
				}
				System.out.println(result);
				break;
			} else if (stopToken == 4 && arr[R + backR[Dir]][C + backC[Dir]] == 2) {
				R += backR[Dir];
				C += backC[Dir];
				stopToken = 0;
			}
//			result++;
			arr[R][C] = 2; // 청소한 상태가 2
			for (int s = Dir; s < Dir + 4; s++) {
				int tempR = R + searchR[s % 4];
				int tempC = C + searchC[s % 4];
				if (arr[tempR][tempC] == 0) { //왼쪽 방향이 청소를 안한 지역이라면 
					Dir = (s + 3) % 4;
					R += searchR[s];
					C += searchC[s];
					stopToken = 0;
					break;
				} else { // 왼쪽 방향이 벽 혹은 청소한 지역이라면
					Dir = (s + 3) % 4;
					stopToken++;
					break;
				}
			}
		}
	}

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}
}
