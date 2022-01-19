package main_13549_숨바꼭질3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N,M;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        boolean[] visited = new boolean[100001];
        Queue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0,M));
        while(true){
            Info cur = pq.poll();
            visited[cur.pos] = true;
            if(cur.pos==N){
                System.out.println(cur.time);
                return;
            }

            if(cur.pos%2==0 && !visited[cur.pos/2]){
                pq.add(new Info(cur.time, cur.pos/2));
            }
            if(cur.pos-1>=0 && !visited[cur.pos-1]){
                pq.add(new Info(cur.time+1, cur.pos-1));
            }
            if(cur.pos+1<=100000 && !visited[cur.pos+1]){
                pq.add(new Info(cur.time+1, cur.pos+1));
            }

        }
    }

    private static class Info implements Comparable<Info> {
        int time;
        int pos;
        @Override
        public int compareTo(Info o){
            return time-o.time;
        }

        public Info(int time, int pos) {
            this.time = time;
            this.pos = pos;
        }
    }
}
