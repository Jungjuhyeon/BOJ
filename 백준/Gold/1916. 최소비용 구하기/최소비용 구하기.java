
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] distance;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,cost));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        dijkstra(start);

        System.out.println(distance[from]);

    }
    public static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[index] = 0;

        pq.add(new Node(index,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curDistance = curNode.cost;

            if(curDistance> distance[curIndex]){
                continue;
            }

            for(Node nextNode : graph.get(curIndex)){
                int newDistance = curDistance + nextNode.cost;
                if(newDistance < distance[nextNode.index]){
                    distance[nextNode.index] = newDistance;
                    pq.offer(new Node(nextNode.index,newDistance));
                }
            }
        }

    }
    static class Node{
        int index;
        int cost;

        public Node(int index,int cost){
            this.index =index;
            this.cost = cost;
        }
    }
}


