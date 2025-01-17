
import java.io.*;
import java.util.*;
public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));
        }
        st = new StringTokenizer(br.readLine()," ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        long min1 = distance[v1];
        dijkstra(v1);
        min1 += distance[v2];
        dijkstra(v2);
        min1 += distance[N];

        dijkstra(1);
        long min2 = distance[v2];
        dijkstra(v2);
        min2 += distance[v1];
        dijkstra(v1);
        min2 += distance[N];

        long answer = Math.min(min1,min2);
        if(answer>=Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(answer);
        }


    }
    public static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.distance,b.distance));
        pq.offer(new Node(index,0));

        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[index] =0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int curIndex = node.index;
            int curDistance = node.distance;

            if(curDistance>distance[curIndex]){
                continue;
            }

            for(Node neighbor:graph.get(curIndex)){
                int cost = neighbor.distance+distance[curIndex];
                if(cost<distance[neighbor.index]){
                    distance[neighbor.index] = cost;
                    pq.add(new Node(neighbor.index,cost));
                }
            }
        }

    }
    public static class Node{
        int index;
        int distance;

        public Node(int index,int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}

// 다익스트라 알고리즘을 사용
// 플로이드 워샬 -> 800^3으로 최악엔 1초가 초과되기에 안됨.
// 1->v1->v2->N 으로 할때 각 단계마다 다익스트라 알고리즘을 써서 최단거리를 구한다.
// 1->v1->v2->N, 1->v2->v1->N 거리를 구해서 작은 걸 선택해야함.