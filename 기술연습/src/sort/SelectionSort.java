package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 2, 7 };
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(selectionSort(arr)));

	}

	static public int[] selectionSort(int[] arr) {
		int temp = 0;
		for (int k = 0; k < arr.length - 1; k++) {
			int min = arr[temp];
			int minIdx = temp;
			for (int i = temp + 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					minIdx = i;
				}
			}
			int tmp = arr[temp];
			arr[minIdx] = tmp;
			arr[temp] = min;
			temp++;
		}

		return arr;
	}

}
