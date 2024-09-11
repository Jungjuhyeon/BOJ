import java.io.*;
import java.util.*;
public class Main{
    static boolean[] v;
    static int[] result; //신뢰도 배열
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        result = new int[N + 1];
        list = new List[N+1];

        for(int i=1;i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            BFS(i);
        }
        int big = 0;
        for (int i = 1; i <= N; i++) {
            big = Math.max(big, result[i]);		// 최대값 탐색
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == big) {		// 최대값과 같다면 인덱스 출력
                System.out.print(i + " ");
            }
        }
    }
    public static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        v[n] = true;
        while (!q.isEmpty()) {		// 큐가 비어있을 때까지
            int num = q.poll();
            for (int i : list[num]) {
                if (!v[i]) {	// 방문하지 않은 노드가 나왔을 경우
                    result[i]++;
                    v[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
