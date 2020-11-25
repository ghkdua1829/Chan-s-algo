package Baekjoon4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon_1325_효율적인해킹2 {
	static int N,M;
    static boolean visit[];
    static int arr[];
    static ArrayList<Integer> arrList[]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrList = new ArrayList[N+1];
        arr = new int[N+1];
        
        for(int i=1; i<=N; i++)
            arrList[i] = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrList[u].add(v);
        }
        
        for(int i=1; i<=N; i++) {
            visit = new boolean[N+1];
            bfs(i);
        }
        
        int max = 0;
        
        for(int i=1; i<=N; i++) {
            max = Math.max(max, arr[i]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            if(arr[i] == max)
                sb.append(i+" ");
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sb.toString());
    }
    public static void bfs(int index) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visit[index] = true;
        
        while(!queue.isEmpty()) {
            int val = queue.poll();
            for(int i=0; i<arrList[val].size(); i++) {
                int v = arrList[val].get(i);
                if(!visit[v]){
                    visit[v] = true;
                    arr[v]++;
                    queue.add(v);
                }
            }
        }
    }
}
