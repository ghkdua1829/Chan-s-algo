package NHN;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	static int result=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void solution(int day, int width, int[][] blocks) {
		int[] board = new int[width];
		for (int i = 0; i < blocks.length; i++) {
			int[] block = blocks[i];
			for (int j = 0; j < block.length; j++) {
				board[j] += block[j];
			}
			int left=0,right=0;
			while(left!=width-1) {
				if(board[left]<=board[left+1]) {
					left++;
				}else {
					for(int k=left+1;k<width;k++) {
						if(board[k-1]<board[k]
							&& ((k==width-1) || board[k]>=board[k+1])){
							right = k;
							break;
						}
					}
					
					if(left==right) {
						break;
					}else {
						int min = Math.min(board[left], board[right]);
						
						for(int k=left+1;k<right;k++) {
							result+=min-board[k];
							board[k]=min;
						}
						left=right;
					}
				}
			}
		}
		System.out.println(result);
	}
}
