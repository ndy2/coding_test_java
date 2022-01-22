package BOJ.이분탐색.main_1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,targetAmount;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        targetAmount = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long l = 1;
        long r = arr[N-1];
        long ans =0;
        long m;
        while(l<=r){
            m = (l+r)/2;
            int curAmount = 0;
            for (int a : arr) {
                curAmount += a / m;
            }
//            System.out.println("l: " + l + " m:  "+ m + " r: " + r +" curAmount :" + curAmount);
            if(curAmount<targetAmount){
                r = m-1;
            }else{
                l = m+1;
                if(m>ans){
                    ans = m;
                }
            }
        }
        System.out.println(ans);
    }
}
