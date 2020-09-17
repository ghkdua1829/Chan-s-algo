package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단체사진찍기 {
	static char[] arr = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static List<Seat> list;
	static int result = 0;


	static public int solution(int n, String[] data) {
		int answer = 0;
		list = new ArrayList<>();
		result = 0;
		for (int i = 0; i < data.length; i++) {
			char start = data[i].charAt(0);
			char end = data[i].charAt(2);
			char giho = data[i].charAt(3);
			int amount = data[i].charAt(4) - '0';
			list.add(new Seat(start, end, giho, amount));
		}
		makePermutaion(arr.length, new char[arr.length], 0, new boolean[arr.length]);
		answer =result;
		return answer;
	}

	static void makePermutaion(int r, char[] temp, int current, boolean[] visited) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			boolean token = true;
			for (int i = 0; i < list.size(); i++) {
				Seat sit = list.get(i);
				int startIdx = -1;
				int endIdx = -1;
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == sit.start) {
						startIdx = j;
					}
					if (temp[j]==sit.end) {
						endIdx = j;
					}
				}
				int differentIdx = Math.abs(startIdx - endIdx);
				if (sit.giho == '>') {
					if (differentIdx <= sit.amount + 1) {
						token = false;
					}
				} else if (sit.giho == '<') {
					if (differentIdx >= sit.amount + 1) {
						token = false;
					}
				} else if (sit.giho == '=') {
					if (differentIdx != sit.amount + 1) {
						token = false;
					}
				}
			}
			if(token) {
				result++;
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = arr[i];
					makePermutaion(r, temp, current + 1, visited);
					visited[i] = false;
				}
			}
		}
	}

	static class Seat {
		char start, end;
		char giho; // > 이면 1 , = 이면 0 , < 이면 -1
		int amount;

		public Seat(char start, char end, char giho, int amount) {
			super();
			this.start = start;
			this.end = end;
			this.giho = giho;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Seat [start=" + start + ", end=" + end + ", giho=" + giho + ", amount=" + amount + "]";
		}

	}
}
