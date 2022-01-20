package BOJ.main_1149_RGB_거리;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = parseInt(br.readLine());
        dp = new int[N+1][3];
        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c0 = parseInt(st.nextToken());
            int c1 = parseInt(st.nextToken());
            int c2 = parseInt(st.nextToken());
            dp[r][0] = c0 + min(dp[r-1][1],dp[r-1][2]);
            dp[r][1] = c1 + min(dp[r-1][2],dp[r-1][0]);
            dp[r][2] = c2 + min(dp[r-1][0],dp[r-1][1]);
        }
        System.out.print(min(min(dp[N][0],dp[N][1]),dp[N][2]));
    }

}
