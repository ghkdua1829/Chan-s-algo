package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1717_집합의표현 {
	static int n, m;
	static int[] root, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		root = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			root[i] = i;
			rank[i] = 0;
		}
		for (int tc = 0; tc < m; tc++) {
			token = new StringTokenizer(br.readLine());
			int io = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			if (io == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	static int find(int s) {
		if (s == root[s]) {
			return s;
		} else {
			return root[s] = find(root[s]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (rank[x] < rank[y]) {
			root[x] = y;
		} else {
			root[y] = x;
		}
		
		if(rank[x]==rank[y]) {
			rank[x]++;
		}

	}
}
