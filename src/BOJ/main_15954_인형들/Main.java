package BOJ.main_15954_인형들;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Double.min;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static double[] arr;
    static double[] sums;

    static double ans = Double.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        K = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new double[N];
        sums = new double[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
            sums[i+1] = sums[i] + arr[i];
        }

        while(N-K>=0){
            for (int i = 0; i <= N-K; i++) {
                double avg = (sums[i+K]-sums[i])/K;
                double var = 0.0;
                for (int j = 0; j < K; j++) {
                    var += (arr[i+j]-avg)*(arr[i+j]-avg)/K;
                }
                double sd = Math.sqrt(var);
                ans = min(sd, ans);
            }
            K+=1;
        }
        System.out.printf("%.12f",ans);
        br.close();
    }
}
