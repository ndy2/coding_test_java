package BOJ.main_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.max;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = parseInt(br.readLine());
        arr = new int[N+1][];
        for (int r = 0; r <= N ; r++) {
            arr[r] = new int[r+2];
        }

        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= r ; c++) {
                int in = parseInt(st.nextToken());
                arr[r][c] = in+max(arr[r-1][c-1],arr[r-1][c]);
            }
        }
        Arrays.sort(arr[N]);
        System.out.print(arr[N][N+1]);
        Map<String,Integer> playsMap = new HashMap<>();
        for (String s : playsMap.keySet()) {
            
        }
    }
}
