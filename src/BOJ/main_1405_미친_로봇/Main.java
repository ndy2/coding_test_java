package BOJ.main_1405_미친_로봇;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] p = new int[4];
    static boolean[][] visited = new boolean[29][29];
    static double ans = 0.0;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        for (int d = 0; d < 4; d++) {
            p[d] = parseInt(st.nextToken());
        }

        int initY = 14;
        int initX = 14;
        visited[initY][initX] = true;
        dfs(initY,initX, 0,1.0);
        System.out.printf("%.12f",ans);

        br.close();
    }

    private static void dfs(int r, int x, int depth, double prop){
        if(depth == N){
            ans += prop;
        }else{
            for (int d = 0; d < 4; d++) {
                int ty = r + dy[d];
                int tx = x + dx[d];
                if(!visited[ty][tx]){
                    visited[ty][tx] = true;
                    dfs(ty,tx,depth+1,prop*p[d]/100);
                    visited[ty][tx] = false;
                }
            }
        }

    }
}
