package sort;

import java.util.Arrays;

public class InsertSort {
	// 삽입 정렬
	public static void main(String[] args) {
		Integer[] arr = { 5, 1, 6, 7, 8, 75, 5, 65, 456, 353, 45, 45, 3425, 43, 3, 2, 4 };
//		insertSort(arr);
		Integer a = arr[1];
		a=2;
		System.out.println(arr[1]);
		
	}

	static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[temp] < arr[j]) {
					int t = arr[temp];
					arr[temp] = arr[j];
					arr[j] = t;
					temp--;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
