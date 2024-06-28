import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
//        Arrays.sort(ia);
//        System.out.println(Arrays.toString(ia));

        int sum =0;

        while(pq.size()>1){
            int min1 = pq.poll();
            int min2 =  pq.poll();

            sum += min1+min2;

            pq.offer(min1+min2);
        }

        /*
        int sum =0;
        if(N==1){
            System.out.println(ia[0]);
        }else if(N==2){
            System.out.println(ia[0]+ia[1]);
        }
        else {
            sum =ia[0]+ia[1];
            for (int i = 2; i < N; i++) {
                sum = sum * 2 + ia[i];
            }
        }

         */
        System.out.println(sum);
    }
}
