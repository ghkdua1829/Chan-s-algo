package SWEA;

import java.util.Scanner;

public class SWEA_1948_날짜계산기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			int[] days = new int[2];
			for (int i = 0; i < 2; i++) {
				int month = sc.nextInt();
				int day = sc.nextInt();
				switch (month) {
				case 12:
					days[i] += 30;
				case 11:
					days[i] += 31;
				case 10:
					days[i] += 30;
				case 9:
					days[i] += 31;
				case 8:
					days[i] += 31;
				case 7:
					days[i] += 30;
				case 6:
					days[i] += 31;
				case 5:
					days[i] += 30;
				case 4:
					days[i] += 31;
				case 3:
					days[i] += 28;
				case 2:
					days[i] += 31;
				}
				days[i] += day;
			}
			int result = days[1] - days[0];
			System.out.println("#" + tc + " " + (result+1));
		}
	}
}
