package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

public class Baekjoon_14891_톱니바퀴 {
	static ArrayList<Integer>[] list = new ArrayList[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			list[i] = new ArrayList<Integer>();
			for (int s = 0; s < str.length(); s++) {
				list[i].add(Character.getNumericValue((str.charAt(s))));
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int topNum = Integer.parseInt(token.nextToken());
			int rotate = Integer.parseInt(token.nextToken());

			// true 이면 가만히 false 이면 반대로 돌기
			boolean AB = (list[0].get(2) == list[1].get(6)) ? true : false;
			boolean BC = (list[1].get(2) == list[2].get(6)) ? true : false;
			boolean CD = (list[2].get(2) == list[3].get(6)) ? true : false;

			if(rotate==-1) {
				rotateTimeReverse(list[topNum-1]);
			}else {
				rotateTime(list[topNum-1]);
			}
			boolean[] rotateList = { AB, BC, CD };
			switch (topNum - 1) {
			case 0:
				for(int r=0;r<rotateList.length;r++) {
					if(!rotateList[r]) {
						if (rotate == -1) {
							rotateTime(list[r+1]);
						} else {
							rotateTimeReverse(list[r+1]);
						}
						rotate *= -1;
					}else {
						break;
					}
				}
				break;
			case 1:
				if(!AB) {
					if (rotate == -1) {
						rotateTime(list[0]);
					} else {
						rotateTimeReverse(list[0]);
					}
				}
				if(!BC) {
					if (rotate == -1) {
						rotateTime(list[2]);
					} else {
						rotateTimeReverse(list[2]);
					}
					rotate *= -1;
				}else {
					break;
				}
				if(!CD) {
					if (rotate == -1) {
						rotateTime(list[3]);
					} else {
						rotateTimeReverse(list[3]);
					}
				}
				break;
			case 2:
				if(!CD) {
					if (rotate == -1) {
						rotateTime(list[3]);
					} else {
						rotateTimeReverse(list[3]);
					}
				}
				if(!BC) {
					if (rotate == -1) {
						rotateTime(list[1]);
					} else {
						rotateTimeReverse(list[1]);
					}
					rotate *= -1;
				}else {
					break;
				}
				if(!AB) {
					if (rotate == -1) {
						rotateTime(list[0]);
					} else {
						rotateTimeReverse(list[0]);
					}
				}
				break;
			case 3:
				for(int r=2;r>=0;r--) {
					if(!rotateList[r]) {
						if (rotate == -1) {
							rotateTime(list[r]);
						} else {
							rotateTimeReverse(list[r]);
						}
						rotate *= -1;
					}else {
						break;
					}
				}
				break;
			}
		}
		int result =0;
		if(list[0].get(0)==1) {
			result+=1;
		}
		if(list[1].get(0)==1) {
			result+=2;
		}
		if(list[2].get(0)==1) {
			result+=4;
		}
		if(list[3].get(0)==1) {
			result+=8;
		}
		System.out.println(result);
	}

	public static void rotateTime(ArrayList<Integer> l) {
		int temp =l.remove(7);
		l.add(0, temp);
	}

	public static void rotateTimeReverse(ArrayList<Integer> l) {
		int temp =l.remove(0);
		l.add(temp);
	}

}
