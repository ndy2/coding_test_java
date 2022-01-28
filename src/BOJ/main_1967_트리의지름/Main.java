package BOJ.main_1967_트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

class Edge{
    int idx;
    int weight;

    public Edge(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}

class Node{
    List<Edge> edges;

    public Node() {
        edges = new ArrayList<>();
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node> tree;
    static boolean[] visited;
    static int maxWeight = 0;
    static int edgeIdx = 0;

    public static void main(String[] args) throws IOException {
        int N = parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N+1];

        tree.add(new Node());
        for (int i = 1; i <= N; i++) {
            tree.add(new Node());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            int w = parseInt(st.nextToken());

            //p->c
            tree.get(p).edges.add(new Edge(c,w));
            //c->p
            tree.get(c).edges.add(new Edge(p,w));
        }
        dfs(1,0);
        visited = new boolean[N+1];
        dfs(edgeIdx,0);
        System.out.println(maxWeight);
    }

    private static void dfs(int idx, int weight) {
        if(visited[idx]){
            return;
        }
        if(weight>maxWeight){
            maxWeight = weight;
            edgeIdx = idx;
        }

        visited[idx] = true;
        for (Edge edge : tree.get(idx).edges) {
            int nextIdx = edge.idx;
            int nextWeight = weight+edge.weight;

            if(!visited[nextIdx]){
                dfs(nextIdx,nextWeight);
            }
        }
    }
}
