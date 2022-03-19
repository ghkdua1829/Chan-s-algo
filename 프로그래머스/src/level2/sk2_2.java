package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import level2.sk2_2.Point;

public class sk2_2 {
	public static void main(String[] args) {
		String[] arr = { "1","2","4","3","3","4","1","5" };
		String[] processes = { "read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
		solution(arr, processes);

	}

	public static String[] solution(String[] arr, String[] processes) {
		List<String> list = new ArrayList<>();
		Point[] arrPoint = new Point[processes.length];
		for (int i = 0; i < processes.length; i++) {
			StringTokenizer token = new StringTokenizer(processes[i]);
			String type = token.nextToken();
			int startTime = Integer.parseInt(token.nextToken());
			int doingTime = Integer.parseInt(token.nextToken());
			int startIndex = Integer.parseInt(token.nextToken());
			int endIndex = Integer.parseInt(token.nextToken());
			String changeText = "";
			if (type.equals("write")) {
				changeText = token.nextToken();
			}
			arrPoint[i] = new Point(startTime, doingTime, startIndex, endIndex, type, changeText);

		}
		Arrays.sort(arrPoint);
		Queue<Point> doingQueue = new LinkedList<>();
		Queue<Point> willQueue = new LinkedList<>();
		Queue<Point> waitReadQueue = new LinkedList<>();
		Queue<Point> waitWriteQueue = new LinkedList<>();

		for (int i = 0; i < arrPoint.length; i++) {
			willQueue.offer(arrPoint[i]);
		}

		int doneProcess = 0;
		int sec = -1;
		int resultSec = 0;

		while (doneProcess < processes.length) {
			sec++;
			String secType = "";
			if (!doingQueue.isEmpty()) {
				  resultSec++;
				}
			if (!doingQueue.isEmpty()) {
				secType = doingQueue.peek().type;
			} else {
				if (!waitWriteQueue.isEmpty()) {
					Point doProcess = waitWriteQueue.poll();
					doProcess.endTime = sec + doProcess.doingTime;
					doingQueue.offer(doProcess);
				} else if (!waitReadQueue.isEmpty()) {
					while (!waitReadQueue.isEmpty()) {
						Point doProcess = waitReadQueue.poll();
						doProcess.endTime = sec + doProcess.doingTime;
						doingQueue.offer(doProcess);
					}
				}
			}

			if (!willQueue.isEmpty() && sec == willQueue.peek().startTime) {
				Point doProcess = willQueue.poll();
				doProcess.endTime = sec + doProcess.doingTime;
				if (doingQueue.isEmpty()) {
					doingQueue.offer(doProcess);
				} else {
					if (doProcess.type.equals("write")) {
						waitWriteQueue.offer(doProcess);
					} else {
						if (secType.equals("read") && waitWriteQueue.isEmpty()) {
							doingQueue.offer(doProcess);
						} else {
							waitReadQueue.offer(doProcess);
						}

					}
				}

			}
			while (!doingQueue.isEmpty() && doingQueue.peek().endTime == sec) {
				Point done = doingQueue.poll();
				doneProcess++;
				System.out.println(done);
				if (done.type.equals("write")) {
					for (int i = done.startIndex; i <= done.endIndex; i++) {
						arr[i] = done.changeText;
					}
				} else {
					StringBuilder sb = new StringBuilder();
					for (int i = done.startIndex; i <= done.endIndex; i++) {
						sb.append(arr[i]);
					}
					list.add(sb.toString());
				}
			}
			
			

		}
		list.add(String.valueOf(resultSec));
		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));

		return answer;
	}

	static class Point implements Comparable<Point> {

		int startTime, doingTime, startIndex, endIndex, endTime;
		String type, changeText;

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.startTime, o.startTime);
		}

		public Point(int startTime, int doingTime, int startIndex, int endIndex, String type, String changeText) {
			super();
			this.startTime = startTime;
			this.doingTime = doingTime;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.type = type;
			this.changeText = changeText;
		}

		@Override
		public String toString() {
			return "Point [startTime=" + startTime + ", doingTime=" + doingTime + ", startIndex=" + startIndex
					+ ", endIndex=" + endIndex + ", endTime=" + endTime + ", type=" + type + ", changeText="
					+ changeText + "]";
		}

	}
}
