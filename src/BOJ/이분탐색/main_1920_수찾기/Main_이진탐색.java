package BOJ.이분탐색.main_1920_수찾기;

import java.io.*;
import java.util.*;

public class Main_이진탐색 {
    public static final StringBuilder sb = new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int arr[];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt((st.nextToken()));
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            binarySearch(N, Integer.parseInt((st.nextToken())));
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    private static void binarySearch(int N, int target) {
        int l = 0 ;
        int r = N -1;

        while(l<=r){
            int m = (l+r)/2;
            if(target ==arr[m]){
                sb.append("1\n");
                return;
            }else if(target <arr[m]){
                r=m-1;
            }else if(target>arr[m]){
                l = m+1;
            }
        }
        sb.append("0\n");
    }
}
