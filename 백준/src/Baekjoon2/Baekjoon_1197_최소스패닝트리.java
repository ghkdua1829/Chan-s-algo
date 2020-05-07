package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_1197_최소스패닝트리 {
	static int[] root;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		int[][] edge = new int[E][3];
		root = new int[V];
		for (int i = 0; i < root.length; i++) {
			root[i] = i;
		}
		rank = new int[V];
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			int C = Integer.parseInt(token.nextToken());
			edge[i][0] = A-1;
			edge[i][1] = B-1;
			edge[i][2] = C;
		}
		Arrays.sort(edge, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
//		for (int i = 0; i < edge.length; i++) {
//			System.out.println(edge[i][2]);
//		}
		int result = 0;
		for (int i = 0; i < edge.length; i++) {
			int x = findSet(edge[i][0]);
			int y = findSet(edge[i][1]);
			if (x == y) {
				continue;
			}
			union(x, y);
			result += edge[i][2];
		}
		System.out.println(result);
	}

	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (rank[x] > rank[y]) {
			root[y] = x;
		} else {
			root[x] = y;
			if (rank[x] == rank[y]) {
				rank[y]++;
			}
		}
	}

	static int findSet(int x) {
		if (x == root[x]) {
			return x;
		} else {
			return root[x] = findSet(root[x]);
		}
	}
}
