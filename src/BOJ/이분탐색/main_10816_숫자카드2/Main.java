package BOJ.이분탐색.main_10816_숫자카드2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(' ');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
