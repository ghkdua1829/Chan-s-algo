package 쿠팡2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem3 {

	public static void main(String[] args) {
		int[] score = { 1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638,
				157658634, 100000000, 100 };
		int k = 2;
		solution(k, score);
	}

	static public int solution(int k, int[] score) {
		Set<Integer> resultSet = new HashSet<Integer>();
		int answer = -1;
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for (int i = 0; i < score.length - 1; i++) {
			int frontNum = score[i];
			int backNum = score[i + 1];
			int gap = frontNum - backNum;
			if (!map.containsKey(gap)) {
				map.put(gap, new Point(new HashSet<Integer>(), 0));
			}
			map.get(gap).set.add(frontNum);
			map.get(gap).set.add(backNum);
			map.get(gap).count++;
		}
		for (Map.Entry<Integer, Point> point : map.entrySet()) {
			if (point.getValue().count >= k) {
				Set set = point.getValue().set;

				Iterator<Integer> it = set.iterator();

				while (it.hasNext()) { // hasNext() : 데이터가 있으면 true 없으면 false
					resultSet.add(it.next());
				}

			}
		}
		answer = score.length - resultSet.size();
		System.out.println(answer);
		return answer;
	}

	static class Point {
		Set<Integer> set;
		int count;

		public Point(Set<Integer> set, int count) {
			super();
			this.set = set;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [set=" + set + ", count=" + count + "]";
		}

	}

}
