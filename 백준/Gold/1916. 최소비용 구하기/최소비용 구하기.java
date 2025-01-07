
import java.io.*;
import java.util.*;
public class Main {

    static int N,M;
    static List<List<Node>> graph = new ArrayList<>();

    static int[] distance;


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,cost));
        }
        st = new StringTokenizer(br.readLine()," ");

        int finalStart = Integer.parseInt(st.nextToken());
        int finalEnd = Integer.parseInt(st.nextToken());

        dijkstra(finalStart);

        System.out.println(distance[finalEnd]);
    }

    static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        pq.offer(new Node(index,0));
        distance[index] = 0;

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int curIndex = nowNode.index;
            int curCost = nowNode.cost;

            if(curCost >distance[curIndex]){
                continue;
            }

            for(Node neighbor : graph.get(curIndex)){
                int cost = curCost + neighbor.cost;

                if(cost<distance[neighbor.index]){
                    distance[neighbor.index] = cost;
                    pq.offer(new Node(neighbor.index,cost));
                }
            }

        }
    }

    static class Node{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }
}
