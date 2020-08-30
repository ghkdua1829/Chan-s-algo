package 브랜디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class problem1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int maxBreath = 220 - N;
		while(true) {
			String b = br.readLine();
			if(b=="") {
				break;
			}
			int breath = Integer.parseInt(b);
			double bak = (double) breath / (double) maxBreath;
//			System.out.println(bak);
			if (bak < 60) {
				arr[0]++;
			} else if (bak < 68) {
				arr[1]++;
			} else if (bak < 75) {
				arr[2]++;
			} else if (bak < 80) {
				arr[3]++;
			} else if (bak < 90) {
				arr[4]++;
			} else {
				arr[5]++;
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
