package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			double num = sc.nextDouble();
			int result = 0;
			while (true) {
				if (num == 2)
					break;

				if (Math.sqrt(num) % 1 == 0) {
					num = Math.sqrt(num);
					result++;
				} else {
					double s = Math.ceil(Math.sqrt(num));
					result = result + (int) (Math.pow(s, 2) - num);
					num = num + (Math.pow(s, 2) - num);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	static long bfsQueue(double start) {
		Queue<Double> queue = new LinkedList<Double>();
		int result = -1;
		queue.offer(start);
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				double top = queue.poll();
				if (top == 2) {
					return result;
				}
				if (Math.sqrt(top) % 1 == 0) {
					queue.offer(Math.sqrt(top));
				} else {
					queue.offer(top + 1);

				}
			}
		}
		return -1;
	}
}
