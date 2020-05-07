package SWEA;

import java.util.Scanner;

public class SWEA_1220_Magnetic {

	static int[][] arr = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int num = sc.nextInt();
			arr = new int[100][100];
			int answer = 0;
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			boolean tokenN = false;
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					if (arr[r][c] == 1) {
						tokenN = true;
					}
					if (tokenN == true && arr[r][c] == 2) {
						answer++;
						tokenN = false;
					}
				}
				tokenN =false;
			}
			System.out.println("#" + i + " " + answer);
		}

	}

}
