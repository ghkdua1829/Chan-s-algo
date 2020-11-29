package nhnGodo;

import java.util.*;

public class Problem5 {

	public static void main(String[] args) {
		int[] votes = { 5,10,7,3,8};
		// TODO Auto-generated method stub
		System.out.println(solution(votes));
	}

	static public int solution(int[] votes) {
		int zero = votes[0];
		if (votes.length == 1) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 1; i < votes.length; i++) {
			pq.add(votes[i]);
		}
		if (pq.peek() - zero == 0) {
			return 1;
		}
		if(zero - pq.peek()>0) {
			System.out.println("asd");
			return 0;
		}
		int first = pq.peek() - zero;
		int cnt = 0;
		while (true) {
			cnt++;
			int top = pq.poll();
			zero++;
			pq.add(top - 1);
			if (pq.peek() < zero) { 
				break;
			} else if (pq.peek() == zero) {
				return cnt + 1;
			}
		}
		int result = Math.min(cnt, first);
		return result;
	}
}
