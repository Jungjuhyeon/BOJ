
import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] distance;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        distance = new int[100001];
        Arrays.fill(distance,Integer.MAX_VALUE);

        bfs(N);

        System.out.println(distance[K]);

    }

    public static void bfs(int start){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        distance[start] =0;

        while(!dq.isEmpty()){
            int curIndex = dq.poll();
            int dist = distance[curIndex];

            if(curIndex == K){
                return;
            }

            //+1할때
            if(curIndex+1<=100000 && distance[curIndex+1] > dist+1){
                distance[curIndex+1] = dist+1;
                dq.addLast(curIndex+1);
            }
            //-1할때
            if(curIndex-1>=0 && distance[curIndex-1] > dist+1){
                distance[curIndex-1] = dist+1;
                dq.addLast(curIndex-1);
            }
            if(curIndex*2<=100000 && distance[curIndex*2] > dist){
                distance[curIndex*2] = dist;
                dq.addFirst(curIndex*2);
            }

        }
    }
}


/**
 * 처음에 해당 문제는 다익스트라로 풀었음.
 * 하지만 BFS 0-1 알고리즘으로 풀게된다면 선형연산으로 O(E+V)시간복잡도를 가진다고 해서 이로 풀 예정
 * 다익스트라로 풀 경우, 우선순위큐로 연산이 필요하므로 O(ElogV)or O(ElogE)
 * 1. 5 17 이 주어지면 5를 먼저 덱큐에 집어넣는다.
 * 2. 5의 -1 ,+1는 1초가 걸리므로, 덱큐 뒤로 넣고 dist[] 배열에 1로 초기화한다.
 * 3. 5의 *2는 0초가 걸리므로, 덱큐 앞으로 넣고 dist[]배열에 0으로 초기화한다.
 * 4. 이렇게하고 17에 도착했을 경우, 리턴을 시킨다.
 */