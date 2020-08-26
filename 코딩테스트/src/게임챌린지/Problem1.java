package 게임챌린지;

public class Problem1 {

	static int[][] search = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] copy;

	public static void main(String[] args) {
		int[][] board = { { 1, 1, 4, 3 }, { 3, 2, 1, 4 }, { 3, 1, 4, 2 }, { 2, 1, 3, 3 } };
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		int answer = 0;

		copy = new int[board.length][board[0].length];

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				for (int s = 0; s < search.length; s++) {
					int nr = r + search[s][0];
					int nc = c + search[s][1];
					if (isIn(nr, nc)) {

						int temp = board[nr][nc];
						board[nr][nc] = board[r][c];
						board[r][c] = temp;
						if (insepect(board)) {
//							System.out.println(r+","+c);
//							System.out.println(nr+","+nc);
//							System.out.println();
							answer++;
						}
						board[r][c] = board[nr][nc];
						board[nr][nc] = temp;
					}
				}
			}
		}
		if (answer == 0) {
			return -1;
		}

		return answer / 2;
	}

	static boolean insepect(int[][] board) {
		int beforeNum = -1;
		int continuity = 0;
		for (int r = 0; r < board.length; r++) {
			beforeNum = -1;
			continuity = 0;
			for (int c = 0; c < board[0].length; c++) {
				if (beforeNum != board[r][c]) {
					beforeNum = board[r][c];
					continuity = 1;
				} else {
					continuity++;
				}
				if (continuity >= 3) {
					return true;
				}
			}
		}

		for (int c = 0; c < board[0].length; c++) {
			beforeNum = -1;
			continuity = 0;
			for (int r = 0; r < board.length; r++) {
				if (beforeNum != board[r][c]) {
					beforeNum = board[r][c];
					continuity = 1;
				} else {
					continuity++;
				}
				if (continuity >= 3) {
					return true;
				}
			}
		}

		return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < copy.length && c < copy[0].length;
	}

}
