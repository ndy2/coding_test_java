package BOJ.이분탐색.main_10815_숫자카드;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main_HashSet {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    static int N,M;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(parseInt(st.nextToken()));
        }
        M = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = parseInt(st.nextToken());

            if(set.contains(target)){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
