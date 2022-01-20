package BOJ.main_1759_암호만들기;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l,c;
    static List<Character> list = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            list.add(st.nextToken().charAt(0));
        }
        Collections.sort(list);
        visited = new boolean[c];


        bw.write(stringBuilder.toString());
        bw.close();
        br.close();
    }



}
