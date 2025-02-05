
import java.io.*;
import java.util.*;
public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance,items;
    static int M,N;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        items = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");

        for(int i =1;i<N+1;i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        distance = new int[N+1];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));
        }

        int answer =0;
        for(int i=1;i<N+1;i++){
            answer = Math.max(answer,dijkstra(i));
        }

        System.out.println(answer);
    }

    public static class Node{
        public int index;
        public int distance;

        public Node(int index,int distance){
            this.index = index;
            this.distance =distance;
        }
    }
    public static int dijkstra(int index){

        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));

        distance[index] =0;
        pq.add(new Node(index,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curDistance = curNode.distance;

            if(curDistance>distance[curIndex]){
                continue;
            }

            for(Node neighbor : graph.get(curIndex)){
                int newDistance = neighbor.distance + curDistance;
                if(newDistance<distance[neighbor.index]){
                    distance[neighbor.index] = newDistance;
                    pq.add(new Node(neighbor.index,newDistance));
                }
            }
        }
        int res = 0;

        for(int i=1;i<N+1;i++){
            if(distance[i]<=M){
                res +=items[i];
            }
        }
        return res;
    }

    /**
     * 해당문제는 하나의 장소에서부터 다른 장소로까지의 거리를 최단으로해서, 갈수 있는지 판단하는 문제이다.
     * 그렇기 때문에, 해당 문제는 최단경로문제이다.
     * 알고리즘은 다익스트라 알고리즘을 활용하면 될 것이다.
     * 다익스트라 알고리즘의 시간복잡도는 O(E logV) 이다.
     */
}
