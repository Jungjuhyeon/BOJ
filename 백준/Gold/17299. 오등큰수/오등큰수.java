import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strinput = br.readLine().split(" ");
        int[] input = new int[N]; //초반에 숫자 입력한 값

        //초반 숫자 배열
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(strinput[i]);
        }

        //숫자 횟수를 위한 배열
        int[] num_count = new int[1000001];
        for (int i = 0; i < N; i++) {
            num_count[input[i]] += 1;
        }

        //결과값으 넣을 배열
        int[] result = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && num_count[input[stack.peek()]] < num_count[input[i]]) {
                result[stack.pop()] = input[i];
            }
            stack.push(i);


        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
          }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N;i++){
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);

    }
}