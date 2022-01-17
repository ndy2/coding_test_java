package backtraking_N_M.NM2;

import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr = new int[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        dfs(0,0);
    }

    private static void dfs(int i, int pos) {
        arr[pos] = i;
        if(pos == M){
            for (int l = 1; l <= M; l++) {
                System.out.print(arr[l] +" ");
            }
            System.out.println();
            return ;
        }

        for (int j = i+1; j <= N; j++) {
            dfs(j,pos+1);
        }
    }


}
