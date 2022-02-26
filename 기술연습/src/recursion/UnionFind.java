package recursion;

public class UnionFind {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		System.out.println(find(arr,1));
	}

	static int find(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		}
		return find(parent, parent[x]);
	}

}
