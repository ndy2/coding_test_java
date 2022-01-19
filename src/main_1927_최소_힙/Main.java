package main_1927_최소_힙;

import java.util.*;
import java.io.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Queue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int op = scanner.nextInt();
            if(op==0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            }else{
                pq.add(op);
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
