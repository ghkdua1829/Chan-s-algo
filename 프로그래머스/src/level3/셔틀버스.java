package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 셔틀버스 {

	public static void main(String[] args) {
		String[] arr = { "08:59", "09:00", "08:02", "08:03" };
		Arrays.sort(arr);
//		for (String str : arr) {
//			System.out.println(str);
//		}

	}

	static public String solution(int n, int t, int m, String[] timetable) {
		Arrays.sort(timetable);
		String answer = "";

		List<Integer> busTime = new ArrayList<Integer>();
		int startBusTime = 540;
		busTime.add(startBusTime);
		for (int i = 0; i < n - 1; i++) {
			startBusTime += t;
			busTime.add(startBusTime);
//			StringBuilder sb = new StringBuilder();
//			sb.append(startBusTime / 60).append(":").append(startBusTime % 60);
		}
		int idx = 0;
		int[][] busArr = new int[busTime.size()][m];
//		Arrays.asList(busArr[0]).contains(0);
		for (int i = 0; i < busArr.length; i++) {
			for (int k = 0; k < m; k++) {
				if (idx >= timetable.length) {
					break;
				}
				String[] timeArr = timetable[idx].split(":");
				int hour = Integer.parseInt(timeArr[0]);
				int minute = Integer.parseInt(timeArr[1]);
				int time = hour * 60 + minute;

				if (time <= busTime.get(i)) {
					idx++;
					busArr[i][k] = time;
				}
			}

		}
//		for (int[] arr : busArr) {
//			System.out.println(Arrays.toString(arr));
//		}
		boolean token = false;
		int[] lastArr = busArr[busTime.size() - 1];
		for (int i = 0; i < lastArr.length; i++) {
			int num = lastArr[i];
			if(num==0) {
				token = true;
//				System.out.println("result : " + Arrays.toString(lastArr));
				int temp =busTime.get(busTime.size()-1);
				int hour = temp/60;
				int minute = temp%60;
				
				answer =String.format("%02d",hour)+":"+String.format("%02d", minute);
				return answer;
			}
		}
		if(token == false) {
			int result = lastArr[m-1]-1;
			int hour = result/60;
			int minute = result%60;
			answer =String.format("%02d",hour)+":"+String.format("%02d", minute);
			return answer;
		}
		
//		System.out.println(answer);

		return answer;
	}

}
