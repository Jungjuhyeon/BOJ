import java.io.*;
import java.util.*;

//pq 사용

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            ia[i][0] = Integer.parseInt(st.nextToken());
            ia[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ia,(o1,o2)->Integer.compare(o1[0],o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(ia[0][1]);

        for(int i=1;i<N;i++){
            if(ia[i][0]>= pq.peek()) pq.poll();

            pq.add(ia[i][1]);
        }

        System.out.println(pq.size());

    }
}

//0과 1을 붙여야할 것 같은데