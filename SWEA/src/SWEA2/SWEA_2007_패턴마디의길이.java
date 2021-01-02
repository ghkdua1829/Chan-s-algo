package SWEA2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007_패턴마디의길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			int result = 0;
			for (int i = 10; i >= 1; i--) {
				String str1 = str.substring(0, i);
				String str2 = str.substring(i, 2 * i );
				if (str1.equals(str2)) {
					result = i;
				}

			}

			System.out.println("#" + t + " "+result);
		}
	}

}
