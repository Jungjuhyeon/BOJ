
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int X;
    static int[] distance;
    static int[] endDistance;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        distance = new int[N+1];
        endDistance = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,weight));
        }

        dijkstra(X);
        for(int i=0;i<=N;i++){
            endDistance[i] = distance[i];
        }

        int max = 0;
        for(int i=1;i<=N;i++){
            dijkstra(i);
            endDistance[i] += distance[X];
        }

        Arrays.sort(endDistance);
        System.out.println(endDistance[N-1]);


    }
    static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[index] = 0;

        pq.add(new Node(index,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curDistance = curNode.distance;

            if(curDistance>distance[curIndex]){
                continue;
            }

            for(Node neighbor : graph.get(curIndex)){
                int cost = neighbor.distance + distance[curIndex];
                if(cost<distance[neighbor.index]){
                    distance[neighbor.index] = cost;
                    pq.add(new Node(neighbor.index,cost));
                }
            }
        }
    }

    static class Node{
        int index;
        int distance;

        public Node(int index,int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}
