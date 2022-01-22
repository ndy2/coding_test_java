package BOJ.이분탐색.main_10815_숫자카드;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int arr[];

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = parseInt(st.nextToken());
            int l = 0;
            int r = N-1;
            String append = "0 ";
            while(l<=r){
                int m = (l+r)/2;
                if(arr[m] == target){
                    append ="1 ";
                    break;
                }else if(arr[m] < target){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
            sb.append(append);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
