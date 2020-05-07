package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SWEA_9659_다항식계산 {
	static int[] a, b, t;
	static long[] x, fun;

	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(token.nextToken());
		int mod = 998244353;
		for (int tc = 1; tc <= TC; tc++) {
			a = new int[100];
			b = new int[100];
			t = new int[100];
			x = new long[100];
			fun = new long[100];

			token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());

			for (int i = 2; i <= N; i++) {
				token = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(token.nextToken());
				a[i] = Integer.parseInt(token.nextToken());
				b[i] = Integer.parseInt(token.nextToken());

			}

			StringBuilder sb = new StringBuilder();
			int M = Integer.parseInt(br.readLine());
			
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(token.nextToken());
				fun[0] = 1;
				fun[1] = num;
				for (int j = 2; j <= N; j++) {
					if (t[j] == 1) {
						fun[j] = (fun[a[j]] + fun[b[j]]) % mod;
					} else if (t[j] == 2) {
						fun[j] = (a[j] * fun[b[j]]) % mod;
					} else if (t[j] == 3) {
			               fun[j] = (fun[a[j]] * fun[b[j]]) % mod;
					}
				}
				sb.append(fun[N]+" ");
//				System.out.println(fun[N]);

			}

			System.out.println("#" + tc + " " + sb);
		}
	}

}
