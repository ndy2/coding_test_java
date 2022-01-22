package BOJ.이분탐색.main_1920_수찾기;

import java.io.*;
import java.util.StringTokenizer;

class BinaryTree {
    static Node root;

    void addNode(Node node){
        if(root == null){
            root = node;
        }else{
            Node cur = root;
            Node next = cur;
            while(true){
                if(cur.data<node.data){
                    next = cur.r;
                    if(next==null){
                        cur.r = node;
                        break;
                    }
                }else{
                    next = cur.l;
                    if(next==null){
                        cur.l = node;
                        break;
                    }
                }
                cur = next;
            }
        }
    }

    int exist(int data){
        Node cur = root;
        while(cur!=null){
            if(cur.data == data){
                return 1;
            }else{
                if(cur.data<data){
                    cur = cur.r;
                }else{
                    cur = cur.l;
                }
            }
        }
        return 0;
    }
}

class Node {
    int data;
    Node l;
    Node r;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt((st.nextToken()));
            binaryTree.addNode(new Node(data));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt((st.nextToken()));
            sb.append(binaryTree.exist(target)).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
