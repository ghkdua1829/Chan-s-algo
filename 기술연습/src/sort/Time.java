package sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	public static void main(String[] args) {

		String strStartDate = "20170101";
		String strEndDate = "20161231";
		String strFormat = "yyyyMMdd"; // strStartDate 와 strEndDate 의 format

		// SimpleDateFormat 을 이용하여 startDate와 endDate의 Date 객체를 생성한다.
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		try {
			Date startDate = sdf.parse(strStartDate);
			Date endDate = sdf.parse(strEndDate);

			// 두날짜 사이의 시간 차이(ms)를 하루 동안의 ms(24시*60분*60초*1000밀리초) 로 나눈다.
			long diffDay = (startDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000);
			System.out.println(diffDay + "일");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	static class Point{
		int r,c;

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
