package level2;

public class 방금그곡 {
	static Music music = new Music(Integer.MAX_VALUE, 0, "");

	public static void main(String[] args) {
	}

	static public String solution(String m, String[] musicinfos) {
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		m = m.replaceAll("A#", "a");
//		System.out.println(m);
		

		for (int i = 0; i < musicinfos.length; i++) {
			String[] array = musicinfos[i].split(",");
			String[] startTime = array[0].split(":");
			String[] endTime = array[1].split(":");
			int gapHours = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
			int gapMinutes = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);

			int gapTime = gapHours * 60 + gapMinutes;
			int songLength = gapTime;
			String songTitle = array[2];
			String score = array[3];
			score = score.replaceAll("C#", "c");
			score = score.replaceAll("D#", "d");
			score = score.replaceAll("F#", "f");
			score = score.replaceAll("G#", "g");
			score = score.replaceAll("A#", "a");

			StringBuilder sb = new StringBuilder();
			for (int t = 0; t < gapTime; t++) {
//				if(score.charAt(t % score.length())=='#') {
//					gapTime++;
//				}
				sb.append(score.charAt(t % score.length()));
			}
			String ss = sb.toString();
			if (ss.contains(m)) {
				if(music.songLength<songLength) {
					music = new Music(i,songLength,songTitle);
				}
			}
		}
//		System.out.println(music);
		String answer = music.songTitle;
		if(music.originalIndex==Integer.MAX_VALUE) {
			return "(None)";
		}
		return answer;
	}

	static class Music {
		int originalIndex, songLength;
		String songTitle;

		public Music(int originalIndex, int songLength, String songTitle) {
			super();
			this.originalIndex = originalIndex;
			this.songLength = songLength;
			this.songTitle = songTitle;
		}

		@Override
		public String toString() {
			return "Music [originalIndex=" + originalIndex + ", songLength=" + songLength + ", songTitle=" + songTitle
					+ "]";
		}

	}
}
