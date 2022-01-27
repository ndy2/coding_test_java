package BOJ.main_2437_저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static Set<Integer> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int in = Integer.parseInt(st.nextToken());
            Iterator<Integer> iter= set.iterator();
            Set<Integer> addedSet = new HashSet<>();
            while(iter.hasNext()){
                addedSet.add(iter.next()+in);
            }
            set.add(in);
            set.addAll(addedSet);
        }
        list.addAll(set);
        Collections.sort(list);

        int ans = 0;
        int weight= 1;

        while(true){
            if(weight>list.size()|| list.get(weight-1)!= weight){
                ans = weight;
                break;
            }
            weight++;
        }
        System.out.println(ans);
    }
}
