import java.util.Scanner;

public class Main_9663_NQueen {

    static int N;
    static boolean[][] board;
    static int ans = 0;
    static int[] dy= {-1,-1,-1};
    static int[] dx= {-1,0,1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        board = new boolean[N][N];

        for (int file = 0; file < N; file++) {
            backtracking(0,file);
        }
        System.out.print(ans);
    }

    private static void backtracking(int rank, int file) {
        //자신의 8방중 왼쪽 위, 오, 오른쪽 위에 퀸이 있는지 확인
        if(!isValidPlace(rank,file)){
            //있으면 리턴
            return;
        }
        //없으면
        // 1. 8th rank 이면 ans 추가 후 리턴
        if(rank==N-1) {
            ans++;
            return;
        }
        board[rank][file] = true;
        for (int col = 0; col < N; col++) {
            backtracking(rank+1, col);
        }
        board[rank][file] = false;
    }

    private static boolean isValidPlace(int rank, int file) {
        for (int d = 0; d < 3; d++) {
            int dist = 1;
            while(true){
                int ty = rank+ dist*dy[d];
                int tx = file+ dist*dx[d];
                if(ty<0||tx<0 || tx>=N) break;
                if(board[ty][tx]) return false;
                dist++;
            }
        }
        return true;
    }
}
