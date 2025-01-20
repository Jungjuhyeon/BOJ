
import java.io.*;
import java.util.*;
public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,number));
            graph.get(end).add(new Node(start,number));
        }

        dijkstra(1);

        br.close();
        System.out.println(distance[N]);

    }
    static void dijkstra(int i){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.number,b.number));
        distance[i] =0;

        Node curNode = new Node(i,0);
        pq.offer(curNode);

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int curIndex = node.index;
            int curNumber = node.number;

            if(curNumber>distance[curIndex]){
                continue;
            }

            for(Node neighbor : graph.get(curIndex)){
                int nextNumber = distance[curIndex] + neighbor.number;
                if(nextNumber<distance[neighbor.index]){
                    distance[neighbor.index] = nextNumber;
                    pq.offer(new Node(neighbor.index,nextNumber));
                }
            }
        }
    }
    static class Node{
        int index;
        int number;

        public Node(int index,int number){
            this.index =index;
            this.number =number;
        }
    }
}
