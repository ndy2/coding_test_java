package BOJ.main_2448_별찍기11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Scanner scanner = new Scanner(System.in);
    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] board;
    static boolean[][] star0 =
            {
                    {false,false,true, false,false},
                    {false,true, false,true, false},
                    {true, true, true, true, true }
            };

    public static void main(String[] args) throws IOException {

        N = scanner.nextInt();
        int K = getK(N);
        int width = getWidth(K);
        board = new boolean[N][width];

        dfs(K,0,0);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < width; c++) {
                sb.append(board[r][c]?'*':' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void dfs(int k, int height, int padding) {
        if(k==0){
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 5; c++) {
                    board[height+r][padding+c] = star0[r][c];
                }
            }
            return;
        }
        int belowHeight = getN(k - 1);

        dfs(k-1,height, padding+ getWidth(k - 2) +1);
        dfs(k-1, height+belowHeight,padding+0);
        dfs(k-1,height+belowHeight,padding+getWidth(k - 1)+1);
    }

    private static int getWidth(int k) {
        if(k==-1) return 2;
        return 5*(int)Math.pow(2,k)+ (k ==0?0:((int)Math.pow(2,k) -1));
    }
    private static int getK(int n) {
        int ret = 0;
        n/=3;
        while(n!=1){
            n/=2;
            ret++;
        }
        return ret;
    }

    private static int getN(int K) {
        return (int) (3*Math.pow(2,K));
    }
}
