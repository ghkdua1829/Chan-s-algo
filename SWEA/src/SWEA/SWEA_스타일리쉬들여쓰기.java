package SWEA;

import java.util.Scanner;

public class SWEA_스타일리쉬들여쓰기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			System.out.println("#"+tc+" ");
			int masterCount = sc.nextInt();
			int myCount = sc.nextInt();
			String[] master = new String[masterCount];
			String[] my = new String[myCount];
		}
	}
	
	static class Point{
		String str;
		int dotNum;
		public Point(String str, int dotNum) {
			this.str = str;
			this.dotNum = dotNum;
		}
		
	}

	static String str = "9\n" + 
			"5 4\n" + 
			"(Follow.my.style\n" + 
			".........starting.from.round.brackets)\n" + 
			"{then.curly.brackets\n" + 
			".....[.and.finally\n" + 
			".......square.brackets.]}\n" + 
			"(Thank.you\n" + 
			"{for.showing.me\n" + 
			"[all\n" + 
			"the.secrets]})\n" + 
			"4 2\n" + 
			"(This.time.I.will.show.you\n" + 
			".........(how.to.use.round.brackets)\n" + 
			".........[but.not.about.square.brackets]\n" + 
			".........{nor.curly.brackets})\n" + 
			"(I.learned\n" + 
			"how.to.use.round.brackets)\n" + 
			"4 2\n" + 
			"(This.time.I.will.show.you\n" + 
			".........(how.to.use.round.brackets)\n" + 
			".........[but.not.about.square.brackets]\n" + 
			".........{nor.curly.brackets})\n" + 
			"[I.have.not.learned\n" + 
			"how.to.use.square.brackets]\n" + 
			"2 2\n" + 
			"(Be.smart.and.let.fear.of\n" + 
			"..(closed.brackets).go)\n" + 
			"(A.pair.of.round.brackets.enclosing\n" + 
			"[A.line.enclosed.in.square.brackets])\n" + 
			"1 2\n" + 
			"Telling.you.nothing.but.you.can.make.it\n" + 
			"[One.liner.(is).(never.indented)]\n" + 
			"[One.liner.(is).(never.indented)]\n" + 
			"2 4\n" + 
			"([{Learn.from.my.KungFu\n" + 
			"...}])\n" + 
			"((\n" + 
			"{{\n" + 
			"[[\n" + 
			"]]}}))\n" + 
			"1 2\n" + 
			"Do.not.waste.your.time.trying.to.read.from.emptiness\n" + 
			"(\n" + 
			")\n" + 
			"2 3\n" + 
			"({Quite.interesting.art.of.ambiguity\n" + 
			"....})\n" + 
			"{\n" + 
			"(\n" + 
			")}\n" + 
			"2 4\n" + 
			"({[\n" + 
			"............................................................]})\n" + 
			"(\n" + 
			"{\n" + 
			"[\n" + 
			"]})";
}
