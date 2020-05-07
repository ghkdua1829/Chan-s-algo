package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_17471_게리맨더링 {

	static Queue<Integer> queue;
	static boolean visited[];
	static City[] cityInfo;
	static List<Integer>[] graph;
	static int count;
	static int result1;
	static int result2;
	static int sumResult = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		cityInfo = new City[count + 1];
		graph = new List[count + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int p = 1; p < cityInfo.length; p++) {
			cityInfo[p] = new City(p, sc.nextInt());
		}
		for (int i = 1; i < count + 1; i++) {
			int relatedCount = sc.nextInt();
			for (int r = 0; r < relatedCount; r++) {
				int a = sc.nextInt();
				graph[i].add(a);
			}
		}
		int subsetNum = 0;
		if (count % 2 == 1) {
			subsetNum = count / 2 + 1;
		} else {
			subsetNum = count / 2;
		}
		for (int i = subsetNum; i < count; i++) {
			makeCombination(i, new int[i], 0, 1);
		}
		if (sumResult == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(sumResult);
		}
	}

	public static boolean bfsQueue(int start, boolean[] visited2) {
		queue = new LinkedList<Integer>();
		queue.offer(start);
		int resultChange = 0;
		int changeCount = 0;

		for (int i = 0; i < visited2.length; i++) {
			if (!visited2[i]) {
				resultChange++;
			}
		}
		while (!queue.isEmpty()) {
			Integer top = queue.poll();
			if (visited2[top]) {
				continue;
			}
			visited2[top] = true;
			changeCount++;

			for (int i = 0; i < graph[top].size(); i++) {
				if (visited2[graph[top].get(i)]) {
					continue;
				} else {
					queue.offer(graph[top].get(i));

				}
			}
		}
		if (resultChange == changeCount) {
			return true;
		} else {
			return false;
		}
	}

	public static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			int[] temp2 = new int[count - r];
			List<Integer> tempList = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				tempList.add(i + 1);
			}
			for (int t = 0; t < temp.length; t++) {
				Integer a = temp[t];
				tempList.remove(a);
			}
			for (int i = 0; i < tempList.size(); i++) {
				temp2[i] = tempList.get(i);
			}
			boolean[] tf = new boolean[cityInfo.length];
			for (int i = 0; i < temp.length; i++) {
				int a = temp[i];
				tf[a] = true;
			}
			boolean[] visited2 = new boolean[cityInfo.length];
			for (int i = 0; i < tf.length; i++) {
				if (!tf[i]) {
					visited2[i] = true;
				}
			}
			boolean[] visited2Copy = new boolean[cityInfo.length];
			visited2Copy[0] = true;
			for (int i = 1; i < visited2.length; i++) {
				if (visited2[i]) {
					visited2Copy[i] = false;
				} else {
					visited2Copy[i] = true;
				}
			}

			result1 = 0;
			result2 = 0;
			if (bfsQueue(temp2[0], visited2Copy) && bfsQueue(temp[0], visited2)) {
				for (int i = 0; i < temp2.length; i++) {
					for (int j = 1; j < cityInfo.length; j++) {
						if (cityInfo[j].number == temp2[i]) {
							result1 += cityInfo[j].population;
							break;
						}
					}
				}
				for (int i = 0; i < temp.length; i++) {
					for (int j = 1; j < cityInfo.length; j++) {
						if (cityInfo[j].number == temp[i]) {
							result2 += cityInfo[j].population;
							break;
						}
					}
				}
				if (Math.abs(result1 - result2) < sumResult) {
					sumResult = Math.abs(result1 - result2);
				}
			}
		} else {
			for (int i = start; i < cityInfo.length; i++) {
				temp[current] = cityInfo[i].number;
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}

	static class City {
		int number, population;

		public City(int number, int population) {
			this.number = number;
			this.population = population;
		}

		@Override
		public String toString() {
			return "City [number=" + number + ", population=" + population + "]";
		}

	}
}
