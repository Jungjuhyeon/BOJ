
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static int[] parent;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[N+1];
        parent = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,cost));
        }
        st = new StringTokenizer(br.readLine()," ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        djikstra(from);

        List<Integer> path = new ArrayList<>();
        int cur = to;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);

        System.out.println(distance[to]);        // 최소 비용
        System.out.println(path.size());         // 경로 길이
        for (int city : path) {
            System.out.print(city + " ");
        }
    }
    static void djikstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));
        pq.offer(new Node(index,0));
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[index] =0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curCost = curNode.cost;

            if(curCost > distance[curIndex]){
                continue;
            }

            for(Node nextnode : graph.get(curIndex)){
                int nextCost = curCost + nextnode.cost;
                if(nextCost< distance[nextnode.index]){
                    distance[nextnode.index] = nextCost;
                    parent[nextnode.index] = curIndex;
                    pq.offer(new Node(nextnode.index,nextCost));
                }
            }
        }

    }

    public static class Node{
        int index;
        int cost;
        public Node(int index,int cost){
            this.index =index;
            this.cost =cost;
        }
    }
}
