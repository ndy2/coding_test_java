package main_1753_최단경로_2트;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

class Node implements Comparable<Node>{
    int end, weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main_1753_최단경로_2트 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000;

    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = parseInt(st.nextToken());
        e = parseInt(st.nextToken());
        k = parseInt(br.readLine());

        list = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[v+1];
        Arrays.fill(dist,INF);


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = parseInt(st.nextToken());
            int v = parseInt(st.nextToken());
            int w = parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i]==INF?"INF":dist[i] + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        boolean[] check = new boolean[v + 1];


        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIdx = curNode.end;

            if(check[curIdx]) continue;
            check[curIdx] = true;

            for (Node nextNode : list[curIdx]) {
                int nextIdx = nextNode.end;
                int nextWeight = nextNode.weight + dist[curIdx];

                if(dist[nextIdx] > nextWeight){
                    dist[nextIdx] = nextWeight;
                    pq.add(new Node(nextIdx,nextWeight));
                }

            }
        }
    }
}
