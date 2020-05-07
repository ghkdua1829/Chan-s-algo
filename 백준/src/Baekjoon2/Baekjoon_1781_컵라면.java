package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1781_컵라면 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		Long result = 0L;
		int maxDeadLine = 0;
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(token.nextToken());
			int cupNoodle = Integer.parseInt(token.nextToken());
			if (maxDeadLine < deadLine) {
				maxDeadLine = deadLine;
			}
			pq.add(new Point(deadLine, cupNoodle));
		}
		boolean[] visited = new boolean[maxDeadLine+1];

		int size = 0;
		while (true) {
			if (pq.isEmpty()) {
				break;
			}
			Point top = pq.poll();
			int topDead = top.dead;

			if (!visited[topDead]) {
				visited[topDead] = true;
				result += top.cup;
			} else {
				while (visited[--topDead]) {

				}
				if (topDead == 0) {
					continue;
				} else {
					visited[topDead] = true;
					result += top.cup;
				}
			}
			
			
			
//			if (top.dead <= size) {
//				continue;
//			}
//			result += top.cup;
//			size++;

		}
		System.out.println(result);
	}

	static class Point implements Comparable<Point> {
		int dead, cup;

		public Point(int dead, int cup) {
			super();
			this.dead = dead;
			this.cup = cup;
		}

		@Override
		public int compareTo(Point o) {
			if (o.cup == this.cup) {
				return Integer.compare(this.dead, o.dead);
			} else {
				return Integer.compare(o.cup, this.cup);
			}
		}

		@Override
		public String toString() {
			return "Point [dead=" + dead + ", cup=" + cup + "]";
		}
	}

}
