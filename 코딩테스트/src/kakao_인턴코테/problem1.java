package kakao_인턴코테;

import java.util.LinkedList;
import java.util.Queue;

public class problem1 {
	static char[][] pad = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
	static int[][] search = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand ="right";
		System.out.println(solution(numbers, hand));
	}

	static public String solution(int[] numbers, String hand) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		Point leftHand = new Point(3, 0);
		Point rightHand = new Point(3, 2);

		for (int i = 0; i < numbers.length; i++) {
			int pushNum = numbers[i];
			int pushR = 0;
			int pushC = 0;
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 3; c++) {
					if (pushNum == pad[r][c] - 48) {
						pushR = r;
						pushC = c;
						c = 3;
						r = 4;
					}
				}
			}
			if (pushC == 0) {
				sb.append("L");
				leftHand.r = pushR;
				leftHand.c = pushC;
			} else if (pushC == 2) {
				sb.append("R");
				rightHand.r = pushR;
				rightHand.c = pushC;
			} else {

				int rightStreet = Math.abs(pushR-rightHand.r)+Math.abs(pushC-rightHand.c);
				int leftStreet = Math.abs(pushR-leftHand.r)+Math.abs(pushC-leftHand.c);
				
				if (rightStreet > leftStreet) {
					sb.append("L");
					leftHand.r = pushR;
					leftHand.c = pushC;
				} else if (rightStreet < leftStreet) {
					sb.append("R");
					rightHand.r = pushR;
					rightHand.c = pushC;
				} else {
					if (hand.equals("right")) {
						sb.append("R");
						rightHand.r = pushR;
						rightHand.c = pushC;
					} else {
						sb.append("L");
						leftHand.r = pushR;
						leftHand.c = pushC;
					}
				}
			}
		}
		answer = sb.toString();
		return answer;
	}

	private static int bfs(Point Hand, Point pushPad) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[3][4];
		queue.offer(Hand);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				Point top = queue.poll();
				if (top.r == pushPad.r && top.c == pushPad.c) {
					return cnt;
				}
				if (visited[top.r][top.c]) {
					continue;
				}
				for (int s = 0; s < search.length; s++) {
					int nr = top.r + search[s][0];
					int nc = top.c + search[s][1];
					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < 3 && c < 4;
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
