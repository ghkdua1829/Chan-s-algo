package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class 파일명정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ABCDEFG".substring(0, 5));
		String[] Filesss = { "B001v0dssdf", "B-050 Superfortress", "A-010 Thunderbolt II", "F-14 Tomcat" };
		solution(Filesss);
	}

	static public String[] solution(String[] Filesss) {
		String[] answer = new String[Filesss.length];
		List<FilessOrder> list = new ArrayList<>();
		for (int i = 0; i < Filesss.length; i++) {
			String str = Filesss[i];
			int firstNumberIndex = -1;
			int lastNumberIndex = -1;
			for (int j = 0; j < str.length(); j++) {
				if (Character.isDigit(str.charAt(j))) {
					if (firstNumberIndex == -1) {
						firstNumberIndex = j;
					}
				}
				if (!Character.isDigit(str.charAt(j)) && firstNumberIndex != -1) {
					lastNumberIndex = j;
					break;
				}
			}
			if (lastNumberIndex == -1) {
				lastNumberIndex = str.length();
			}
			if (lastNumberIndex - firstNumberIndex >= 5) {
				lastNumberIndex = firstNumberIndex + 5;
			}
			String head = str.substring(0, firstNumberIndex);

//			head =head.replaceAll("[-. ]", "");
			head = head.toUpperCase();
			String number = str.substring(firstNumberIndex, lastNumberIndex);
			Filess Filess = new Filess(head, number);
			list.add(new FilessOrder(i, Filess));

//			System.out.println(head);
//			System.out.println(number);
		}
		Collections.sort(list, new Comparator<FilessOrder>() {

			@Override
			public int compare(FilessOrder o1, FilessOrder o2) {
				// TODO Auto-generated method stub
				if (o1.Filess.head.compareTo(o2.Filess.head) > 0) {
					return 1;
				} else if (o1.Filess.head.compareTo(o2.Filess.head) < 0) {
					return -1;
				} else {
					if (Integer.parseInt(o1.Filess.number) > Integer.parseInt(o2.Filess.number)) {
						return 1;
					} else if (Integer.parseInt(o1.Filess.number) < Integer.parseInt(o2.Filess.number)) {
						return -1;
					} else {
						if (o1.originalndex > o2.originalndex) {
							return 1;
						} else {
							return -1;
						}
					}
				}

			}

		});
		for (FilessOrder f : list) {
			System.out.println(f);
		}
		for (int i = 0; i < Filesss.length; i++) {
			answer[i] = Filesss[list.get(i).originalndex];
//			System.out.println(answer[i]);
		}
		return answer;
	}

	static class FilessOrder {
		int originalndex;
		Filess Filess;

		public FilessOrder(int originalndex, Filess Filess) {
			super();
			this.originalndex = originalndex;
			this.Filess = Filess;
		}

		@Override
		public String toString() {
			return "FilessOrder [originalndex=" + originalndex + ", Filess=" + Filess + "]";
		}
	}
}

class Filess {
	String head, number;

	public Filess(String head, String number) {
		super();
		this.head = head;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Filess [head=" + head + ", number=" + number + "]";
	}

}
