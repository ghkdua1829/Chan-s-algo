package Toss_코딩테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Problem3 {
	public static void main(String[] args) throws IOException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfYear = new SimpleDateFormat("yy년 M월 d일");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String nowStr = br.readLine();
		Date now = sdf.parse(nowStr);

		for (int i = 0; i < N; i++) {
			String dateStr = br.readLine();
			try {
				Date date = sdf.parse(dateStr);
				
				Long gap = now.getTime() - date.getTime();
				if (gap < 0) {
					System.out.println("error");
				} else {
					int diffDay = (int) (gap / 1000 / 60 / 60 / 24);
					int diffHour = (int) (gap / 1000 / 60 / 60 - (diffDay * 24));
					int diffMinute = (int) (gap / 1000 / 60 - (diffDay * 24 * 60) - (diffHour * 60));
					int diffSecond = (int) ((gap / 1000 - (diffDay * 24 * 60 * 60) - (diffHour * 60 * 60) - (diffMinute * 60)));
					if(diffDay>=365) {
						System.out.println(sdfYear.format(date));
						continue;
					}
					if(diffDay>30) {
						System.out.println(diffDay/30+"개월 전");
						continue;
					}else if(diffDay>=1) {
						System.out.println(diffDay+"일 전");
						continue;
					}
					if(diffHour>=1) {
						System.out.println(diffHour+"시간 전");
						continue;
					}
					if(diffMinute>=1) {
						System.out.println(diffMinute+"분 전");
						continue;
					}
					System.out.println("방금 전");
				}

			} catch (Exception e) {
				System.out.println("error");
			}
		}

	}

}
