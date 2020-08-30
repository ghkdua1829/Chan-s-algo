package level2;

import java.util.ArrayList;
import java.util.List;

public class 압축 {

	public static void main(String[] args) {
		solution("KAKAO");
	}

	static public int[] solution(String msg) {
		int[] answer = {};
		List<String> dict = new ArrayList<String>();
		List<Integer> index = new ArrayList<Integer>();
		dict.add("-");
		for (int i = 65; i < 91; i++) {
			String code = String.valueOf((char) i);
			dict.add(code);
		}

		for (int i = 0; i < msg.length(); i++) {
			StringBuilder findWord = new StringBuilder();
			int j = i;
			for (j = i; j < msg.length(); j++) {
				findWord.append(msg.charAt(j));
				if (!dict.contains(findWord.toString())) {
					String find = findWord.toString();
					dict.add(find);
//					System.out.println(find.substring(0, find.length() - 1));
					index.add(dict.indexOf(find.substring(0, find.length() - 1)));
					break;
				}
				if(j==msg.length()-1) {
					index.add(dict.indexOf(findWord.toString()));
				}
			}
			i=j-1;
		}
		answer = new int[index.size()];
		for(int i=0;i<index.size();i++) {
			answer[i] = index.get(i);
		}
		
		return answer;
	}

}
