import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(bf.readLine());

        String input = bf.readLine();

        double[] input_int = new double[N];
        for(int i=0; i<N; i++){
            input_int[i] = Integer.parseInt(bf.readLine());
        }


        for(int i=0; i<input.length();i++){
            if(input.charAt(i)>='A'&& input.charAt(i)<='Z'){
                stack.push(input_int[input.charAt(i)-'A']);
            }
            else{
                double second = stack.pop();
                double first = stack.pop();

                switch (input.charAt(i)){
                    case '+':
                        stack.push(first+second);
                        break;
                    case '-':
                        stack.push(first-second);
                        break;
                    case '*':
                        stack.push(first*second);
                        break;
                    case '/':
                        stack.push(first/second);
                        break;
                }

            }

        }
        System.out.printf("%.2f", stack.pop());


    }
}