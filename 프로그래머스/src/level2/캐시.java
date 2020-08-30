package level2;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {

	public static void main(String[] args) {

	}

	static public int solution(int cacheSize, String[] cities) {
		int time = 0;
		List<String> list = new ArrayList<String>();
		if(cacheSize==0) {
			return cities.length*5;
		}
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			if (list.contains(city)) {
				list.remove(city);
				list.add(city);
				time++;
			} else {
				time += 5;
				if (list.size() < cacheSize) {
					list.add(city);
				} else {
					if(!list.isEmpty()) {
						list.remove(0);
					}
					list.add(city);
				}
			}
		}
		return time;
	}

}
