package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class skt2_1 {

	public static void main(String[] args) {
		String[] goods = { "pencil", "cilicon", "contrabase", "picturelist" };
		System.out.println(Arrays.toString(solution(goods)));
	}

	public static String[] solution(String[] goods) {
		String[] answer = new String[goods.length];
		for (int i = 0; i < goods.length; i++) {
			Set<String> set = new HashSet<String>();
			answer[i] = "";
			String good = goods[i];
			// 문자열의 길이만큼 포문을 돈다.
			for (int k = 1; k < good.length() + 1; k++) {
				int start = 0;
				boolean big = false;
				while (start + k < good.length() + 1) {
					String sub = good.substring(start, start + k);
					boolean containYn = false;
					for (int t = 0; t < goods.length; t++) {
						if (t == i) {
							continue;
						}
						if (goods[t].contains(sub)) {

							containYn = true;
						}
					}

					if (!containYn) {
						set.add(sub);
//						System.out.println(sub);
//						answer[i] += sub + " ";
						big = true;
					}
					if (start + k >= good.length()) {
						if (big) {
							k = Integer.MAX_VALUE - 1;
							break;
						}
					}
					start++;
				}
			}
			List<String> list = new ArrayList(set);
			Collections.sort(list);
			for (int j = 0; j < list.size(); j++) {
				if (j == list.size() - 1) {
					answer[i] += list.get(j);

				} else {
					answer[i] += list.get(j) + " ";

				}
			}
			if(answer[i] =="") {
				answer[i] = "None";
			}
		}
		return answer;
	}
}
