package BOJ.main_5557_1학년;

import java.io.*;
import java.util.*;

public class Main_dfs_fail {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static long ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,arr[0]);
        System.out.println(ans);
    }

    private static void dfs(int depth, int val) {
        if(depth==N-1){
            if(val == arr[N]) {
                ans++;
            }
        }else{
            int valAdd = val+arr[depth+1];
            int valSub = val-arr[depth+1];

            if(valAdd>=0 && valAdd<=20){
                dfs(depth+1,valAdd);
            }
            if(valSub>=0&&valSub<=20){
                dfs(depth+1,valSub);
            }
        }
    }
}
