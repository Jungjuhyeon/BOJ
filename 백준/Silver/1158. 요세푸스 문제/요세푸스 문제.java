import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] ary = br.readLine().split(" ");
        int count =1;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();

        int N = Integer.parseInt(ary[0]);
        int K = Integer.parseInt(ary[1]);

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            if(count ==K){
                queue1.add(queue.remove());
                count = 1;
            }
            else{
                queue.add(queue.remove());
                count ++;
            }
        }

        int queue1_size = queue1.size();
        sb.append('<');
        for(int i=1;i<=queue1_size;i++) {
            sb.append(queue1.remove());
            if (!(i == queue1_size)) {
                sb.append(", ");
            }
        }
        sb.append('>');

        System.out.println(sb);


    }
}
