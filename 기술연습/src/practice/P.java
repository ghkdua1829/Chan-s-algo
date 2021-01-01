package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P {
	static long[] arr = new long[81];

	public static void main(String[] args) {
		int[] temp = { 0, 5, 6, 0 };
		int[] reslult = JSOBS(temp);
		System.out.println(Arrays.toString(reslult));
	}

	static int[] JSOBS(int[] arr) {
		int[] result = new int[arr.length];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				list.add(arr[i]);
			}
		}
		int start = arr.length - list.size();
		for (int i = 0; i < list.size(); i++) {
			result[start++] = list.get(i);
		}
		return result;
	}

	static List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("AsdasD");
		return list;

	}

	static public long solution(int n) {
		arr[0] = 0;
		arr[1] = 1;

		return pibo(n);
	}

	static long pibo(int n) {
		if (arr[n] != 0) {
			return arr[n];
		}
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return arr[n] = pibo(n - 1) + pibo(n - 2);
	}
}
