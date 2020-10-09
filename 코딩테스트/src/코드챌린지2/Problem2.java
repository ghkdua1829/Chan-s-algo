package 코드챌린지2;

public class Problem2 {
	static int oneCnt = 0, zeroCnt = 0;

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		solution(arr);
	}

	static public int[] solution(int[][] arr) {
		int[] answer = {};
		answer = new int[2];
		sliceSquare(arr);
		System.out.println(oneCnt);
		System.out.println(zeroCnt);
		answer[0] =zeroCnt;
		answer[1] =oneCnt;
		return answer;
	}

	static void sliceSquare(int[][] square) {
		int num = square[0][0];
		boolean same = true;
		for (int r = 0; r < square.length; r++) {
			for (int c = 0; c < square[r].length; c++) {
				if (num != square[r][c]) {
					same = false;
					r = square.length;
					break;
				}
			}
		}
		if (same) {
			if (num == 0) {
				zeroCnt++;
			} else {
				oneCnt++;
			}
			return;
		}
		if (square.length != 1) {
			int[][] temp = new int[square.length / 2][square[0].length / 2];
			for (int r = 0; r < temp.length; r++) {
				for (int c = 0; c < temp[0].length; c++) {
					temp[r][c] = square[r][c];
				}
			}
			sliceSquare(temp);

			temp = new int[square.length / 2][square[0].length / 2];
			for (int r = temp.length, rr = 0; r < square.length; r++, rr++) {
				for (int c = 0; c < temp[0].length; c++) {
					temp[rr][c] = square[r][c];
				}
			}
			sliceSquare(temp);

			temp = new int[square.length / 2][square[0].length / 2];
			for (int r = 0; r < temp.length; r++) {
				for (int c = temp[0].length,cc=0; c < square[0].length; c++,cc++) {
					temp[r][cc] = square[r][c];
				}
			}
			sliceSquare(temp);

			temp = new int[square.length / 2][square[0].length / 2];
			for (int r = temp.length, rr = 0; r < square.length; r++, rr++) {
				for (int c = temp[0].length,cc=0; c < square[0].length; c++,cc++) {
					temp[rr][cc] = square[r][c];
				}
			}
			sliceSquare(temp);
		}

	}

}
