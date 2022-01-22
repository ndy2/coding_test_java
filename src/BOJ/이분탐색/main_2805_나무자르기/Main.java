package BOJ.이분탐색.main_2805_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static int[] arr;
    static long[] sums;
    static long total;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sums = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i-1] + arr[i-1];
        }
        total = sums[N];


        int l = 1;
        int r = arr[N-1];
        int ans= 0;
        while(l<=r){
            int m = (l+r)/2;
            long getTreeHeight = cutTreeHeight(m);
            if(getTreeHeight<M){
                r = m-1;
            }else{
                l = m+1;
                if(m>ans){
                    ans = m;
                }
            }

        }
        System.out.println(ans);
        br.close();
    }

    private static long cutTreeHeight(int cutHeight) {
        long ret = 0;
        for (int i = 0; i <N ; i++) {
            ret += arr[i]>cutHeight?arr[i]-cutHeight:0;
        }
        return ret;
    }
}
