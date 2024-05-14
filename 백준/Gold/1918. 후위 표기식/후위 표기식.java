import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static int priority(char chr) {
        int num = 0;
        switch (chr) {
            case '+':
            case '-':
                num = 1;
                break;
            case '*':
            case '/':
                num = 2;
                break;
            case '(':
            case ')':
                num = 0;
                break;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sb.append(input.charAt(i));
            }
            else {
                if (input.charAt(i) == '(') {
                    stack.push(input.charAt(i));
                }

                else if (input.charAt(i) == ')') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        }
                        sb.append(stack.pop());
                    }
                }
                else {
                    while(!stack.isEmpty()&& priority(stack.peek())>=priority(input.charAt(i))){
                        sb.append(stack.pop());
                    }
                    stack.push(input.charAt(i));
                }

            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
