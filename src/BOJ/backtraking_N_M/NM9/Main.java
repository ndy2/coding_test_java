package BOJ.backtraking_N_M.NM9;

import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int[] in;
    static int[] arr;
    static int[] save;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N];
        arr = new int[9];
        save = new int[9];
        visited = new boolean[9];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(in);
        for (int i = 1; i <= N; i++) {
            arr[i] = in[i-1];
        }

        dfs(0,0);
        set.forEach(System.out::println);
    }

    private static void dfs(int idx, int len) {
        if(visited[idx]){
            return;
        }
        visited[idx] = true;
        save[len]=arr[idx];
        if(len == M){
            for (int i = 1; i <= M; i++) {
                sb.append(save[i] +" ");
            }
            set.add(sb.toString());
            sb.setLength(0);
        }else{
            for(int i = 1 ; i <=N ; i++){
                dfs(i,len+1);
            }
        }
        visited[idx] = false;
    }
}
