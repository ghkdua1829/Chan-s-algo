package level3;

import java.io.BufferedReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class kakao_1차_추석트래픽 {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		String[] lines = {  "2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		System.out.println(solution(lines));
	}

	static public int solution(String[] lines) {
		int answer = 0;
		List<Traffic> list = new ArrayList<>();
		for (int i = 0; i < lines.length; i++) {
			String[] str = lines[i].split(" ");
			String[] timeStr = str[1].split(":");
			int hour = Integer.parseInt(timeStr[0]); 
			int minute = Integer.parseInt(timeStr[1]);
			String sec = timeStr[2].substring(0, 2);
			String dot = timeStr[2].substring(3, timeStr[2].length());
			String duration = str[2].substring(0, str[2].length() - 1);
			double start = (double) (hour * 3600 + minute * 60 + Double.valueOf(sec)
					+ (double) Double.valueOf(dot) / (double) Math.pow(10, dot.length()) - Double.valueOf(duration)
					+ 0.001);
			
//			System.out.println(start);
			
			double end = (double) (hour * 3600 + minute * 60 + Double.valueOf(sec)
					+ (double) Double.valueOf(dot) / (double) Math.pow(10, dot.length()));
//			System.out.println(end);
			
			list.add(new Traffic(start, end));
//			System.out.println(list.get(i));
		}

		for (int i = 0; i < list.size(); i++) {
			int tempMax = 0;
			double startTime = list.get(i).start;
			double endTime = list.get(i).end;

			for (int j = 0; j < list.size(); j++) {
				double tempStartTime = list.get(j).start;
				double tempEndTime = list.get(j).end;

				if ((startTime <= tempEndTime && startTime + 1 > tempEndTime)
						|| (startTime + 1 > tempStartTime && tempStartTime >= startTime)
						|| (startTime >= tempStartTime && endTime <= tempEndTime)) {
					tempMax++;
//					System.out.println("start" + i + " = " + tempMax);
				}

			}
			if (max < tempMax) {
				max = tempMax;
			}
			tempMax = 0;

			for (int j = 0; j < list.size(); j++) {
				double tempStartTime = list.get(j).start;
				double tempEndTime = list.get(j).end;

				if ((endTime <= tempStartTime && tempStartTime < endTime + 1)
						|| (tempEndTime < endTime + 1 && tempEndTime >= endTime)
						|| (startTime >= tempStartTime && endTime <= tempEndTime)) {
					tempMax++;
//					System.out.println("back" + i + " = " + tempMax);
				}

//				if ((tempStartTime >= startTime && tempStartTime <= startTime + 1000)
//						|| (tempEndTime <= startTime + 1000 && tempEndTime >= startTime)
//						|| (tempEndTime >= endTime - 1000 && tempEndTime <= endTime)
//						|| (tempStartTime >= endTime - 1000 && tempStartTime <= endTime)
//						|| ((endTime + 1000 > tempStartTime) && (endTime <= tempStartTime))
//						|| (startTime - 1000 < tempEndTime && (startTime >= tempEndTime))
//						||(tempStartTime>=startTime && tempEndTime<=endTime)) {
//					
//					tempMax++;
//				}

			}
			if (max < tempMax) {
				max = tempMax;
			}
		}
		answer = max;
		return answer;
	}

	static class Traffic {
		double start, end;

		public Traffic(double start, double end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Traffic [start=" + start + ", end=" + end + "]";
		}

	}
}
