package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_test_Gaaaaaaaaaarden {
	static int rSize, cSize, gNum, rNum, Min = Integer.MIN_VALUE;
	static int[][] arr;
	static act[][] arrCopy;
	static ArrayList<Point> listPoint = new ArrayList<>();
	static ArrayList<Water> listWater = new ArrayList<>();
	static char[] arrChar;
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<ArrayList<Water>> set = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		rSize = Integer.parseInt(token.nextToken());
		cSize = Integer.parseInt(token.nextToken());
		gNum = Integer.parseInt(token.nextToken());
		rNum = Integer.parseInt(token.nextToken());
		arrChar = new char[gNum + rNum];
		for (int i = 0; i < gNum; i++) {
			arrChar[i] = 'G';
		}
		for (int i = gNum; i < rNum + gNum; i++) {
			arrChar[i] = 'R';
		}
		arr = new int[rSize][cSize];
		for (int r = 0; r < rSize; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < cSize; c++) {
				arr[r][c] = Integer.parseInt(token.nextToken());
				if (arr[r][c] == 2) {
					listPoint.add(new Point(r, c));
				}
			}
		}
		makeCombination(gNum + rNum, new Point[gNum + rNum], 0, 0);
		System.out.println(Min);

	}

	static void makeCom(int r, int[] temp, int current, int start, Point[] tempA) {
		if (r == current) {
			listWater = new ArrayList<>();

			for (int i = 0; i < arrChar.length; i++) {
				boolean brak = false;
				for (int a : temp) {
					if (a == i) {
						listWater.add(new Water(tempA[i].r, tempA[i].c, 'G'));
						brak = true;
						break;
					}
				}
				if (!brak) {
					listWater.add(new Water(tempA[i].r, tempA[i].c, 'R'));
				}
			}
			bfsQueue(listWater);

		} else {
			for (int i = start; i < arrChar.length; i++) {
				temp[current] = i;
				makeCom(r, temp, current + 1, i + 1, tempA);
			}
		}
	}

	static void makeCombination(int r, Point[] temp, int current, int start) {
		if (r == current) {
			makeCom(gNum, new int[gNum], 0, 0, temp);
		} else {
			for (int i = start; i < listPoint.size(); i++) {
				temp[current] = listPoint.get(i);
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

	static void bfsQueue(ArrayList<Water> start) {
		int result = 0;
		arrCopy = new act[rSize][cSize];
		for (int r = 0; r < rSize; r++) {
			for (int c = 0; c < cSize; c++) {
				arrCopy[r][c] = new act(arr[r][c], -20);
			}
		}
		int second = -1;
		Queue<Water> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rSize][cSize];
		for (int i = 0; i < start.size(); i++) {
			queue.offer(start.get(i));
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			second++;
			for (int i = 0; i < size; i++) {
				Water top = queue.poll();
				if (visited[top.r][top.c]) {
					if (arrCopy[top.r][top.c].sec == second) {
						if (top.status == 'R' && arrCopy[top.r][top.c].status == -1) {
							arrCopy[top.r][top.c].status = -3; // 꽃이핌 --> -3
							result++;
						}

						if (top.status == 'G' && arrCopy[top.r][top.c].status == -2) {
							arrCopy[top.r][top.c].status = -3; // 꽃이핌 --> -3
							result++;
						}
					}
					continue;
				}
				if (arrCopy[top.r][top.c].status == -3) {
					continue;
				}
				visited[top.r][top.c] = true;
				if (top.status == 'R') {
					arrCopy[top.r][top.c] = new act(-2, second); // red

				} else {
					arrCopy[top.r][top.c] = new act(-1, second); // green
				}
				boolean bb = false;
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc)) {
						if (arrCopy[nr][nc].sec == second - 1) {
							if (top.status == 'R' && arrCopy[nr][nc].status == -1) {
								bb = true;
							}
							if (top.status == 'G' && arrCopy[nr][nc].status == -2) {
								bb = true;
							}

						}
					}
				}
				if (bb) {
					continue;
				}
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc] && arrCopy[nr][nc].status != 0) {
						queue.offer(new Water(nr, nc, top.status));
					}
				}
			}
		}
		if (result > Min) {
			Min = result;
		}
	}

	static class act {
		int status, sec;

		public act(int status, int sec) {
			super();
			this.status = status;
			this.sec = sec;
		}

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < rSize && c < cSize;

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Water {

		Integer r, c;
		char status; // R==red, G==green

		public Water(int r, int c, char status) {
			this.r = r;
			this.c = c;
			this.status = status;
		}

	}
}
