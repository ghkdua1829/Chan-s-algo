package 번가;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P3 {
	static boolean[] visited;

	public static void main(String[] args) {
		int[] A= {6,2,3,5,6,3};
		// TODO Auto-generated method stub
		solution(A);

	}

	static public int solution(int[] A) {
		// write your code in Java SE 8
		 visited = new boolean[A.length+1];
		int result = 0;
		visited[0] = true;
		List<Integer> overlap = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (!visited[num]) {
				visited[num] = true;
			} else {
				overlap.add(num);
			}
		}
//		for (int i : overlap) {
//			System.out.println(i);
//		}
		for(int i=0;i<overlap.size();i++) {
			int start = overlap.get(i);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(start);
			int time = 0;
			while(!queue.isEmpty()) {
				time++;
				int size = queue.size();
				for(int k=0;k<size;k++) {
					int top = queue.poll();
					if(isIn(top+1) && !visited[top+1]) {
						visited[top+1] = true;
						result+=time;
						queue.clear();
						break;
					}else {
						if(isIn(top+1)) {
							queue.offer(top+1);
						}
					}
					if(isIn(top-1) && !visited[top-1]) {
						visited[top-1] = true;
						result+=time;
						queue.clear();
						break;
					}else {
						if(isIn(top-1)) {
							queue.offer(top-1);

						}
					}
				}
			}
				
		}

		return result;
	}

	static boolean isIn(int i) {
		return i >= 0 && i < visited.length;
	}
}
