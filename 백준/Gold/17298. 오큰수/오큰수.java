import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strinput = br.readLine().split(" ");
        int[] input = new int[N];

        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(strinput[i]);
        }


        for(int j =0; j<N;j++){

            while(!stack.empty() && input[stack.peek()] < input[j]){
                input[stack.pop()] = input[j];
            }

            stack.push(j);
        }

        while(!stack.empty()){
            input[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<N; i++){
            sb.append(input[i]).append(' ');
        }
        System.out.println(sb);


    }

}