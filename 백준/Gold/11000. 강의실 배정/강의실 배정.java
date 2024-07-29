import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            ia[i][0] = Integer.parseInt(st.nextToken());
            ia[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(ia,(o1,o2)->Integer.compare(o1[0],o2[0])); //시작시간을 기준으로 정렬.

        pq.offer(ia[0][1]);

        for(int i=1;i<ia.length;i++){
            if(pq.peek()<= ia[i][0]){
                pq.poll();
            }
            pq.offer(ia[i][1]);
        }

        System.out.println(pq.size());

        br.close();
    }
}
