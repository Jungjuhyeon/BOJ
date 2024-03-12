import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }
        //1,2,3,4,5..N

        int count =1; //순서 counting

        sb.append("<");

        while(!(queue.size()==1)){
            if(count ==K){
                sb.append(queue.poll()).append(", ");
                count = 1;
            }
            else{
                queue.add(queue.poll());
                count ++;
            }
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb);


    }
}

