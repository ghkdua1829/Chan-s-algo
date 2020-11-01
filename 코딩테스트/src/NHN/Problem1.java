package NHN;

import java.util.Arrays;

public class Problem1 {

	public static void main(String[] args) {
		
	}

	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		Player[] players = new Player[numOfAllPlayers - 1];
		for (int i = 66, j = 0; i < 66 + numOfAllPlayers - 1; i++, j++) {
			players[j] = new Player((char) i, false, 0);
		}

		for (int i = 0; i < players.length; i++) {
			for (int j = 0; j < namesOfQuickPlayers.length; j++) {
				if (players[i].name == namesOfQuickPlayers[j]) {
					players[i].fast = true;
				}
			}
		}

		Player sulae = new Player('A', false, 1);
		int sulaeKan = 0;

		for (int i = 0; i < numOfMovesPerGame.length; i++) {
			int move = numOfMovesPerGame[i];
			int movedKan = (sulaeKan + move + players.length) % players.length;
			if (players[movedKan].fast) {
				// 빠르면 못잡는다.
				sulae.num++;
				sulaeKan = movedKan;
			} else {
				// 느리면 술래 교체
				Player temp = players[movedKan];
				players[movedKan] = sulae;
				sulae = temp;
				sulaeKan = movedKan;
				sulae.num++;
			}
		}
		for(Player p : players) {
			System.out.println(p.name+" "+p.num);
		}
		System.out.println(sulae.name+" "+sulae.num);

	}

	static class Player {
		char name;
		boolean fast;
		int num;

		public Player(char name, boolean fast, int num) {
			super();
			this.name = name;
			this.fast = fast;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Player [name=" + name + ", fast=" + fast + ", num=" + num + "]";
		}

	}
}
