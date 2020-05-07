package Baekjoon;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Baekjoon_7785_회사에있는사람 {
	static Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	});

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int count = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < count; i++) {
			String[] str = sc.nextLine().split(" ");
			String name = str[0];
			String go = str[1];
			if (go.equals("enter")) {
				map.put(name, go);
			} else {
				map.remove(name);
			}
		}
		Iterator<String> keys = map.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			sb.append(key + "\n");
		}

		System.out.println(sb);
	}

	static class Person {
		String name, go;

		public Person(String name, String go) {
			this.name = name;
			this.go = go;
		}

	}
}
