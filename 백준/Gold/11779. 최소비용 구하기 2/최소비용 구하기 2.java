
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static int[] previous;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        previous = new int[N+1];
        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end,cost));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start,end);
        //역추적
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while(cur!=0){
            path.add(cur);
            cur = previous[cur];
        }
        Collections.reverse(path); //올바른 순서로 정렬

        sb.append(distance[end]).append("\n");
        sb.append(path.size()).append("\n");
        for(int i : path){
            sb.append(i).append(" ");
        }

        br.close();
        System.out.println(sb);



    }
    public static class Node{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }

    static void dijkstra(int startIndex, int endIndex){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        distance[startIndex] =0;
        pq.add(new Node(startIndex,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curCost = curNode.cost;

            if(curCost>distance[curIndex]){
                continue;
            }

            for(Node neighbor : graph.get(curIndex)){
                int nextCost = curCost + neighbor.cost;
                if(nextCost<distance[neighbor.index]){
                    distance[neighbor.index] = nextCost;
                    pq.add(new Node(neighbor.index, nextCost));
                    previous[neighbor.index] = curIndex; //이전노드 기록
                }
            }
        }
    }
}

