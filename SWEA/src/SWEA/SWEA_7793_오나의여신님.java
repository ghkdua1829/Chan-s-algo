package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님 {
	static char[][] arr;
	static int rSize, cSize, result, devilR, devilC, sooR, sooC;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean token =false;
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(tokens.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			tokens = new StringTokenizer(in.readLine(), " ");
			rSize = Integer.parseInt(tokens.nextToken());
			cSize = Integer.parseInt(tokens.nextToken());
			arr = new char[rSize][cSize];
			for (int r = 0; r < rSize; r++) {
				String str = in.readLine();
				for (int c = 0; c < cSize; c++) {
					arr[r][c] = str.charAt(c);
					if (arr[r][c] == '*') {
						list.add(new Point(r,c,1));
					}
					if (arr[r][c] == 'S') {
						sooR = r;
						sooC = c;
					}
				}
			}
			result = 0;
			token = false;
			bfsQueueSooyeon(new Point(sooR, sooC, 1),list);
			if (!token) {
				System.out.println("#" + tc + " GAME OVER");
			} else {
				System.out.println("#" + tc + " " + result);
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < rSize && c < cSize;
	}

	public static void bfsQueueSooyeon(Point sooyeon, List<Point> devil) {
		Queue<Point> queueSoo = new LinkedList<>();
		Queue<Point> queueDevil = new LinkedList<>();

		queueSoo.offer(sooyeon);
		for(int i=0;i<devil.size();i++) {
			queueDevil.offer(devil.get(i));
		}
		while (!queueSoo.isEmpty()) {
			
			int devilSize = queueDevil.size();
			for (int d = 0; d < devilSize; d++) {
				Point devilTop = queueDevil.poll();
				for (int i = 0; i < dirs.length; i++) {
					int nr = devilTop.r + dirs[i][0];
					int nc = devilTop.c + dirs[i][1];
					if (isIn(nr, nc)) {
						if (arr[nr][nc] == '.' || arr[nr][nc] == 'S') {
							arr[nr][nc] = '*';
							queueDevil.offer(new Point(nr, nc, devilTop.depth+1));
						}
					}
				}
			}
			
			int sizeSoo = queueSoo.size();
			for (int s = 0; s < sizeSoo; s++) {
				Point top = queueSoo.poll();
				for (int i = 0; i < dirs.length; i++) {
					int nr = top.r + dirs[i][0];
					int nc = top.c + dirs[i][1];
					if (isIn(nr, nc)) {
						if (arr[nr][nc] == '.') {
							arr[nr][nc] = 'S';
							queueSoo.offer(new Point(nr, nc, top.depth+1));
						} else if (arr[nr][nc] == 'D') {
							result = top.depth;
							token = true;
							return;
						}
					}
				}
			}
		}
	}

	static class Point {
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}

		int r, c, depth;

		public Point(int r, int c, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}
}
