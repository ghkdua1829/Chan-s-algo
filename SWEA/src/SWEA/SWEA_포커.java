package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class SWEA_포커 {
	static char[] suits;
	static int[] ranks;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			suits = new char[5];
			ranks = new int[5];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				String str = token.nextToken();
				suits[i] = str.charAt(0);
				char tempRank = str.charAt(1);
				switch (tempRank) {
				case 'A':
					ranks[i] = 1;
					break;
				case 'T':
					ranks[i] = 10;
					break;
				case 'J':
					ranks[i] = 11;
					break;
				case 'Q':
					ranks[i] = 12;
					break;
				case 'K':
					ranks[i] = 13;
					break;
				default:
					ranks[i] = tempRank - '0';
					break;
				}

			}
			boolean rSmooth = true;
			boolean suitSame = true;
			boolean loyalflushRanks = false;
			boolean fourCard = true;
			Arrays.sort(ranks);
			int[] loyalFlush = { 1, 10, 11, 12, 13 };

			if (Arrays.toString(loyalFlush).equals(Arrays.toString(ranks))) {
				loyalflushRanks = true;
			}
			char suitFirst = suits[0];
			for (int i = 1; i < suits.length; i++) {
				if (suitFirst != suits[i]) {
					suitSame = false;
					break;
				}
			}

			// 숫자 연속되는지 확인
			int rankFirst = ranks[0];
			for (int i = 1; i < ranks.length; i++) {
				if (rankFirst + 1 != ranks[i]) {
					rSmooth = false;
					break;
				}
				rankFirst = ranks[i];
			}

			int cnt = 0;
			// 포카드 확인
			for (int i = 1; i < ranks.length; i++) {
				if (rankFirst != ranks[i]) {
					if (cnt == 0 ) {
						cnt++;
					} else {
						fourCard = false;
						break;
					}
				}
				rankFirst = ranks[i];
			}
			boolean poolHouse = false;
			// 풀하우스 확인
			if((ranks[0]==ranks[1] && ranks[0]==ranks[2] && ranks[1]==ranks[2] && ranks[3]==ranks[4] && ranks[0]!=ranks[4])||
					(ranks[2]==ranks[3] && ranks[2]==ranks[4] && ranks[3]==ranks[4] && ranks[0]==ranks[1] && ranks[0]!=ranks[4])
					) {
				poolHouse = true;
			}

			if (suitSame && loyalflushRanks) {
				System.out.println("#" + tc + " Straight Flush");
				continue;
			}
			if (suitSame && rSmooth) {
				System.out.println("#" + tc + " Straight Flush");
				continue;
			}
			if(fourCard) {
				System.out.println("#" + tc + " Four of a Kind");
				continue;
			}
			if(poolHouse) {
				System.out.println("#" + tc + " Full House");
				continue;
			}

			System.out.println("#" + tc + " ");
		}
	}

}
