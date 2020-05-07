package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			Set<String> set = new HashSet<String>();
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			String nums = br.readLine();

			int bun = N / 4;
			int start = 0;
			int end = bun;
			for (int i = 0; i < bun; i++) {
				for (int j = 0; j < N; j += bun) {
					sb = new StringBuilder();
					for (int k = start + j; k < end + j; k++) {
//						System.out.print(nums.charAt((k >= N) ? k % N : k));
						sb.append(nums.charAt((k >= N) ? k % N : k));
					}
					set.add(sb.toString());
//					System.out.println();
				}
//				System.out.println();
//				start = (start - 1 < 0) ? N - 1 : start--;
				start++;
				end++;

			}
			Integer[] arr = new Integer[set.size()];
			Iterator<String> iter = set.iterator();
			int i =0;
			while(iter.hasNext()) {
				arr[i++] = Integer.parseInt(iter.next(),16);
			}
			Arrays.sort(arr,Collections.reverseOrder());
			System.out.println("#" + tc + " "+arr[K-1]);
		}
	}

}
