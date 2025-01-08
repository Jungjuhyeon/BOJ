
import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static List<List<Node>> graph =new ArrayList<>();
    static int[] distance;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        // 그래프 초기화
        for (int i = 0; i <= 100000; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 그래프 구성
        for (int i = 0; i <= 100000; i++) {
            if (i + 1 <= 100000) graph.get(i).add(new Node(i + 1, 1)); // 앞으로 한 칸
            if (i - 1 >= 0) graph.get(i).add(new Node(i - 1, 1));      // 뒤로 한 칸
            if (2 * i <= 100000) graph.get(i).add(new Node(2 * i, 0)); // 순간이동
        }

        dijkstra(N);

        System.out.println(distance[K]);

    }

    static void dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));
        pq.offer(new Node(index,0));

        distance[index] =0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curCost = curNode.cost;

            if(curCost>distance[curIndex]){
                continue;
            }
            for(Node neighbor : graph.get(curIndex)){
                int cost = curCost + neighbor.cost;

                if(cost <distance[neighbor.index]){
                    distance[neighbor.index] = cost;
                    pq.offer(new Node(neighbor.index,cost));
                }
            }
        }
    }

    static class Node{
        int index;
        int cost;

        public Node(int index,int cost){
            this.index = index;
            this.cost = cost;
        }
    }
}






