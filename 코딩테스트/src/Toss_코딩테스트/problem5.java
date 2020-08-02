package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem5 {
	static Long result = 0L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] split = input.split(",");
		int n = Integer.parseInt(split[0].trim());
		int m = Integer.parseInt(split[1].trim());
		int k = Integer.parseInt(split[2].trim());

		makeCombination(n, new int[n], 0, 0, n+m,k);

		System.out.println("총 " + result + "가지");
	}


	static void makeCombination(int r, int[] temp, int current, int start, int size,int k) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			int[] arr= new int[size];
			for(int i=0;i<temp.length;i++) {
				arr[temp[i]]= 1;
			}
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==1) {
					k+=1;
				}else {
					k-=1;
					if(k<0) {
						return;
					}
				}
			}
			result++;
			
		} else {
			for (int i = start; i < size; i++) {
				temp[current] = i;
				makeCombination(r, temp, current + 1, i + 1, size,k);
			}
		}
	}

}
