package BOJ.main_1504_특정한최단경로;

import java.util.*;
import java.io.*;

import static java.lang.Long.min;
import static java.lang.Integer.parseInt;

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
    public static final int INF = 200_300_400;

    static int N,E;
    static int V1,V2;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        E = parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }



        st = new StringTokenizer(br.readLine());
        V1 = parseInt(st.nextToken());
        V2 = parseInt(st.nextToken());


        int[] cost = new int[N+1];

        dijkstra(1, cost);
        int one2V1 = cost[V1];
        int one2V2 = cost[V2];

        dijkstra(V1, cost);
        int V12V2 = cost[V2];
        int V12N = cost[N];

        dijkstra(V2,cost);
        int V22V1 = cost[V1];
        int V22N = cost[N];

        long pathOne = getPathSum(one2V1, V12V2,V22N);
        long pathTwo = getPathSum(one2V2, V22V1,V12N);
        long ans;
        if(pathOne == -1 && pathTwo == -1){
            ans = -1;
        }else if(pathOne == -1 && pathTwo!=-1){
            ans = pathTwo;
        }else if(pathOne !=-1 && pathOne ==-1){
            ans = pathOne;
        }else{
            ans = min(pathOne, pathTwo);
        }


        System.out.print(ans);
        br.close();
    }

    private static long getPathSum(int a, int b, int c) {
        if(a==INF || b == INF || c ==INF){
            return -1;
        }else{
            return (long)a+(long)b+(long)c;
        }
    }

    private static void dijkstra(int from, int[] cost) {

        Arrays.fill(cost, INF);
        cost[from] = 0;
        boolean[] visited = new boolean[N+1];
        Queue<Node> q = new PriorityQueue<>();

        visited[from] = true;
        q.add(new Node(from,0));

        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curIdx = curNode.end;
            for(Node nextNode : list[curIdx]){
                int nextIdx = nextNode.end;
                int nextWeight = nextNode.weight;

                int nextCost = cost[curIdx]+nextWeight;
                if(cost[nextIdx]>nextCost){
                    cost[nextIdx] = nextCost;
                    q.add(new Node(nextIdx, nextCost));
                }
            }
        }
    }
}
