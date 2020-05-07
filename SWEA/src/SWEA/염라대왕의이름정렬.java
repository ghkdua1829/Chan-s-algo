package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 염라대왕의이름정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(bf.readLine());

			String[] arr = new String[num];
			for (int i = 0; i < num; i++) {
				arr[i] = bf.readLine();
			}
			Arrays.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Integer l1 = o1.length();
					Integer l2 = o2.length();
					if (l1 == l2) {
						return o1.compareTo(o2);
					} else {
						return l1.compareTo(l2);
					}
				}

			});
			sb.append("#" + tc + " \n");
			String before = "-1";
			for (int i = 0; i < arr.length; i++) {
				if (!before.equals(arr[i])) {
					sb.append(arr[i]+"\n");
				}
				before = arr[i];
			}
			System.out.print(sb);
		}
	}

}
