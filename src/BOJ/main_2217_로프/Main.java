package BOJ.main_2217_로프;

import java.io.*;
import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(parseInt(br.readLine()));
        }
        Collections.sort(list, (o1, o2) -> o2-o1);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = max(ans,(i+1)*list.get(i));
        }
        System.out.println(ans);
        br.close();
    }
}
