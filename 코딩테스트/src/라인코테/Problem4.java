package 라인코테;

public class Problem4 {
	static int[][] search = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N;

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		solution(maze);

	}

	static public int solution(int[][] maze) {
		int answer = 0;
		N = maze.length;
		int dir = 0;
		if (maze[0][1] == 1) { // 밑을 보고 간다.
			dir = 0;
		} else { // 오른쪽을 먼저본다.
			dir = 1;
		}
		int r = 0;
		int c = 0;
		int time = 0;
		while (true) {
			if (r == N - 1 && c == N - 1) {
				answer = time;
				break;
			} else {
				int leftR = r + search[(dir + 1) % 4][0];
				int leftC = c + search[(dir + 1) % 4][1];
				if (!isIn(leftR, leftC) || maze[leftR][leftC] == 1) { // 왼쪽 손 부분이 막혀있을때 그대로간다.
					
				} else {
					dir = (dir + 1) % 4;
				}
				r += search[(dir) % 4][0];
				c += search[(dir) % 4][1];
				if(!isIn(r, c) || maze[r][c]==1) {
					r -= search[(dir) % 4][0];
					c -= search[(dir) % 4][1];
					for (int i = 1; i < 4; i++) {
						int tempDir = (4 + dir - i) % 4;
						int nr = r+search[tempDir][0];
						int nc = c+search[tempDir][1];
						if(isIn(nr, nc) && maze[nr][nc]!=1) {
							r = nr;
							c = nc;
							dir =tempDir;
							break;
						}
					}
				}
				time++;
			}
		}
		System.out.println(time);
		return answer;
	}

	static boolean isIn(int r, int c) {
		return c >= 0 && r >= 0 && r < N && c < N;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}
}
