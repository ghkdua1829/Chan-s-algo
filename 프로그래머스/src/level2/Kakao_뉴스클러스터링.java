package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Kakao_뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("ab_", "abc_"));
	}

	static public int solution(String str1, String str2) {
		int answer = 0;
		String str1Up = str1.toUpperCase();
		String str2Up = str2.toUpperCase();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
//		List<String> gyo = new ArrayList<String>();
//		List<String> hap = new ArrayList<String>();
		Map<String, Integer> map1 = new HashMap();
		Map<String, Integer> map2 = new HashMap();
		Set<String> set = new HashSet<String>();

		for (int i = 0; i < str1Up.length() - 1; i++) {
			String temp1 = str1Up.substring(i, i + 2);
			if ((temp1.charAt(0) >= 65 && temp1.charAt(0) <= 90 )
					&& (temp1.charAt(1) >= 65 && temp1.charAt(1) <= 90)) {
				list1.add(temp1);
				set.add(temp1);
			}

		}

		for (int i = 0; i < str2Up.length() - 1; i++) {
			String temp2 = str2Up.substring(i, i + 2);
			if ((temp2.charAt(0) >= 65 && temp2.charAt(0) <= 90)
					&& (temp2.charAt(1) >= 65 && temp2.charAt(1) <= 90)) {
				list2.add(temp2);
				set.add(temp2);
			}
		}
		
//		for(String str:list2) {
//			System.out.println(str);
//		}

		for (int i = 0; i < list1.size(); i++) {
			if (map1.containsKey(list1.get(i))) {
				map1.put(list1.get(i), map1.get(list1.get(i)) + 1);
			} else {
				map1.put(list1.get(i), 1);
			}
		}
		for (int i = 0; i < list2.size(); i++) {
			if (map2.containsKey(list2.get(i))) {
				map2.put(list2.get(i), map2.get(list2.get(i)) + 1);
			} else {
				map2.put(list2.get(i), 1);
			}
		}
		int hapCount = 0;
		int gyoCount = 0;

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {

			String temp = it.next();
			int count1 = 0;
			int count2 = 0;
			try {
				count1 = map1.get(temp);
			} catch (Exception e) {
			}
			try {
				count2 = map2.get(temp);

			} catch (Exception e) {
				// TODO: handle exception
			}
			int big = Math.max(count1, count2);
			int small = Math.min(count1, count2);
//			System.out.println(temp+" : "+big+","+small);
			hapCount += big;
			gyoCount += small;
		}
//		System.out.println(hapCount);
//		System.out.println(gyoCount);
		double t = (double)gyoCount/(double)hapCount;
		if(set.size()==0) {
			return 65536;
		}
		answer =(int)Math.floor(t*65536);
		
		return answer;
	}
}
