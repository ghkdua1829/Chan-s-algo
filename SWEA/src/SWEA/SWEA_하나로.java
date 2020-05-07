package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_하나로 {
	static int[] root;
	static int[] rank;
	static int[] x;
	static int[] y;

	static List<Point> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			x = new int[N];
			y = new int[N];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(token.nextToken());
			}
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(token.nextToken());
			}

			makeCombination(2, new int[2], 0, 0, x);
			List<Point> plist = new ArrayList<>();

			for (int i = 0; i < list.size(); i++) {
				plist.add(new Point(list.get(i).V1, list.get(i).V2,
						(long) (x[list.get(i).V1] - x[list.get(i).V2]) * (long) (x[list.get(i).V1] - x[list.get(i).V2])
								+ (long) (y[list.get(i).V1] - y[list.get(i).V2])
										* (long) (y[list.get(i).V1] - y[list.get(i).V2])));
			}
			
			plist.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1.value, o2.value);
				}
			});
			root = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				root[i] = i;
			}
			int cnt = 0;
			Long result = 0L;
			for (int i = 0; i < plist.size(); i++) {
				int a = findSet(plist.get(i).V1);
				int b = findSet(plist.get(i).V2);
				if (a == b) {
					continue;
				}
				union(a, b);
				result += plist.get(i).value;

				cnt++;
				if (cnt == N - 1) {
					break;
				}
			}

			double E = Double.parseDouble(br.readLine());
			System.out.println("#" + tc + " " + Math.round(result*E));
		}
	}

	static int findSet(int x) {
		if (x == root[x]) {
			return x;
		} else {
			return root[x] = findSet(root[x]);
		}
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

	static void makeCombination(int r, int[] temp, int current, int start, int[] xy) {
		if (r == current) {
			list.add(new Point(temp[0], temp[1]));
		} else {
			for (int i = start; i < xy.length; i++) {
				temp[current] = i;
				makeCombination(r, temp, current + 1, i + 1, xy);
			}
		}
	}

	static class Point {
		int V1, V2;
		long value;

		public Point(int v1, int v2, long value) {
			super();
			V1 = v1;
			V2 = v2;
			this.value = value;
		}

		public Point(int v1, int v2) {
			super();
			V1 = v1;
			V2 = v2;
		}

	}
}
