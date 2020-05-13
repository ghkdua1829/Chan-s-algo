package Baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2477_참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Byun[] arr = new Byun[6];
		int[] dirs = new int[4];
		for (int i = 0; i < 6; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(token.nextToken());
			int width = Integer.parseInt(token.nextToken());
			arr[i] = new Byun(dir, width);
			dirs[dir - 1]++;
		}

		int garoBig = 0;
		int seroBig = 0;
		int garoBigIdx = -1;
		int seroBigIdx = -1;
		for (int i = 0; i < 6; i++) {
			int tmpdir = arr[i].dir;
			int tmpwidth = arr[i].width;
			if (tmpdir == 3 || tmpdir == 4) {
				if (tmpwidth > seroBig) {
					seroBig = tmpwidth;
					seroBigIdx = i;
				}
			} else {
				if (tmpwidth > garoBig) {
					garoBig = tmpwidth;
					garoBigIdx = i;
				}
			}
		}
		int garoSmall = 0;
		int seroSmall = 0;
		if (dirs[0] == 2 && dirs[3] == 2 || dirs[1] == 2 && dirs[2] == 2) {
			garoSmall = arr[(4 + garoBigIdx) % 6].width;
			seroSmall = arr[(seroBigIdx + 2) % 6].width;
		} else {
			garoSmall = arr[(garoBigIdx + 2) % 6].width;
			seroSmall = arr[(4 + seroBigIdx) % 6].width;

		}

		System.out.println((garoBig * seroBig - garoSmall * seroSmall) * K);

	}

	static class Byun {
		int dir, width;

		public Byun(int dir, int width) {
			super();
			this.dir = dir;
			this.width = width;
		}

		@Override
		public String toString() {
			return "Byun [dir=" + dir + ", width=" + width + "]";
		}

	}

}
