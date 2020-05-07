package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1780_종이의개수 {
	static int[][] arr;
	static int r1,r2,r3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		arr = new int[size][size];
		for (int r = 0; r < size; r++) {
			String[] s= sc.nextLine().split(" ");
			for(int a=0;a<s.length;a++) {
				arr[r][a]=Integer.parseInt(s[a]);
			}
		}
		findOut(arr,size);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}

	public static void findOut(int[][] temp, int size) {
		boolean token = false;
		if (size == 1) {
			switch(temp[0][0]) {
			case -1:
				r1++;
				break;
			case 0:
				r2++;
				break;
			case 1:
				r3++;
				break;
			}
		} else {
			int a = temp[0][0];
			outer :for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if(a!=(temp[r][c])) {
						token = true;
						break outer;
					}
				}
			}
			if(!token) {
				switch(temp[0][0]) {
				case -1:
					r1++;
					break;
				case 0:
					r2++;
					break;
				case 1:
					r3++;
					break;
				}
				return;
			}else {
				for (int r = 0; r < size; r += size / 3) {
					for (int c = 0; c < size; c += size / 3) {
						int[][] acc = new int[size/3][size/3];
						int tempR=0;
						for(int tr=0;tr<size/3;tr++) {
							int tempC=0;
							for(int tc=0;tc<size/3;tc++) {
								acc[tr][tc]=temp[r+tempR][c+tempC];
								tempC++;
							}
							tempR++;
						}
						findOut(acc,size/3);
					}
				}
			}
		}
	}
}
