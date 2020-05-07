package SWEA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SWEA_4408_자기방으로돌아가기 {

	static List<backRoom> backList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int tc = 1; tc <= count; tc++) {
			backList = new ArrayList<>();
			int studentNum = sc.nextInt();
			for (int i = 0; i < studentNum; i++) {
				int startR = sc.nextInt();
				int endR = sc.nextInt();
				if (startR < endR) {
					backList.add(new backRoom(startR, endR));
				} else
					backList.add(new backRoom(endR, startR));

			}
			backList.sort(new Comparator<backRoom>() {

				@Override
				public int compare(backRoom o1, backRoom o2) {
					Integer firstRoom = o1.startRoom;
					Integer secondRoom = o2.startRoom;
					return firstRoom.compareTo(secondRoom);
				}
			});
			int result = 0;
			while (backList.size() != 0) {
				boolean token = false;
				int end = Integer.MIN_VALUE;

				for (int i = 0; i < backList.size(); i++) {
					if (backList.get(i).startRoom > end) { // 앞 나가는 방숫자보다 뒤 들어오는 숫자가 크면 리스트에서 삭제하기
						if (backList.get(i).startRoom - end == 1 && backList.get(i).startRoom % 2 == 0) {

						} else {
							end = backList.get(i).endRoom;
							backList.remove(i);
							i--;
							token = true;
						}

					}
				}
				if (token == false) {
					backList.remove(0);
				}
				result++;
			}

			System.out.println("#" + tc + " " + result);
			for (backRoom a : backList) {
				System.out.println(a);
			}
		}
	}

	static class backRoom {
		int startRoom, endRoom;

		public backRoom(int startRoom, int endRoom) {
			this.startRoom = startRoom;
			this.endRoom = endRoom;
		}

		@Override
		public String toString() {
			return "backRoom [startRoom=" + startRoom + ", endRoom=" + endRoom + "]";
		}

	}

}
