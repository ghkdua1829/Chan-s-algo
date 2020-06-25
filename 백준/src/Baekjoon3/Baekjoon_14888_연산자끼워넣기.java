package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Baekjoon_14888_연산자끼워넣기 {

	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		sb = new StringBuilder();

		token = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(token.nextToken());
			for (int j = 0; j < cnt; j++) {
				switch (i) {
				case 0:
					sb.append("+");
					break;
				case 1:
					sb.append("-");
					break;
				case 2:
					sb.append("*");
					break;
				case 3:
					sb.append("/");
					break;
				}
			}
		}


		makePermutaion(sb.length(), new char[sb.length()], 0, new boolean[sb.length()]);
		
		System.out.println(MAX);
		System.out.println(MIN);

	}

	static void makePermutaion(int r, char[] temp, int current, boolean[] visited) throws ScriptException {
		if (r == current) {
			StringBuilder sik = new StringBuilder();

			int result = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				switch (temp[i]) {
				case '+':
					result += arr[i + 1];
					break;
				case '-':
					result -= arr[i + 1];
					break;
				case '*':
					result *= arr[i + 1];
					break;
				case '/':
					result /= arr[i + 1];
					break;

				}
			}
			if (MAX < result) {
				MAX = result;
			}
			if (MIN > result) {
				MIN = result;
			}

		} else {
			for (int i = 0; i < sb.length(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = sb.charAt(i);
					makePermutaion(r, temp, current + 1, visited);
					visited[i] = false;
				}
			}
		}
	}
}
