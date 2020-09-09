package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 기둥과보설치 {
	static List<ResultStructure> result = new ArrayList<>();

	public static void main(String[] args) {
		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 },{ 2, 2, 1, 0 } };
		int n = 5;
		solution(n, build_frame);
	}

	static public int[][] solution(int n, int[][] build_frame) {
		int[][] answer = {};
		int[][] board = new int[n + 3][n + 3];
		int[][] isBuildBo = new int[n + 3][n + 3];
		int[][] isBuildGi = new int[n + 3][n + 3];
		for (int x = 0; x < n + 3; x++) {
			isBuildGi[n + 2][x] = 1;
		}

		for (int r = 0; r < build_frame.length; r++) {
			int x = build_frame[r][0] + 1;
			int y = n + 1 - build_frame[r][1];
			int a = build_frame[r][2]; // 0 -> 기둥 , 1 -> 보
			int b = build_frame[r][3]; // 0 -> 삭제 , 1 -> 설치
			if (b == 1) { // 설치할 때
				if (a == 0) { // 기둥일 때
					if (isBuildBo[y][x - 1] == 1 || isBuildGi[y + 1][x] == 1) {
						result.add(new ResultStructure(x - 1, n + 1 - y, a));
						isBuildGi[y][x] = 1;
					}
				} else { // 보 일 때
					if (isBuildGi[y + 1][x] == 1 || isBuildGi[y + 1][x + 1] == 1 || isBuildBo[y][x - 1] == 1
							|| isBuildBo[y][x + 1] == 1) {
						result.add(new ResultStructure(x - 1, n + 1 - y, a));
						isBuildBo[y][x] = 1;
					}
				}
			} else { // 삭제할 때
				if (a == 0) { // 기둥을 삭제할 때
					isBuildGi[y][x] = 0;
					boolean success = isSuccess(isBuildGi, isBuildBo);
					if (!success) {
						isBuildGi[y][x] = 1;
					} else {
						for (int i = 0; i < result.size(); i++) {
							ResultStructure ss = result.get(i);
							if (ss.x == x - 1 && ss.y == n + 1 - y && ss.kinds == a) {
								result.remove(i);
							}
						}
//						result.remove(new ResultStr	ucture(x - 1, n + 1 - y, a));
						System.out.println(new ResultStructure(x - 1, n + 1 - y, a));
					}
				} else if (a == 1) { // 보를 삭제할 때
					isBuildBo[y][x] = 0;
					boolean success = isSuccess(isBuildGi, isBuildBo);
					if (!success) {
						isBuildBo[y][x] = 1;
					} else {
						for (int i = 0; i < result.size(); i++) {
							ResultStructure ss = result.get(i);
							if (ss.x == x - 1 && ss.y == n + 1 - y && ss.kinds == a) {
								result.remove(i);
							}
						}
//						result.remove(new ResultStructure(x - 1, n + 1 - y, a));
						System.out.println(new ResultStructure(x - 1, n + 1 - y, a));
					}
				}
			}
		}
		Collections.sort(result, new Comparator<ResultStructure>() {

			@Override
			public int compare(ResultStructure o1, ResultStructure o2) {
				if (o1.x < o2.x) {
					return -1;
				} else if (o1.x > o2.x) {
					return 11;
				} else {
					if (o1.y < o2.y) {
						return -1;
					} else if (o1.y > o2.y) {
						return 1;
					} else {
						if (o1.kinds < o2.kinds) {
							return 1;
						} else {
							return -1;
						}
					}
				}
			}
		});
		answer = new int[result.size()][3];
		int i = 0;
		for (ResultStructure r : result) {
			answer[i][0] = r.x;
			answer[i][1] = r.y;
			answer[i][2] = r.kinds;
			i++;
		}

		return answer;
	}

	private static boolean isSuccess(int[][] isBuildGi, int[][] isBuildBo) {
		for (int y = 0; y < isBuildGi.length - 1; y++) {
			for (int x = 0; x < isBuildGi[0].length; x++) {
				if (isBuildGi[y][x] == 1) {
					if (isBuildBo[y][x] == 0 && isBuildBo[y][x - 1] == 0 && isBuildGi[y + 1][x] == 0) {
						return false;
					}
				}
			}
		}
		for (int y = 0; y < isBuildBo.length - 1; y++) {
			for (int x = 0; x < isBuildBo[0].length; x++) {
				if (isBuildBo[y][x] == 1) {
					if ((isBuildGi[y + 1][x] == 1 || isBuildGi[y + 1][x + 1] == 1)
							|| (isBuildBo[y][x - 1] == 1 && isBuildBo[y][x + 1] == 1)) {
					} else {
						return false;
					}
//					if ((isBuildBo[y][x - 1] == 0 && isBuildBo[y][x + 1] == 0)
//							&& (isBuildGi[y + 1][x] == 0 && isBuildGi[y + 1][x + 1] == 0)) {
//						return false;
//					}
				}
			}
		}

		return true;
	}

	static class ResultStructure {
		int x, y, kinds;

		public ResultStructure(int x, int y, int kinds) {
			super();
			this.x = x;
			this.y = y;
			this.kinds = kinds;
		}

		@Override
		public String toString() {
			return "ResultStructure [x=" + x + ", y=" + y + ", kinds=" + kinds + "]";
		}
	}
}
