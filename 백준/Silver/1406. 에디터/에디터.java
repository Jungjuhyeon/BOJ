
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0; i<str.length() ; i++) {
            stack1.push(str.charAt(i));
        }

        for(int i=0; i<N ; i++){
            String ch = br.readLine();

            switch (ch.charAt(0)){
                case 'L':
                    if(!stack1.empty()){
                        stack2.push(stack1.pop());
                    }
                    break;
                case 'D':
                    if(!stack2.empty()){
                        stack1.push(stack2.pop());
                    }
                    break;
                case 'B':
                    if(!stack1.empty()) {
                        stack1.pop();
                    }
                    break;
                case 'P':
                    stack1.push(ch.charAt(2));
                    break;
                default:
                    break;

            }
        }

        // 왼쪽 스택에 있는 문자열을 모두 오른쪽 스택에 넣는다.
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // 오른쪽 스택의 내용을 모두 출력용 StringBuilder에 담는다.
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        System.out.println(sb);
    }
}
