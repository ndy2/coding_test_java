package BOJ.main_9326_열쇠;

import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int TC;
    static int ans;
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;

    public static void main(String[] args) throws IOException{
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            input();
            solve();
            System.out.println(ans);
        }
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for (int c = 0; c <= M+1; c++) {
            map[0][c] = '.';
        }
        for (int r = 1; r <= N; r++) {
            map[r][0] = '.';
            String line = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = line.charAt(c-1);
            }
            map[r][M+1] = '.';
        }
        for (int c = 0; c <= M+1; c++) {
            map[N+1][c] = '.';
        }

        keys = new boolean[26];
        String keysString = br.readLine();
        if(!keysString.equals("0")){
            for (int i = 0; i < keysString.length(); i++) {
                keys[keysString.charAt(i)-'a']=true;
            }    
        }
        ans = 0;
    }

    private static void solve() {
        dfs(0,0);
    }

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    private static void dfs(int r, int c) {
//        debug(r, c);
        if(visited[r][c]){
            return;
        }

        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int ty = r+dy[d];
            int tx = c+dx[d];
            if(ty>=0&& ty<=N+1 && tx>=0 && tx<=M+1 && !visited[ty][tx]){
                char target = map[ty][tx];
                if(target=='*'){
                    continue;
                }else if(target>='a' && target <='z'){
                    keys[target-'a'] = true;
                    map[ty][tx]='.';
                    visited = new boolean[N+2][M+2];
                    dfs(ty,tx);
                }else if(target>='A' && target<='Z'){
                    if(keys[target-'A']){
                        map[ty][tx]='.';
                        dfs(ty,tx);
                    }
                }else if(target =='$'){
                    ans+=1;
                    map[ty][tx]='.';
                    dfs(ty,tx);
                }else if(target =='.'){
                    dfs(ty,tx);
                }

            }
        }
    }

    private static void debug(int r, int c) {
        System.out.println("r = " + r + ", c = " + c);
        for (int i = 0; i < 26; i++) {
            if(keys[i])
                System.out.print((char)((char)(i)+'a')+" ");
        }
        System.out.println();
    }
}
