package Baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_3584_가장가까운공통조상 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N + 1];
			for (int i = 0; i < N + 1; i++) {
				nodes[i] = new Node(i, -1);
			}
			for (int n = 1; n < N; n++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(token.nextToken());
				int child = Integer.parseInt(token.nextToken());
				nodes[child].parent = parent;
			}

		}

	}

	static class Node {
		int num;
		int parent;

		public Node(int num, int parent) {
			super();
			this.num = num;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", parent=" + parent + "]";
		}

	}

}
