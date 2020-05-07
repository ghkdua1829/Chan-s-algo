package SWEA;

import java.util.Scanner;

public class SWEA_사칙연산유효성검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			boolean token = true;
			int count = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < count; i++) {
				String s = sc.nextLine();
				if (token == false) {
					continue;
				}
				String[] splited = s.split(" ");
				String c = splited[1];
				if (splited.length == 4) {
					if (c.equals("/") || c.equals("+") || c.equals("-") || c.equals("*")) {
					} else {
						token = false;
					}
				} else {
					if (c.equals("/") || c.equals("+") || c.equals("-") || c.equals("*")) {
						token = false;
					}
				}
			}
			System.out.print("#" + tc + " " + ((token == true) ? "1" : "0")+"\n");
		}
	}
}
