package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5,3,1,7,6};
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(bubbleSort(arr)));

	}

	static public int[] bubbleSort(int[] arr) {
		int range = arr.length - 1;
		for (int k = 0; k < arr.length - 1; k++) {
			for (int i = 0; i < range; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			range--;
		}
		return arr;
	}

}
