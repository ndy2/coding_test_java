package BOJ.main_13305_주유소;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> cost = new ArrayList<>();
    static List<Integer> dist = new ArrayList<>();
    static int curCost=0;
    static long distSum = 0;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            dist.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost.add(Integer.parseInt(st.nextToken()));
        }
        curCost = cost.get(0);
        for (int i = 0; i < N-1; i++) {
            int c = cost.get(i);
            int d = dist.get(i);
            if(curCost<=c) {
                distSum+=d;
            }else{
                ans+=curCost*distSum;
                curCost=c;
                distSum=d;
            }
        }
        ans+=curCost*distSum;
        System.out.println(ans);
    }
}
