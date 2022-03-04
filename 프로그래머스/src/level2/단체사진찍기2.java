package level2;

import java.util.Arrays;

public class 단체사진찍기2 {
	static char[] kakaos = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static int answer = 0;

	public static void main(String[] args) {
		String[] strs = { "N~F=0", "R~T>2" };
		solution(2, strs);
	}

	public static int solution(int n, String[] data) {
		Rule[] rules = new Rule[data.length];
		for (int i = 0; i < data.length; i++) {
			String str = data[i];
			char target1 = str.charAt(0);
			char target2 = str.charAt(2);
			char giho = str.charAt(3);
			int diff = str.charAt(4) - '0' + 1;
			rules[i] = new Rule(target1, target2, giho, diff);
		}
		makePermutation(kakaos.length, 0, new char[kakaos.length], new boolean[kakaos.length], rules);
		return answer;
	}

	static void makePermutation(int r, int current, char[] arr, boolean[] visited, Rule[] rules) {
		if (r == current) {
			boolean isOk = true;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]);
			}
			String str = sb.toString();
			for (Rule rule : rules) {
				switch (rule.giho) {
				case '>':
					if (Math.abs(str.indexOf(rule.target1)
							- str.indexOf(rule.target2)) > rule.diff) {
					} else {
						isOk = false;
						return;
					}
					break;
				case '<':
					if (Math.abs(str.indexOf(rule.target1)
							- str.indexOf(rule.target2)) > rule.diff) {
					} else {
						isOk = false;
						return;
					}
					break;
				case '=':
					if (Math.abs(str.indexOf(rule.target1)
							- str.indexOf(rule.target2)) == rule.diff) {
					} else {
						isOk = false;
						return;
					}
					break;
				}
			}
			if (isOk) {
				answer++;
			}

		} else {
			for (int i = 0; i < kakaos.length; i++) {
				if (!visited[i]) {
					arr[current] = kakaos[i];
					visited[i] = true;
					makePermutation(r, current + 1, arr, visited, rules);
					visited[i] = false;

				}

			}
		}
	}

	static class Rule {
		char target1, target2, giho;
		int diff;

		@Override
		public String toString() {
			return "Rule [target1=" + target1 + ", target2=" + target2 + ", giho=" + giho + ", diff=" + diff + "]";
		}

		public Rule(char target1, char target2, char giho, int diff) {
			super();
			this.target1 = target1;
			this.target2 = target2;
			this.giho = giho;
			this.diff = diff;
		}

	}

}
