package KAKAOBLIND2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
	static Map<String, Integer> tempMap;
	static List<String> result = new ArrayList<String>();
	static List<Cook> list = new ArrayList<>();


	static public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		for (int c = 0; c < course.length; c++) {
			int courseAmount = course[c];
			tempMap = new HashMap<String, Integer>();
			for (int i = 0; i < orders.length; i++) {
				String str = orders[i];
				makeCombination(courseAmount, new char[courseAmount], 0, 0, str);
			}
			int big = -1;
			for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
				System.out.println("key : " + entry.getKey() + " , value : " + entry.getValue());
				big = Math.max(big, entry.getValue());

			}
			for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
//				System.out.println("key : " + entry.getKey() + " , value : " + entry.getValue());
				if(big==entry.getValue() && entry.getValue()>=2) {
					result.add(entry.getKey());
					System.out.println("key : " + entry.getKey() + " , value : " + entry.getValue());
				}

			}
		}
//		System.out.println(result.size());
		answer = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			answer[i] = result.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}

	static void makeCombination(int r, char[] temp, int current, int start, String str) {
		if (r == current) {
			char[] tt = new char[temp.length];
			for(int i=0;i<temp.length;i++) {
				tt[i]= temp[i];
			}
			Arrays.sort(tt);
			String course = String.valueOf(tt);
//			System.out.println(course);
			if (tempMap.containsKey(course)) {
				tempMap.put(course, tempMap.get(course) + 1);
			} else {
				tempMap.put(course, 1);
			}
		} else {
			for (int i = start; i < str.length(); i++) {
				temp[current] = str.charAt(i);
				makeCombination(r, temp, current + 1, i + 1, str);
			}
		}
	}

	static class Cook {
		String course;
		int value;

		public Cook(String course, int value) {
			super();
			this.course = course;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Cook [course=" + course + ", value=" + value + "]";
		}

	}
}
