package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kakao_후보키 {
	static int result = 0;
	static List<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		;
		System.out.println(solution(relation));
	}

	static public int solution(String[][] relation) {
		int answer = 0;
		for (int i = 1; i <= relation[0].length; i++) {
			makeCombination(i, new int[i], 0, 0, relation);
		}
		answer = result;
		return answer;
	}

	static void makeCombination(int r, int[] temp, int current, int start, String[][] relation) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			for(int i=0;i<list.size();i++) {
				int[] have = list.get(i);
//				System.out.println("have : "+Arrays.toString(have));
				int cnt = 0;
				for(int j=0;j<have.length;j++) {
					for(int k=0;k<temp.length;k++) {
						if(have[j]==temp[k]) {
							cnt++;
						}
					}
				}
//				System.out.println(cnt + " : "+have.length);
				if(cnt==have.length) {
					return;
				}
			}
//			System.out.println(Arrays.toString(temp));
			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < relation.length; j++) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < temp.length; i++) {
					int idx = temp[i];
					sb.append(relation[j][idx]);
//					System.out.println(sb.toString());
				}
				set.add(sb.toString());
			}
			if (set.size() == relation.length) {
				result++;
//				System.out.println(Arrays.toString(temp));
//				System.out.println("rRr : " + result);
				int[] temptemp = new int[temp.length];
				for(int i=0;i<temp.length;i++) {
					temptemp[i] =temp[i];
				}
				list.add(temptemp);			}
		} else {
			for (int i = start; i < relation[0].length; i++) {
				temp[current] = i;
				makeCombination(r, temp, current + 1, i + 1, relation);
			}
		}
	}
}
