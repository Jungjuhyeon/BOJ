import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        Stack<Integer> stack =new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i <N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<N; i++){

            while (!stack.isEmpty()&& ar[i] > ar[stack.peek()]) {
                ar[stack.pop()] = ar[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ar[stack.pop()] = -1;
        }

        for(int i =0; i<N;i++){
            sb.append(ar[i]).append(" ");
        }

        System.out.println(sb);

    }

}