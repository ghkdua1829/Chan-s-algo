package kakao_인턴코테;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class problem2 {
	static char[] exp;
	static List<String> explist;
	static long finalresult = 0L;

	public static void main(String[] args) throws ScriptException {
		String expression = "100+200*333*300*300*300*300*300*999";
		System.out.println(solution(expression));
	}

	static public long solution(String expression) throws ScriptException {
		long answer = 0;
		int start = 0, end = 0;
		explist = new ArrayList<>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				set.add(expression.charAt(i));
				explist.add(expression.substring(start, end));
				explist.add(expression.substring(end, end + 1));
				end = end + 1;
				start = end;
			} else {
				end++;
			}
			if (i == expression.length() - 1) {
				explist.add(expression.substring(start, end));
			}
		}
		exp = new char[set.size()];
		Iterator<Character> iter = set.iterator();
		int a = 0;
		while (iter.hasNext()) {
			exp[a] = iter.next();
			a++;
		}
		makePermutation(exp.length, new char[exp.length], new boolean[exp.length], 0);

//		System.out.println(Arrays.toString(copyExpression));
		answer = finalresult;
		return answer;
	}

	static void makePermutation(int r, char[] temp, boolean[] visited, int current) throws ScriptException {
		if (r == current) {
//			System.out.println(Arrays.toString(temp));
			List<String> copy = new ArrayList<String>();
			for (int i = 0; i < explist.size(); i++) {
				copy.add(explist.get(i));
			}

			for (int i = 0; i < temp.length; i++) {
				char giho = temp[i];
				for (int j = 0; j < copy.size(); j++) {
					if (copy.get(j).charAt(0) == giho) {
						String beforeNum = copy.get(j - 1);
						String afterNum = copy.get(j + 1);
						long before = Long.valueOf(beforeNum);
						long after = Long.valueOf(afterNum);
						long result = 0;
						if (giho == '*') {
							result = before * after;
						} else if (giho == '-') {
							result = before - after;
						} else {
							result = before + after;

						}
//						System.out.println(engine.eval(foo));
						copy.set(j - 1, String.valueOf(result));
						copy.remove(j);
						copy.remove(j);
						if (copy.size() == 1) {
//							long result = Math.abs(Long.parseLong(String.valueOf(engine.eval(foo))));
							long rr = Math.abs(result);
							if (rr > finalresult) {
								finalresult = rr;
							}
						}
						j--;
					}
				}
			}
		} else {
			for (int i = 0; i < exp.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = exp[i];
					makePermutation(r, temp, visited, current + 1);
					visited[i] = false;
				}
			}
		}
	}

}
