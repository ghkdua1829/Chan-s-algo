package 라인코테;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {

	}

	static public int[] solution(int[] ball, int[] order) {
		int[] answer = new int[ball.length];
		int idx = 0;
		Deque<Integer> deq = new ArrayDeque<>();
		for (int i = 0; i < ball.length; i++) {
			deq.add(ball[i]);
		}
		List<Integer> orderList = new ArrayList<Integer>();
		for (int i = 0; i < order.length; i++) {
			int num = order[i];
			orderList.add(num);
			while (true) {
				if (orderList.contains(deq.peekFirst())) {
					orderList.remove(deq.peekFirst());
					answer[idx++] = deq.pollFirst();
				} else if (orderList.contains(deq.peekLast())) {
					orderList.remove(deq.peekLast());
					answer[idx++] = deq.pollLast();
				} else {
					break;
				}
			}

		}
		return answer;
	}

	static class Ball {
		int num;
		boolean ready;

		public Ball(int num, boolean ready) {
			super();
			this.num = num;
			this.ready = ready;
		}

		@Override
		public String toString() {
			return "Ball [num=" + num + ", ready=" + ready + "]";
		}

	}

}
