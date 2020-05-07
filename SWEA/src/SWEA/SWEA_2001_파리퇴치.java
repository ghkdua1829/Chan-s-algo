package SWEA;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int tc=1;tc<=count;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] fly = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					fly[r][c] = sc.nextInt();
				}
			}
			int max = 0;
			for(int r=0;r<=N-M;r++) {
				for(int c=0;c<=N-M;c++) {
					int sum=0;
					for(int i=r;i<r+M;i++) {
						for(int j=c;j<c+M;j++) {
							sum+=fly[i][j];
						}
					}
					if(sum>max) {
						max=sum;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
