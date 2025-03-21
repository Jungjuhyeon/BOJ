

import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static List<Node> nodeList = new ArrayList<>();
    static List<Edge> edgeList = new ArrayList<>();

    static int[] p;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        for(int i=1;i<N+1;i++){
            p[i] = i;
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(x,y));
        }

        // 이미 연결된 간선 처리
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }

        for(int i=0;i<N-1;i++){
            Node firNode = nodeList.get(i);
            for(int j=1;j<N;j++){
               Node secNode = nodeList.get(j);

               double dis = Math.sqrt(Math.pow(firNode.x - secNode.x, 2) +
                       Math.pow(firNode.y - secNode.y, 2));

                edgeList.add(new Edge(i+1,j+1,dis));

            }
        }

        edgeList.sort((a, b) -> Double.compare(a.disatnce, b.disatnce));

        double total =0;

        for(Edge edge : edgeList){
            if(union(edge.a,edge.b)){
                total += edge.disatnce;
            }
        }

        System.out.printf("%.2f\n", total);



    }

    static boolean union(int x,int y){
        int rootA = find(x);
        int rootB = find(y);

        if(rootA != rootB){
            p[rootB] = rootA;
            return true;
        }
        return false;
    }

    static int find(int i){
        if(p[i] !=i){
            p[i] = find(p[i]);
        }
        return p[i];
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        int a, b;
        double disatnce;
        public Edge(int a, int b, double disatnce) {
            this.a = a;
            this.b = b;
            this.disatnce = disatnce;
        }

    }
}

