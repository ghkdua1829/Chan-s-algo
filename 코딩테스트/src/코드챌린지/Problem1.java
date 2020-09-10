package 코드챌린지;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problem1 {
	static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		int[] numbers = { 11, 22, 33, 44 };
	}

	static public int[] solution(int[] numbers) {
		makeCombination(2, new int[2], 0, 0, numbers);
		Iterator<Integer> it = set.iterator();
		int[] answer = new int[set.size()];
		int i = 0;
		while (it.hasNext()) {
			int num = it.next();
			answer[i++] = num;
		}
		Arrays.sort(answer);

		return answer;
	}

	static void makeCombination(int r, int[] temp, int current, int start, int[] numbers) {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			set.add(temp[0] + temp[1]);
		} else {
			for (int i = start; i < numbers.length; i++) {
				temp[current] = numbers[i];
				makeCombination(r, temp, current + 1, i + 1, numbers);
			}
		}
	}

}
