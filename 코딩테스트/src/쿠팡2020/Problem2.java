package 쿠팡2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import 쿠팡2020.Problem2.Kiosk;

public class Problem2 {

	public static void main(String[] args) {
//
//		Kiosk[] arr = new Kiosk[3];
//		arr[0] = new Kiosk(1, 0, 0);
//		arr[1] = new Kiosk(2, 1, 0);
//		arr[2] = new Kiosk(3, 2, 0);
//		Arrays.sort(arr, new Comparator<Kiosk>() {
//
//			@Override
//			public int compare(Kiosk o1, Kiosk o2) {
//				if (o1.completeTime > o2.completeTime) {
//					return 1;
//				} else if (o1.completeTime < o2.completeTime) {
//					return -1;
//				} else {
//					if (o1.id > o2.id) {
//						return 1;
//					} else {
//						return -1;
//					}
//				}
//			}
//
//		});

		int n = 2;
		String[] customer = { "02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01" };
		solution(n, customer);
	}

	static public int solution(int n, String[] customer) {
		int answer = 0;
		Kiosk[] arr = new Kiosk[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Kiosk(i, 0, 0);
		}
		for (int i = 0; i < customer.length; i++) {
			String cust = customer[i];
			Arrays.sort(arr, new Comparator<Kiosk>() {
				@Override
				public int compare(Kiosk o1, Kiosk o2) {
					if (o1.completeTime > o2.completeTime) {
						return 1;
					} else if (o1.completeTime < o2.completeTime) {
						return -1;
					} else {
						if (o1.id > o2.id) {
							return 1;
						} else {
							return -1;
						}
					}
				}

			});
			boolean allUsing = true;
			for (int j = 0; j < arr.length; j++) {
				int kioskCompleteTime = arr[j].completeTime;
				if (getTime(cust) > kioskCompleteTime) {
					Kiosk temp = arr[j];
					arr[j] = new Kiosk(temp.id, getCompleteTime(cust), temp.cnt + 1);
					allUsing = false;
					break;
				}
			}
			if(allUsing) {
				Kiosk temp = arr[0];
				arr[0] = new Kiosk(temp.id, getCompleteTime(cust), temp.cnt + 1);
			}

		}

		for (int i = 0; i < arr.length; i++) {
			answer = Math.max(answer, arr[i].cnt);
		}

		System.out.println(answer);
		return answer;
	}

	static int getTime(String time) {
		int month = Integer.valueOf(time.substring(0, 2));
		int day = Integer.valueOf(time.substring(3, 5));
		int hour = Integer.valueOf(time.substring(6, 8));
		int min = Integer.valueOf(time.substring(9, 11));
		int sec = Integer.valueOf(time.substring(12, 14));

		int result = sec + (min * 60) + (hour * 60 * 60) + (day * 60 * 60 * 60) + (month * 60 * 60 * 60 * 60);
		return result;
	}

	static int getCompleteTime(String input) {
		int result = getTime(input) + (Integer.valueOf(input.substring(15, 17)) * 60);

		return result;
	}

	static class Kiosk {
		int id, completeTime, cnt;

		public Kiosk(int id, int completeTime, int cnt) {
			super();
			this.id = id;
			this.completeTime = completeTime;
			this.cnt = cnt;
		}



	}
}
