package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {

	static int tankR;
	static int tankC;
	static int sizeR;
	static int sizeC;
	static String[][] field;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= count; tc++) {
			String[] str = sc.nextLine().split(" ");
			sizeR = Integer.parseInt(str[0]);
			sizeC = Integer.parseInt(str[1]);
			field = new String[sizeR][sizeC];
			for (int r = 0; r < sizeR; r++) {
				String str2 = sc.nextLine();
				field[r] = str2.split("");
			}
			for (int r = 0; r < sizeR; r++) {
				for (int c = 0; c < sizeC; c++) {
					String f = field[r][c];
					if (f.equals(">") || f.equals("^") || f.equals("v") || f.equals("<")) {
						tankR = r;
						tankC = c;
					}
				}
			}
			int moveNum = Integer.parseInt(sc.nextLine());
			String[] move = sc.nextLine().split("");
			for (int i = 0; i < move.length; i++) {
				String order = move[i];
				switch (order) {
				case "S":
					int rr = tankR;
					int cc = tankC;
					switch (field[rr][cc]) {
					case "^":
						while (isInShoot(--rr, cc) && !field[rr][cc].equals("#")) {
							if (field[rr][cc].equals("*")) {
								field[rr][cc] = ".";
								break;
							}
						}
						break;
					case "v":
						while (isInShoot(++rr, cc) && !field[rr][cc].equals("#")) {
							if (field[rr][cc].equals("*")) {
								field[rr][cc] = ".";
								break;
							}
						}
						break;
					case "<":
						while (isInShoot(rr, --cc) && !field[rr][cc].equals("#")) {
							if (field[rr][cc].equals("*")) {
								field[rr][cc] = ".";
								break;
							}
						}
						break;
					case ">":
						while (isInShoot(rr, ++cc) && !field[rr][cc].equals("#")) {
							if (field[rr][cc].equals("*")) {
								field[rr][cc] = ".";
								break;
							}
						}
						break;
					}
					break;
				case "U":
					field[tankR][tankC] = "^";
					int UR = tankR - 1;
					int UC = tankC;
					if (isIn(UR, UC) && field[UR][UC].equals(".")) {
						field[UR][UC] = "^";
						field[tankR][tankC] = ".";
						tankR = UR;
						tankC = UC;
					}
					break;
				case "D":
					field[tankR][tankC] = "v";
					int DR = tankR + 1;
					int DU = tankC;
					if (isIn(DR, DU) && field[DR][DU].equals(".")) {
						field[DR][DU] = "v";
						field[tankR][tankC] = ".";
						tankR = DR;
						tankC = DU;
					}
					break;
				case "L":
					field[tankR][tankC] = "<";
					int LR = tankR;
					int LC = tankC - 1;
					if (isIn(LR, LC) && field[LR][LC].equals(".")) {
						field[LR][LC] = "<";
						field[tankR][tankC] = ".";
						tankR = LR;
						tankC = LC;
					}
					break;
				case "R":
					field[tankR][tankC] = ">";
					int RR = tankR;
					int LR1 = tankC + 1;
					if (isIn(RR, LR1) && field[RR][LR1].equals(".")) {
						field[RR][LR1] = ">";
						field[tankR][tankC] = ".";
						tankR = RR;
						tankC = LR1;
					}
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int r = 0; r < field.length; r++) {
				for (int c = 0; c < field[r].length; c++) {
					System.out.print(field[r][c]);
				}
				System.out.println();
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < sizeR && c < sizeC && !field[r][c].equals("#") && !field[r][c].equals("-");
	}

	public static boolean isInShoot(int r, int c) {
		return r >= 0 && c >= 0 && r < sizeR && c < sizeC;
	}

}
