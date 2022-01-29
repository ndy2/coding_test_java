package BOJ.main_1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N,M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        boolean[][] board = new boolean[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for (int r = 1; r <= N; r++) {
            String line = br.readLine();
            for (int c = 1; c <= M; c++) {
                board[r][c] = line.charAt(c-1)=='1';
            }
        }
        int ans = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if(board[r][c]){
//                    System.out.println("r : " + r + "c : " + c);
                    int leftMax = dp[r-1][c];
                    int aboveMax = dp[r][c-1];
                    
                    
                    if(leftMax==aboveMax){
                        if(board[r-aboveMax][c-leftMax]){
                             dp[r][c] = leftMax+1;
                        }else{
                            dp[r][c] = leftMax;
                        }
                    }else{
                        dp[r][c] = min(leftMax+1,aboveMax+1);
                    }
                    if(dp[r][c]==0){
                        dp[r][c] = 1;
                    }
//                    System.out.println("dp[r][c] = " + dp[r][c]);
                }
                ans = max(dp[r][c], ans);
            }
        }
        System.out.println(ans*ans);
        br.close();
    }
}
