package BOJ.main_1181_단어정렬;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

class Word implements Comparable<Word>{

    String str;

    public Word(String str) {
        this.str = str;
    }

    @Override
    public String toString(){
        return str;
    }

    @Override
    public int compareTo(Word o){
        int l1= str.length();
        int l2= o.str.length();
        if(l1==l2) return str.compareTo(o.str);
        else return l1-l2;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Word> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(new Word(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        String prev ="";
        while(!pq.isEmpty()){
            String cur = pq.poll().str;
            if(cur.equals(prev)) continue;
            sb.append(cur).append('\n');
            prev= cur;
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
