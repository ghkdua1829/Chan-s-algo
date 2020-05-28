package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_16235_나무재테크 {
	static int N, M, K, result;
	static int[][] A;
	static int[][] yang;
	static List<Integer>[][] tree;
	static List<Integer>[][] die;
	static int[][] search = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		A = new int[N][N];
		yang = new int[N][N];
		tree = new List[N][N];
		die = new List[N][N];

		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				tree[r][c] = new ArrayList<Integer>();
				yang[r][c] = 5;
				die[r][c] = new ArrayList<Integer>();
				A[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken()) - 1;
			int y = Integer.parseInt(token.nextToken()) - 1;
			int z = Integer.parseInt(token.nextToken());
			tree[y][x].add(z);
		}
		int year = 0;
		while (true) {
			year++;
			// 봄
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					Collections.sort(tree[r][c]);
					for (int t = 0; t < tree[r][c].size(); t++) {
						int age = tree[r][c].get(t);
						if (yang[r][c] >= age) {
							yang[r][c] -= age;
							tree[r][c].set(t, age + 1);
						} else {
							tree[r][c].remove(t);
							t--;
							die[r][c].add(age);
						}
					}
				}
			}

			// 여름
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < die[r][c].size(); d++) {
						int age = die[r][c].get(d);
						die[r][c].remove(d);
						d--;
						yang[r][c] += age / 2;
					}
				}
			}

			// 가을
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int t = 0; t < tree[r][c].size(); t++) {
						int age = tree[r][c].get(t);
						if (age % 5 == 0) {
							for (int s = 0; s < search.length; s++) {
								int nr = r + search[s][0];
								int nc = c + search[s][1];
								if (isIn(nr, nc)) {
									tree[nr][nc].add(1);
								}
							}
						}
					}
				}
			}
			int cnt = 0;
			// 겨울
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cnt += tree[r][c].size();
					yang[r][c] += A[c][r];
				}
			}
			if (year == K) {
				result = cnt;
				break;
			}
		}
		System.out.println(result);
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Point {
		int age, yang;

		public Point(int age, int yang) {
			super();
			this.age = age;
			this.yang = yang;
		}

	}

}
