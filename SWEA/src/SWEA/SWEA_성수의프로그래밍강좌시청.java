package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class SWEA_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			double result = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(token.nextToken());
			int M =Integer.parseInt(token.nextToken());
			Double[] arr = new Double[N];
			token  = new StringTokenizer(br.readLine());
			for(int n=0;n<N;n++) {
				arr[n]= Double.parseDouble(token.nextToken());
			}
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i=M-1;i>=0;i--) {
				result = (result+arr[i])/2;
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
