
import java.util.*;
import java.io.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int N,D;
    static int[] distance;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0;i<=D;i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[D+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(end>D){
                continue;
            }
            graph.get(start).add(new Node(end,cost));
        }

        // 직선 거리 초기화 (1씩 증가)
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        dijkstra(0);

        System.out.println(distance[D]);


    }

    static void dijkstra(int index){

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        pq.offer(new Node(index,0));
        distance[index] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            // 이미 처리된 거리보다 크다면 무시
            if(dist>distance[now]){
                continue;
            }

            // 현재 노드와 연결된 모든 노드 확인
            for (Node neighbor : graph.get(now)) {
                int cost = dist + neighbor.distance;

                // 더 짧은 경로 발견 시 거리 갱신
                if (cost < distance[neighbor.index]) {
                    distance[neighbor.index] = cost;
                    pq.offer(new Node(neighbor.index, cost));
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
