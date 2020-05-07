package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4615_재미있는오셀로게임 {

	static int[] examR = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] examC = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String[][] board = new String[N + 2][N + 2];

			for (String[] arr : board) {
				Arrays.fill(arr, "벽");
			}
			board[N / 2][N / 2] = "W";
			board[N / 2][N / 2 + 1] = "B";
			board[N / 2 + 1][N / 2] = "B";
			board[N / 2 + 1][N / 2 + 1] = "W";
			int putOrder = 2; // 0 이면 B 차례 2 이면 W 차례
			for (int p = 0; p < M; p++) {
				int putC = sc.nextInt(); // 놓는 열
				int putR = sc.nextInt(); // 놓는 행
				int color = sc.nextInt(); // 1이면 B,2면 W
				switch (color) {
				case 1:
					putOrder = 0;
					break;
				case 2:
					putOrder = 2;
					break;
				}
				String find = "";
				String notfind = "";
				switch (putOrder) {
				case 0:		//B 일떄
					find = "W";
					notfind = "B";
					break;
				case 2:		//W 일때
					find = "B";
					notfind = "W";
					break;
				}
//				|| !board[putR + x * examR[e]][putC + x * examC[e]].equals("벽")
				board[putR][putC] = notfind;

				for (int e = 0; e < 8; e++) {

					if (board[putR + examR[e]][putC + examC[e]] == find) {
						int x = 1;
						boolean token = false;
						while(!board[putR + x * examR[e]][putC + x * examC[e]].equals("벽")) {
							if(board[putR + x * examR[e]][putC + x * examC[e]] == notfind) {
								token= true;
							}
							x++;
						}
						x=1;
						if(token==true) {
							while (board[putR + x * examR[e]][putC + x * examC[e]].equals(find)) {
								board[putR + x * examR[e]][putC + x * examC[e]] = notfind;
								x++;
							}
						}

					}
				}
			}
			int white = 0;
			int black = 0;
			for(int r=0;r<board.length;r++) {
				for(int c=0;c<board[0].length;c++) {
					if(board[r][c]=="W") {
						white++;
					}else if(board[r][c]=="B") {
						black++;
					}
				}
			}
			System.out.println("#"+tc+" "+black+" "+white);
		}
	}
}
