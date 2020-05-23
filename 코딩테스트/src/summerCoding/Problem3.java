package summerCoding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	public static void main(String[] args) {
		int total_sp = 121;
		int[][] skills = { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } };
		solution(total_sp, skills);
	}

	static public int[] solution(int total_sp, int[][] skills) {
		int[] answer = {};
		int[] up = new int[1000002];
		int[] down = new int[1000002];

		List<Integer>[] list = new List[skills.length + 2];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < skills.length; i++) {
			int tempUp = skills[i][0];
			int tempDown = skills[i][1];

			list[tempUp].add(tempDown);

			up[tempUp]++;
			down[tempDown]++;
		}

		for (List row : list) {
			System.out.println(row);
		}
		int skillCnt = 0;
		int downskillCnt =0;
		for(int i=0;i<1000002;i++) {
			if(up[i]>0) {
				skillCnt+=up[i];
			}
			if(down[i]>0 && up[i]==0) {
				skillCnt++;
				downskillCnt++;
			}
		}
		System.out.println(skillCnt);
		System.out.println(downskillCnt);

		return answer;
	}

	static class Skill {
		int up, down;

		public Skill(int up, int down) {
			super();
			this.up = up;
			this.down = down;
		}

		@Override
		public String toString() {
			return "Skill [up=" + up + ", down=" + down + "]";
		}

	}
}
