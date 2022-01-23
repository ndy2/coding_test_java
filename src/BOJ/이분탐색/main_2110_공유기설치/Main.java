package BOJ.이분탐색.main_2110_공유기설치;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        C = parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 1;
        int r = arr[N-1]-arr[0];
        int ans = 0;
        while(l<=r){
            int m = (l+r)/2;
            boolean valid = isValid(m);
//            System.out.println("l : " + l + " m : " + m + " r : " + r + " valid : "+ valid);
            if (!valid) {
                r = m-1;
            } else {
                l=m+1;
                ans = Integer.max(ans,m);
            }
        }
        System.out.println(ans);

        br.close();
    }

    private static boolean isValid(int dist) {
        int cur = arr[0];
        int numRouter = 1;
        while(true){
            int target = cur+dist;
            int idx;
            idx = Arrays.binarySearch(arr, target);
            if(idx<0){
                idx = -1*(idx+1);
            }
            if(idx == N){
                return false;
            }
            cur = arr[idx];
            numRouter+=1;
            if(numRouter == C){
                return true;
            }
        }
    }
}
