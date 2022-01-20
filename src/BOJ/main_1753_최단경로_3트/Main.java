package BOJ.main_1753_최단경로_3트;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight-o.weight;
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int INF = 100_000_000;

    static int v,e,k;
    static ArrayList<Node>[] list;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v+1];
        for (int i = 1; i <= v ; i++) {
            list[i] = new ArrayList<>();
        }

        cost = new int[v+1];
        Arrays.fill(cost,INF);

        for (int i = 1 ; i <=e; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[f].add(new Node(t,w));
        }


        dijkstra(k);

        //Print
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(cost[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(cost[i]+"\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();
        cost[start] = 0;
        q.add(new Node(start,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curIdx = cur.end;
            int curWeight = cur.weight;

            for (Node next : list[curIdx]) {
                int nextIdx = next.end;
                int nextWeight = next.weight;

                if(cost[nextIdx]>cost[curIdx] + nextWeight){
                    cost[nextIdx] = cost[curIdx] + nextWeight;
                    q.add(new Node(nextIdx, cost[curIdx] + nextWeight));
                }
            }

        }
    }


}
