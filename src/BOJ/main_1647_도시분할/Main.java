package BOJ.main_1647_도시분할;

import java.util.*;
import java.io.*;

import static java.lang.Integer.parseInt;

class Edge implements Comparable<Edge>{
    int a,b;
    int weight;

    @Override
    public int compareTo(Edge o){
        return weight-o.weight;
    }

    public Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N,M;
    static Queue<Edge> edges = new PriorityQueue<>();

    static int parent[];
    static int size[];
    static int ans;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int w = parseInt(st.nextToken());
            edges.add(new Edge(a,b,w));
        }

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        size = new int[N+1];
        Arrays.fill(size,1);


        while(!edges.isEmpty()){
            Edge edge = edges.poll();
            int a = edge.a;
            int b = edge.b;
            int w = edge.weight;
//            System.out.println("edge = " + edge);
            int ap = find(a);
            int bp = find(b);
//            System.out.println("ap = " + ap+ " bp: "+bp);
            if(ap!=bp){
//                System.out.println("union");
                if(size[bp]>size[ap]){
                    ap = ap^bp;
                    bp = ap^bp;
                    ap = ap^bp; //swap
                }

                parent[bp] = ap;
                size[ap] += size[bp];
                size[bp] = 0;
                ans+=w;

                if(size[ap] == N-1){
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }



    private static int find(int idx) {
        if(idx == parent[idx]){
            return idx;
        }else{
            return parent[idx]=find(parent[idx]);
        }
    }
}