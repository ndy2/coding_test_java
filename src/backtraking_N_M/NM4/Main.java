package backtraking_N_M.NM4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[8];


        dfs(0,0);
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    private static void dfs(int idx, int len) {
        arr[len] = idx;
        if(len==M){
            for (int i = 1; i <=M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i <= N; i++) {
            if(i==0) continue;
            dfs(i,len+1);
        }
    }
}
