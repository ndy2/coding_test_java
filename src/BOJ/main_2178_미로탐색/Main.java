package BOJ.main_2178_미로탐색;


import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int y,x,dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static boolean[][]map;
    static boolean[][]visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static Queue<Node> q = new LinkedList<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        input();

        bfs();

        System.out.println(ans);
        br.close();
    }

    private static void bfs() {
        visited[0][0] = true;
        q.add(new Node(0,0,1));
        while(!q.isEmpty()){
            Node pos = q.poll();
            if(pos.y==N-1 && pos.x == M-1){
                ans = pos.dist;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int ty = pos.y + dy[d];
                int tx = pos.x + dx[d];

                if(ty>=0 && ty<N && tx>=0 && tx<M && !visited[ty][tx]&& map[ty][tx]){
                    visited[ty][tx] = true;
                    q.add(new Node(ty,tx,pos.dist+1));
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = (line.charAt(c) == '1');
            }
        }
    }


}
