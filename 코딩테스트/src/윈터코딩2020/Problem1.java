package 윈터코딩2020;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public String solution(int n, int[][] delivery) {
		String answer = "";
		char[] number = new char[n];
		for (int i = 0; i < n; i++) {
			number[i] = '?';
		}
		Arrays.sort(delivery, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}

		});

		for (int i = 0; i < delivery.length; i++) {
			int[] arr = delivery[i];
			int first = arr[0] - 1;
			int sec = arr[1] - 1;
			int deliverOk = arr[2];

			if (deliverOk == 1) {
				number[first] = 'O';
				number[sec] = 'O';
				continue;
			} else if (deliverOk == 0) {
				if (number[first] == 'O') {
					number[sec] = 'X';
					continue;
				} else if (number[first] == 'X') {
//					number[sec] = 'X';
					continue;
				}
				if (number[sec] == 'O') {
					number[first] = 'X';
					continue;
				} else if (number[sec] == 'X') {
//					number[first] = 'X';
					continue;
				}
			}

		}
		System.out.println(Arrays.toString(number));
		return answer;
	}

}
