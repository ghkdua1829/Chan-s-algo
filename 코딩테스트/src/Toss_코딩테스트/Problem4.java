package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Store> map = new HashMap();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(",");
			if (!map.containsKey(str[0])) {
				map.put(str[0], new Store(1, Integer.parseInt(str[1])));
			} else {
				map.put(str[0],
						new Store(map.get(str[0]).visitCnt + 1, map.get(str[0]).money + Integer.parseInt(str[1])));
			}
		}
		int maxVisit = 0;
		int maxMoney = 0;
		Iterator<String> keys = map.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			Store top = map.get(key);
			maxVisit = Math.max(maxVisit, top.visitCnt);
			maxMoney = Math.max(maxMoney, top.money);
		}
		TreeMap<String, Store> tm = new TreeMap<String, Store>(map);

		Iterator<String> iteratorKey = tm.keySet().iterator(); // 키값 오름차순 정렬(기본)

		StringBuilder sbV = new StringBuilder();
		StringBuilder sbM = new StringBuilder();
		List<String> listV = new ArrayList<String>();
		List<String> listM = new ArrayList<String>();
		Iterator<String> keyss = map.keySet().iterator();

		while (iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			Store top = map.get(key);
//			System.out.println(top.visitCnt+","+maxVisit);
			if (top.visitCnt == maxVisit) {
//				sbV.append(key + ",");
				listV.add(key);
			}
			if (top.money == maxMoney) {
//				sbM.append(key + ",");
				listM.add(key);
			}
		}
		Collections.sort(listV, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(listM, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < listV.size(); i++) {
			sbV.append(listV.get(i) + ",");
		}
		for (int i = 0; i < listM.size(); i++) {
			sbM.append(listM.get(i) + ",");
		}
		System.out.println(sbM.toString().substring(0, sbM.toString().length() - 1));
		System.out.println(sbV.toString().substring(0, sbV.toString().length() - 1));
	}

	static class Store {
		Integer visitCnt, money;

		public Store(Integer visitCnt, Integer money) {
			super();
			this.visitCnt = visitCnt;
			this.money = money;
		}

		@Override
		public String toString() {
			return "Store [cnt=" + visitCnt + ", money=" + money + "]";
		}

	}
}
