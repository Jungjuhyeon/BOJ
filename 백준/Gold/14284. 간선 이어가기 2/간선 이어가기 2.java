
import java.io.*;
import java.util.*;


public class Main {
    static int[] distance;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];

        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight)); // 양방향 간선 추가
        }
        st = new StringTokenizer(br.readLine()," ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(distance[end]);
    }

    static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.distance,b.distance));

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[index] =0;

        pq.add(new Node(index,0));

        while(! pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curDistance = curNode.distance;

            if(curDistance> distance[curIndex]){
                continue;
            }

            for(Node neighborNode : list.get(curIndex)){
                int newDistance = neighborNode.distance + distance[curIndex];
                if(newDistance < distance[neighborNode.index]){
                    distance[neighborNode.index] = newDistance;
                    pq.add(new Node(neighborNode.index, newDistance));
                }
            }
        }

    }

    public static class Node{
        int index;
        int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}
