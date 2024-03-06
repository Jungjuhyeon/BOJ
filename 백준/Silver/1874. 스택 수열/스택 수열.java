import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int now =1;
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<N;i++){
            int num = Integer.parseInt(br.readLine());
            while (now<=num){
                stack.push(now);
                sb.append('+').append('\n');
                now++;
            }
            if(stack.peek() == num){
                stack.pop();
                sb.append('-').append('\n');
            }else{
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}
