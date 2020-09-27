package 네이버;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		int[][] blocks = { { 0, 50 }, { 0, 22 }, { 2, 10 }, { 1, 4 }, { 4, -13 } };
		solution(blocks);
	}

	static public int[] solution(int[][] blocks) {
		int[] answer = {};
		int size = blocks.length;
		int[][] board = new int[size][size];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = Integer.MAX_VALUE;
			}
		}
		for (int r = 0; r < blocks.length; r++) {
			int idx = blocks[r][0];
			int value = blocks[r][1];
			board[r][idx] = value;
		}
		for (int r = 1; r < board.length; r++) {
			for (int c = 0; c <= r; c++) {
				if (board[r][c] != Integer.MAX_VALUE) {
					int tempC = c;
					for (int t = tempC; t <= r; t++) { // 그자리에서 뒤로 가서 더한다.
						if (isIn(r, t + 1)) {
							int upValue = board[r - 1][t];
							board[r][t + 1] = upValue - board[r][t];
						}
					}
					for (int t = tempC; t >= 0; t--) { // 그자리에서 앞으로 가서 더한다.
						if (isIn(r, t - 1)) {
							int upValue = board[r - 1][t - 1];
							board[r][t - 1] = upValue - board[r][t];
						}
					}
				}
			}
		}
		for (int[] r : board) {
			System.out.println(Arrays.toString(r));
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != Integer.MAX_VALUE) {
					list.add(board[r][c]);
				}
			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	static boolean isIn(int r, int c) {
		return c >= 0 && c <= r;
	}
}
