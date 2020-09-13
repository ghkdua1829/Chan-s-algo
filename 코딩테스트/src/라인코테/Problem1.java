package 라인코테;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		int[][] boxes= {{2,3},{2,2}};
		solution(boxes);
	}

	static public int solution(int[][] boxes) {
		int answer = -1;
		int size = boxes.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int r = 0; r < boxes.length; r++) {
			for (int c = 0; c < boxes[0].length; c++) {
				int num = boxes[r][c];
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}
		}
		int boxCount = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 2) {
				int mok = entry.getValue() / 2;
				boxCount += mok;
				map.put(entry.getKey(), entry.getValue() % 2);
			}
		}
		int oneCount = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			System.out.println("key : " + entry.getKey() + " , value : " + entry.getValue());
			if (entry.getValue() == 1) {
				oneCount++;
			}
		}
		int namBox = size-boxCount;
		if(oneCount>=namBox) {
			answer = namBox;
		}else {
			answer +=oneCount;
			answer+=(namBox-oneCount)*2;
		}
		System.out.println(answer);
		return answer;
	}
}
