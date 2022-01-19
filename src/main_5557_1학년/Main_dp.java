package main_5557_1학년;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dp {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstIn = Integer.parseInt(st.nextToken());
        dp[1][firstIn] = 1;

        for (int i = 2; i < N; i++) {
            int in = Integer.parseInt(st.nextToken());
            for (int val = 0; val <=20; val++) {
                long prev = dp[i-1][val];
                if(prev> 0L){
                    if(val - in >=0){
                        dp[i][val-in] += prev;
                    }
                    if(val+in <=20){
                        dp[i][val+in] += prev;
                    }
                }
            }
        }
        int target= Integer.parseInt(st.nextToken());
        System.out.println(dp[N-1][target]);
    }


}
