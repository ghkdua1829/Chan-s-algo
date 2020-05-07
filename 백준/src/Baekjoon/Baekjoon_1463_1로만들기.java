package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1463_1로만들기 {
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");
		int number = Integer.parseInt(tokens.nextToken());
		if(number==1) {
			System.out.println(0);
		}else {
			bfsQueue(number);
		}
	}

	public static void bfsQueue(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(num);
		while (!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer top = queue.poll();
				if(top==1) {
					System.out.println(--result);
					return;
				}
				if(top%3==0) {
					queue.offer(top/3);
				}
				if(top%2==0) {
					queue.offer(top/2);
				}
				if(top-1>0) {
					queue.offer(top-1);
				}
			}
		}
	}
}
