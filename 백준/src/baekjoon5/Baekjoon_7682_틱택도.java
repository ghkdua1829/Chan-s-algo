package baekjoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_7682_틱택도 {
	static int XCnt = 0;
	static int OCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str.equals("end")) {
				break;
			}
			char[][] board = new char[3][3];
			int t = 0;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					board[r][c] = str.charAt(t++);
					if (board[r][c] == 'X') {
						XCnt++;
					} else if (board[r][c] == 'O') {
						OCnt++;
					}

				}
			}
			System.out.println(getValid(board));

			XCnt = 0;
			OCnt = 0;
		}
	}

	public static String getValid(char[][] board) {
		int XbingoCnt = 0;
		int ObingoCnt = 0;
		char bingoWin = ' ';

		// 가로 빙고 찾기
		for (int r = 0; r < 3; r++) {
			boolean isDiff = false;
			for (int c = 0; c < 2; c++) {
				if (board[r][c] != board[r][c + 1]) {
					isDiff = true;
				}
			}
			if (!isDiff) {
				// 가로빙고
				if (board[r][0] != '.') {
					if (board[r][0] == 'X')
						XbingoCnt++;
					else
						ObingoCnt++;
					bingoWin = board[r][0];
				}
			}
		}

		// 세로 빙고 찾기
		for (int c = 0; c < 3; c++) {
			boolean isDiff = false;
			for (int r = 0; r < 2; r++) {
				if (board[r][c] != board[r + 1][c]) {
					isDiff = true;
				}
			}
			if (!isDiff) {
				// 세로빙고
				if (board[0][c] != '.') {
					if (board[0][c] == 'X')
						XbingoCnt++;
					else
						ObingoCnt++;
					bingoWin = board[0][c];
				}
			}
		}
		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != '.') {
			if (board[1][1] == 'X')
				XbingoCnt++;
			else
				ObingoCnt++;
			bingoWin = board[1][1];
		}
//		System.out.println(bingoCnt + " " + XCnt + " " + OCnt);
		if (XbingoCnt > 0) {
			if (ObingoCnt > 0) {
				return "invalid";
			}
			if(XCnt - OCnt ==1) {
				return "valid";
			}else {
				return "invalid";
			}
		}
		if (ObingoCnt > 0) {
			if (XCnt - OCnt == 0) {
				return "valid";
			}else {
				return "invalid";
			}
		}
		if (XCnt + OCnt == 9 && XCnt-OCnt ==1 ) {
			return "valid";
		}

		return "invalid";
	}
}
