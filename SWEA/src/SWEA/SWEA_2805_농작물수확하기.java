package SWEA;

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int count=sc.nextInt();
		for(int tc=1;tc<=count;tc++) {
			int size = sc.nextInt();
			String[][] farm = new String[size][size];
			int sum=0;
			for(int r=0;r<size;r++) {
				String src = sc.next();
				farm[r]=src.split("");
			}
			for(int r=0;r<size;r++) {
				for(int c=Math.abs(r-(size/2));c<size-(Math.abs(size/2-r));c++) {
					sum+=Integer.parseInt(farm[r][c]);
				}
			}
			System.out.println("#"+tc+" "+sum);

		}
	}
	
}
