package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6987_월드컵 {
	static int[] t1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] t2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static Team[] team,temp;
	static boolean good;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			good = false;
			team = new Team[6];
			temp = new Team[6];
			for (int k = 0; k < 6; k++) {
				temp[k] = new Team(0, 0, 0);
			}
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(token.nextToken());
				int draw = Integer.parseInt(token.nextToken());
				int lose = Integer.parseInt(token.nextToken());

				team[j] = new Team(win, draw, lose);
			}
			dfs(0);
			if (good) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");

			}
		}
	}

	private static void dfs(int game) {
		if (game == 15) {
			if (good) {
				return;
			}
			for (int i = 0; i < 6; i++) {
				if (team[i].win == temp[i].win && team[i].lose == temp[i].lose && team[i].draw == temp[i].draw) {

				} else {
					break;
				}
				if (i == 5) {
					good = true;
					return;
				}
			}
		} else {
			int team1 = t1[game];
			int team2 = t2[game];

			temp[team1].win++;
			temp[team2].lose++;
			dfs(game + 1);
			temp[team1].win--;
			temp[team2].lose--;

			temp[team1].lose++;
			temp[team2].win++;
			dfs(game + 1);
			temp[team1].lose--;
			temp[team2].win--;

			temp[team1].draw++;
			temp[team2].draw++;
			dfs(game + 1);
			temp[team1].draw--;
			temp[team2].draw--;
		}

	}

	static class Team {
		int win, draw, lose;

		public Team(int win, int draw, int lose) {
			super();
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}

		@Override
		public String toString() {
			return "Team [win=" + win + ", draw=" + draw + ", lose=" + lose + "]";
		}

	}

}
