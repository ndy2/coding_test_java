package BOJ.backtraking_N_M.NM1;

import java.util.Scanner;

public class Main {

    static int N,M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N+1];
        arr = new int[N+1];

        dfs(0);
    }

    private static void dfs(int len) {
        if(len == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int idx = 1; idx <= N ; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                arr[len] = idx;
                dfs(len+1);
                visited[idx]=false;
            }
        }
    }
}
