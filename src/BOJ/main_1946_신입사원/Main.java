package BOJ.main_1946_신입사원;

import java.util.*;
import java.io.*;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        T = parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = parseInt(br.readLine());

            Queue<Scores> q = new PriorityQueue<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                q.add(new Scores(parseInt(st.nextToken()),parseInt(st.nextToken())));
            }

            int prevBScore = 100001;
            int ans = 0;
            while(!q.isEmpty()){
                int bScore = q.poll().b;
                if(bScore<prevBScore){
                    prevBScore = bScore;
                    ans+=1;
                }
            }
            System.out.println(ans);
        }
    }

    private static class Scores implements Comparable<Scores>{
        int a,b;

        public Scores(int a, int b){
            this.a= a;
            this.b= b;
        }

        @Override
        public int compareTo(Scores o) {
            return a-o.a;
//            return a==o.a?b-o.b:a-o.a;
        }
    }
}
