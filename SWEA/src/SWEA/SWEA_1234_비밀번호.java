package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1234_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int length = sc.nextInt();
			String[] arr = sc.next().split("");
			List<String> src = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				src.add(arr[i]);
			}
			String token;
			while (true) {
				boolean aa = false;
				for (int i = 0; i < src.size() - 1; i++) {
					if (src.get(i).equals(src.get(i+1))) {
						src.remove(i);
						src.remove(i);
						aa = true;
					}
				}
				if (aa == false) {
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < src.size(); i++) {
				System.out.print(src.get(i));
			}
			System.out.println();
		}
	}

}
