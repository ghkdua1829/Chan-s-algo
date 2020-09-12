package KAKAOBLIND2021;

public class Problem3 {

	public static void main(String[] args) {

	}

	static public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Human[] humanArr = new Human[info.length];
		for (int i = 0; i < info.length; i++) {
			String[] arr = info[i].split(" ");
			String lang = arr[0];
			String end = arr[1];
			String career = arr[2];
			String food = arr[3];
			int score = Integer.parseInt(arr[4]);
			humanArr[i] = new Human(lang, end, career, food, score);
//			System.out.println(humanArr[i]);
		}
		for (int i = 0; i < query.length; i++) {
			String scoreStr = query[i].split(" ")[7];

			String[] arr = query[i].substring(0, query[i].length() - scoreStr.length()).split(" and ");
			String lang = arr[0].trim();
			String end = arr[1].trim();
			String career = arr[2].trim();
			String food = arr[3].trim();
			int score = Integer.parseInt(scoreStr);
			int sum = 0;
			for (int h = 0; h < humanArr.length; h++) {
				Human human = humanArr[h];
				if (lang.equals("-")) {
				} else {
					System.out.println(end + "," + human.end.toString());
					if (!lang.equals(human.lang)) {
						continue;
					}
				}
				if (end.equals("-")) {
				} else {
					if (!end.equals(human.end)) {
						continue;
					}
				}
				if (career.equals("-")) {
				} else {
					if (!career.equals(human.career)) {
						continue;
					}
				}
				if (food.equals("-")) {
				} else {
					if (!food.equals(human.food)) {
						continue;
					}
				}
				if (score <= human.score) {
					sum++;
				}
			}
			answer[i] = sum;
		}

		return answer;
	}

	static class Human {
		String lang, end, career, food;
		int score;

		public Human(String lang, String end, String career, String food, int score) {
			super();
			this.lang = lang;
			this.end = end;
			this.career = career;
			this.food = food;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Human [lang=" + lang + ", end=" + end + ", career=" + career + ", food=" + food + ", score=" + score
					+ "]";
		}

	}
}
