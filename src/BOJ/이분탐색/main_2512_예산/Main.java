package BOJ.이분탐색.main_2512_예산;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int arr[];
    static int M;

    public static void main(String[] args) throws IOException{
        N = parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
            sum+=arr[i];
        }
        Arrays.sort(arr);
        M = parseInt(br.readLine());

        if(sum <= M){
            System.out.println(arr[N-1]);
            return;
        }

        int l = 1;
        int r = arr[N-1];
        int ans = 0;
        while(l<=r){
            //상한액의 후보
            int m = (l+r)/2;
            int total = getTotal(m);
//            System.out.println("l : " + l + " m : "+ m+  " r : " + r + " total : " + total);

            //너무 적게 풀었다. 상한액을 늘려봄
            if(total > M ) {
                r = m-1;
            }
            //답이 될 수 있음 한번 더 풀어봄 품 줄여야됨
            else{
                l = m+1;
                ans = Integer.max(ans,m);
            }
        }
        System.out.println(ans);
    }

    private static int getTotal(int upperBound){
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]<upperBound){
                ret +=arr[i];
            }else{
                ret +=upperBound;
            }
        }
        return ret;
    }
}
