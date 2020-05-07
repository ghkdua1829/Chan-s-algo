package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_암호문2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int size = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				list.add(sc.nextInt());
			}
			int countSecret = sc.nextInt();
			for (int a = 0; a < countSecret; a++) {
				String secretChar = sc.next();
				switch (secretChar) {
				case "I":
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int z = 0; z < y; z++) {
						list.add(x, sc.nextInt());
						x++;
					}
					break;
				case "D":
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					for (int d = 0; d < y1; d++) {
						list.remove(x1);
					}
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int a = 0; a < 10; a++) {
				System.out.print(list.get(a) + " ");
			}
			System.out.println();
		}
	}

}
