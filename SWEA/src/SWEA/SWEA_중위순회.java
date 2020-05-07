package SWEA;

import java.util.Scanner;

public class SWEA_중위순회 {
	private static Node[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int size = Integer.parseInt(sc.nextLine());
			tree = new Node[size + 1];
			for (int i = 0; i < size; i++) {
				String c = sc.nextLine();
				String[] splited = c.split(" ");
				int parent = Integer.parseInt(splited[0]);
				String alpa = splited[1];
				Node pNode = getNode(parent);
				pNode.alpha = alpa;
				switch (splited.length) {
				case 3:
					int child = Integer.parseInt(splited[2]);
					Node cNode = getNode(child);
					if (child % parent == 0) {
						pNode.l = cNode;
					} else {
						pNode.r = cNode;
					}
					break;
				case 4:
					int childL = Integer.parseInt(splited[2]);
					int childR = Integer.parseInt(splited[3]);
					Node cNodeL = getNode(childL);
					Node cNodeR = getNode(childR);
					pNode.r = cNodeR;
					pNode.l = cNodeL;
					break;
				}
			}
			System.out.print("#" + tc + " ");
			inOrder(tree[1]);
			System.out.println();
		}
	}

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.l);
		System.out.print(node.alpha);
		inOrder(node.r);
	}

	// idx 기반으로 기존 노드 또는 새로 생성한 노드 반환
	private static Node getNode(int idx) {
		if (tree[idx] == null) {
			tree[idx] = new Node(idx);
		}
		return tree[idx];
	}

	static class Node {
		int v;
		String alpha;
		Node r, l, p;

		public Node(int v) {
			this.v = v;
		}
	}

}
