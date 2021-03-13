package level2;

public class 땅따먹기 {

	public static void main(String[] args) {

	}

	int solution(int[][] land) {
		int answer = 0;

		for (int r = 1; r < land.length; r++) {
			land[r][0] += Math.max(land[r-1][1], Math.max(land[r-1][2], land[r-1][3]));
			land[r][1] += Math.max(land[r-1][0], Math.max(land[r-1][2], land[r-1][3]));
			land[r][2] += Math.max(land[r-1][1], Math.max(land[r-1][0], land[r-1][3]));
			land[r][3] += Math.max(land[r-1][1], Math.max(land[r-1][0], land[r-1][2]));
		}
		int endLayer = land.length - 1;
		answer = Math.max(land[endLayer][1],
				Math.max(land[endLayer][0], Math.max(land[endLayer][3], land[endLayer][2])));

		return answer;
	}
}
