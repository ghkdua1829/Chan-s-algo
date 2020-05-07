package SWEA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < 8; i++) {
				list.add(sc.nextInt());
			}
			boolean breakPoint = false;
			while (true) {
				int minusCount = 1;
				for (int a = 1; a <= 5; a++) {
					int firstVal = list.get(0);
					list.remove(0);
					list.add(firstVal - minusCount);
					if (firstVal - minusCount <= 0) {
						list.set(7, 0);
						breakPoint = true;
						break;
					}
					minusCount++;
				}
				if (breakPoint) {
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int k = 0; k < list.size(); k++) {
				System.out.print(list.get(k) + " ");
			}
			System.out.println();
		}
	}
}