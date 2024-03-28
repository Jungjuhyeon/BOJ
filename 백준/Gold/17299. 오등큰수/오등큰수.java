import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] in = new int[N];
        int[] count = new  int[1000001];
        int[] anw = new int[N];

        for(int i=0; i<N;i++){
            in[i] = Integer.parseInt(st.nextToken());
            count[in[i]]++;
        }

        for(int i=0; i<N; i++) {
            while (!stack.isEmpty() && count[in[stack.peek()]] < count[in[i]]){
                anw[stack.pop()] = in[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            anw[stack.pop()] = -1;
        }

        for(int i =0; i<N; i++){
            sb.append(anw[i]).append(" ");
        }

        System.out.println(sb);

    }
}