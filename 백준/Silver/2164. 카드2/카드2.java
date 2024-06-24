import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        for(int i=1;i<=N;i++){
            queue.offer(i);
        }

        while(true){
            if(queue.size()==1){
                break;
            }
            queue.poll();
            if(queue.size()==1) {
                break;
            }

            queue.offer(queue.poll());

        }

        System.out.println(queue.poll());


    }
}
