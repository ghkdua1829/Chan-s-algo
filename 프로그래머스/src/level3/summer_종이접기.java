package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class summer_종이접기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(20)));
	}

	static public int[] solution(int n) {
		int[] answer = {};
		Stack<int[]> stack = new Stack<int[]>();
		int[] arr1 = { 0 };
		stack.push(arr1);
		for (int i = 1; i < n; i++) {
			int[] top = stack.pop();
			int[] temp = new int[1 + top.length * 2];
			int current = 0;
			for (current = 0; current < top.length; current++) {
				temp[current] = top[current];
			}
			temp[current++] = 0;
			for (int j = top.length-1; j >= 0; j--) {
				if(top[j]==1) {
					temp[current++] = 0;
				}else {
					temp[current++] = 1;
				}
			}
			stack.push(temp);
		}
//		System.out.println(Arrays.toString(stack.pop()));
		return stack.pop();
	}
}
