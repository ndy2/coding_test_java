package BOJ.main_1182_partial_sum;


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int sum = 0;
    static int N, S;
    static int arr[] = new int[21];

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);
        if(S == 0) ans-=1;
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }

    private static void backtracking(int i) {
        if(sum == S){
            ans+=1;
        }

        if(i==N){
            return;
        }

        for (int nextIdx = i+1; nextIdx <= N; nextIdx++) {
            sum += arr[nextIdx];
            backtracking(nextIdx);
            sum -= arr[nextIdx];
        }

    }

}
