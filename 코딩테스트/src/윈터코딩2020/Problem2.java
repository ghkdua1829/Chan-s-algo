package 윈터코딩2020;

import java.util.*;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Point> list = new ArrayList<>();
		list.add(new Point(1, 2));
		list.add(new Point(2, 3));
		list.add(new Point(1, 4));
		Collections.sort(list);
		int[] arr= new int[3];
		System.out.println('1');
		String[] strs = new String[2];
		Set<Point> set = new HashSet<>();
		set.add(new Point(1, 2));
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Point top = (Point) it.next();
			System.out.println("asdas"+top.toString());
		}
		

//		Collections.sort(list,new Comparator<Point>(){
//			
//			public int compare(Point p1,Point p2) {
//				return Integer.compare(p1.r,p2.r);
//			}
//		});
//		for (Point p : list) {
//			System.out.println(p);
//		}
	}

	static class Point implements Comparable<Point> {

		@Override
		public int compareTo(Point p) {
			if (p.r > this.r) {
				return 1;
			} else if (p.r < this.r) {
				return -1;
			} else {
				if (p.c > this.c) {
					return 1;
				} else {
					return -1;
				}
			}
		}

		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

}
