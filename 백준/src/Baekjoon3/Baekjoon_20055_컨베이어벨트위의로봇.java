package Baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int[] using = new int[2 * N];

		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			using[i] = Integer.parseInt(token.nextToken());
		}

//		System.out.println(Arrays.toString(using));

		int time = 0;

		boolean[] robot = new boolean[N];

		while (true) {
			time++;
			// 첫 번째 단계: 벨트를 한 단계 회전시킨다.

			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;

			int usingLast = using[using.length - 1];
			for (int i = using.length - 1; i > 0; i--) {
				using[i] = using[i - 1];
			}
			using[0] = usingLast;

			// 두 번째 단계 : 로봇을 이동시킨다.
			robot[N - 1] = false; // 내려가는 위치의 로봇을 내린다.
			for (int i = robot.length - 2; i >= 0; i--) {
				if (using[i + 1] > 0 && !robot[i + 1] && robot[i]) {
					robot[i + 1] = true;
					robot[i] = false;
					using[i + 1]--;
				}
			}

			// 세번째 단계 : 첫번째 위치에 로봇을 올린다.

			if (using[0] > 0 && !robot[0]) {
				robot[0] = true;
				using[0]--;
			} else {
				robot[0] = false;
			}

			int tempCnt = 0;
			for (int i = 0; i < using.length; i++) {
				if (using[i] <= 0) {
					tempCnt++;
				}
			}
			if (tempCnt >= K) {
				
				break;
			}
		}
		System.out.println(time);
	}

}
