package BOJ.main_2447_별찍기10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] board;

    public static void main(String[] args)  throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        board = new boolean[N][N];


        fill(N);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(board[r][c]) sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void fill(int n) {
        if(n==1){
            board[0][0]=true;
            return;
        }
        fill(n/3);
        for (int r = 0; r < n/3; r++) {
            for (int c = 0; c < n / 3; c++) {
                board[0+r][n/3+c] = board[r][c];
                board[0+r][2*n/3+c] = board[r][c];
                board[n/3+r][0+c] = board[r][c];
                board[n/3+r][2*n/3+c] = board[r][c];
                board[2*n/3+r][0+c] = board[r][c];
                board[2*n/3+r][n/3+c] = board[r][c];
                board[2*n/3+r][2*n/3+c] = board[r][c];
            }
        }
    }
}
