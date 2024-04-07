import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if('A'<=ch && ch<='Z' ){
                double d =arr[ch - 'A'];
                stack.push(d);
            }
            else{
                if(!stack.isEmpty()) {
                    double d1 = stack.pop();
                    double d2 = stack.pop();
                    switch (ch) {
                        case '+':
                            stack.push(d1 + d2);
                            break;
                        case '-':
                            stack.push(d2 - d1);
                            break;
                        case '*':
                            stack.push(d1 * d2);
                            break;
                        case '/':
                            stack.push(d2/d1);
                    }
                }
            }

        }

        System.out.printf("%.2f", stack.pop());
    }
}
