package 코드챌린지2;

import java.util.*;


public class Problem4 {

	public static void main(String[] args) {
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = { { "SEOUL", "DAEJEON" }, { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" },
				{ "DAEJEON", "GWANGJU" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "BUSAN" }, { "GWANGJU", "BUSAN" } };
		solution(depar, hub, dest, roads);
	}

	static public int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < roads.length; i++) {
			String start = roads[i][0];
			String end = roads[i][1];
			if (!map.containsKey(start)) {
				map.put(start, new ArrayList<String>());
			}
			map.get(start).add(end);
		}
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(depar, false));
		while (!queue.isEmpty()) {
			Point top = queue.poll();

			for (int s = 0; s < map.get(top.city).size(); s++) {
				String nextCity = map.get(top.city).get(s);
				if (nextCity.equals(hub)) {
					queue.offer(new Point(nextCity, true));
				} else if (nextCity.equals(dest)) {
					if (top.visit) {
						answer++;
					}
				} else {
					queue.offer(new Point(nextCity, top.visit));
				}

			}
		}
		System.out.println(answer);
		return answer;
	}

	static class Point {
		String city;
		boolean visit;

		public Point(String city, boolean visit) {
			super();
			this.city = city;
			this.visit = visit;
		}

	}

}
