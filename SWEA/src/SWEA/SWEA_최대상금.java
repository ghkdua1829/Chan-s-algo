package SWEA;

import java.util.Scanner;

public class SWEA_최대상금 {
    static char[] base;
    static int result,n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC= sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
            String base2 = sc.next();
            base = base2.toCharArray();
            n = sc.nextInt();
            result = Integer.parseInt(base2);
            permu(0,0);
            System.out.println("#" + tc + " " + result);
        }
    }
    static void permu(int k, int su) {
        if(su == n) {
            int p = Integer.parseInt(String.valueOf(base));
            if(result < p) {
                result = p;
            }
            return;
        }
        for(int i = k; i<base.length; i++) {
            for(int j= i; j<base.length; j++) {
                int ni = (int)(base[i]-48);
                int nj = (int)(base[j]-48);
                if(i!=j && ni<=nj) {
                    swap(i, j);
                    permu(i,su+1);
                    swap(j,i);
                }
            }
        }
    }
    static void swap(int i, int j) {
        char tmp = base[i];
        base[i] = base[j];
        base[j] =tmp;
    }
}