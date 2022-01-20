package BOJ.main_1799_비숍;


import java.io.*;
import java.util.*;


public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[][] board;
    static List<Coor> list = new ArrayList<>();
    static boolean[] visited;
    static int len;
    static int maxDepth = 0;

    public static void main(String[] args) throws IOException{

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[4*N-2];

        board = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if((st.nextToken()).equals("1")){
                    board[r][c] = true;
                    list.add(new Coor(r,c));
                }
            }
        }
        list.forEach(System.out::println);
        br.close();

        len = list.size();
        for (int i = 0; i < len; i++) {
            dfs(0,1);
        }
        System.out.println(maxDepth);
    }

    private static void dfs(int idx, int depth) {
        Coor coor = list.get(idx);
        if(coor.isOverlapped()){
            return;
        }
        coor.visit();
        maxDepth = Integer.max(maxDepth,depth);

        for (int i = idx+1; i < len; i++) {
            dfs(i, depth+1);
        }
        coor.unvisit();
    }

    static class Coor{
        int r,c;
        int d1,d2;

        public Coor(int r, int c) {
            this.r = r;
            this.c = c;
            this.d1 = r+c;
            this.d2 = (3*N-2)-(c-r);
        }

        @Override
        public String toString() {
            return "Coor{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d1=" + d1 +
                    ", d2=" + d2 +
                    '}';
        }

        public boolean isOverlapped() {
            return visited[d1]||visited[d2];
        }

        public void visit() {
            visited[d1] = true;
            visited[d2] = true;
        }

        public void unvisit() {
            visited[d1] = false;
            visited[d2] = false;
        }
    }
}
