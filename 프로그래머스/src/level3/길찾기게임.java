package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class 길찾기게임 {
	static Node[] nodeArr;
	static List<Integer> before = new ArrayList<Integer>();
	static List<Integer> after = new ArrayList<Integer>();

	public static void main(String[] args) {
		int[][] nodeinfo = { { 8, 1 }, { 11, 3 }, { 4, 3 }, { 6, 5 } };
		System.out.println(solution(nodeinfo));
	}

	static public int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		answer = new int[2][nodeinfo.length];
		nodeArr = new Node[nodeinfo.length];
		for (int i = 0; i < nodeinfo.length; i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];
			nodeArr[i] = new Node(x, y, i + 1, -1, 100001, null, null);
		}
		Arrays.sort(nodeArr);
		for (int i = 0; i < nodeArr.length; i++) {
			Node parent = nodeArr[i];
			linkNode(parent, i + 1);
		}
//		for (Node arr : nodeArr) {
//			System.out.println(arr);
//		}
//		before.add(nodeArr[0].num);
		dfsStack(nodeArr[0]);
		dfsAfterStack(nodeArr[0]);
//		after.add(nodeArr[0].num);
//		System.out.println(after.size());
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				if (i == 0) {
					answer[i][j] = before.get(j);
				} else {
					answer[i][j] = after.get(j);
				}
			}
		}
//		for (int[] arr : answer) {
//			System.out.println(Arrays.toString(arr));
//		}
		return answer;
	}

	private static void linkNode(Node parent, int idx) {
		// TODO Auto-generated method stub
		int y = parent.y;
		for (int i = idx; i < nodeArr.length; i++) {
			int childY = nodeArr[i].y;
			if (y > childY) {
				y = childY;
				break;
			}
		}
		if (y == parent.y) {
			return;
		}
		for (int i = 0; i < nodeArr.length; i++) {
			int childY = nodeArr[i].y;
			if (childY == y) {
				Node child = nodeArr[i];
				if (parent.x > child.x) {
					if (child.x > parent.leftLimit) {
						child.rightLimit = parent.x;
						child.leftLimit = parent.leftLimit;
						parent.left = child;
					}
				} else {
					if (child.x < parent.rightLimit) {
						child.leftLimit = parent.x;
						child.rightLimit = parent.rightLimit;
						parent.right = child;
					}
				}
			}
		}

	}

	static void dfsStack(Node parent) {
		before.add(parent.num);
//		System.out.println(parent.num);
		if (parent.left != null) {
			dfsStack(parent.left);
		}
		if (parent.right != null) {
			dfsStack(parent.right);
		}
//		if (parent.left == null && parent.right == null) {
//			return;
//		} else {
//			if (parent.left != null) {
//				System.out.println(parent.left.num);
//				before.add(parent.left.num);
//				dfsStack(parent.left);
//			}
//			if (parent.right != null) {
//				System.out.println(parent.right.num);
//				before.add(parent.right.num);
//				dfsStack(parent.right);
//			}
//		}
	}

	static void dfsAfterStack(Node parent) {
		if (parent.left != null) {
			dfsAfterStack(parent.left);
		}
		if (parent.right != null) {
			dfsAfterStack(parent.right);
		}
		after.add(parent.num);
//		if (parent.left == null && parent.right == null) {
//			return;
//		} else {
//			if (parent.left != null) {
//				dfsAfterStack(parent.left);
////				System.out.println(parent.left.num);
//				after.add(parent.left.num);
//			}
//			if (parent.right != null) {
//				dfsAfterStack(parent.right);
////				System.out.println(parent.right.num);
//				after.add(parent.right.num);
//			}
////			System.out.println(parent.num);
//
//		}
	}

	static class Node implements Comparable<Node> {

		@Override
		public int compareTo(Node o) {
			if (this.y < o.y) {
				return 1;
			} else if (this.y > o.y) {
				return -1;
			} else {
				if (this.x < o.x) {
					return -1;
				} else {
					return 1;
				}
			}
		}

		int x, y, num;
		int leftLimit, rightLimit;
		Node left, right;

		public Node(int x, int y, int num, int leftLimit, int rightLimit, Node left, Node right) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.leftLimit = leftLimit;
			this.rightLimit = rightLimit;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", num=" + num + ", leftLimit=" + leftLimit + ", rightLimit="
					+ rightLimit + ", left=" + left + ", right=" + right + "]";
		}

	}
}