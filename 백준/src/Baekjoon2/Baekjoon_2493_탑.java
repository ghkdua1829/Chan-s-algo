package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		int maxTop = Integer.MIN_VALUE;
		int[] result = new int[N];
		Stack<Point> stack = new Stack<>();
		stack.push(new Point(0, 0));
		for (int i = 0; i < N; i++) {
			if (stack.peek().value < arr[i]) {
				stack.pop();
				stack.push(new Point(i+1, arr[i]));
			}else {
			}

			if (stack.size() == 1) {
				result[i] = 0;
			} else {
			}
		}
	}

	static class Point {
		int index, value;

		public Point(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [index=" + index + ", value=" + value + "]";
		}

	}
}
