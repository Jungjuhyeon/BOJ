
import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static int[] answer;
    static int N;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        indegree = new int[N+1];

        for(int i=0;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        answer =new int[N+1];
        Arrays.fill(answer, 1);

        bfs();

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
    static void bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(indegree[i] ==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int i = q.poll();
            for(int j : graph[i]){
                indegree[j]--;
                answer[j] = Math.max(answer[j], answer[i] + 1);
                if (indegree[j]==0) {
                    q.offer(j);
                }
            }
        }
    }

}

/**
 * 해당 문제는 선수과목이 있다는 것에서, 위상정렬 알고리즘이 적용이 된다.
 * 위상정렬의 시간 복잡도는 O(V+E)이다. 해당 문제는 시간 제합이 5초이기에,
 * O(1000+500000)로 만족이 된다.
 */
