package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 김찬영
 * @since 2020. 1. 31.
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE
 * @mem 26,512 kb
 * @time 132 ms
 * @caution 네모를 만들고 윗부분 삼각형(반 윗부분)을 0으로 채우고 나머지들은 숫자로 채운뒤 더해서 삼각형을 만듬.
 */

public class SWEA_2005_파스칼의삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int triangleSize = sc.nextInt();
			int[][] triangle = new int[triangleSize][triangleSize];
			for (int[] row : triangle) {
				Arrays.fill(row, 1); // 1로 가득 채우기
			}
			for (int r = 0; r < triangleSize; r++) {
				for (int c = r + 1; c < triangleSize; c++) {
					triangle[r][c] = 0; // 0으로 채우기 (반 윗부분)
				}
			}
			for (int i = 1; i < triangleSize; i++) {
				for (int j = 1; j < triangleSize; j++) {
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}

			System.out.println("#" + tc);

			for (int i = 0; i < triangleSize; i++) {
				for (int j = 0; j < triangleSize; j++) {
					if (triangle[i][j] != 0) {
						System.out.print(triangle[i][j] + " ");
					}
				}
				System.out.println();
			}

		}
	}

}
