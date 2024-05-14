import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if ('A' <= c && c <= 'Z') {//비연산자일때
                sb.append(c);
            }
            else if (c != '(' && c != ')') { //괄호가 아닐때
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
            else if( c == '('){ //여는 괄호일때 그냥 삽입
                stack.push(c);
            }
            else{
                while(stack.peek()!='('){ //닫는 괄호는 여는 괄호가 나올때까지 pop
                    sb.append(stack.pop());
                }
                stack.pop();
            }

        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
    public static int priority(Character c){
        if( c == '+' || c == '-' ){
            return 1;
        }
        else if(c == '*' || c =='/'){
            return 2;
        }
        else{
            return 0;
        }
    }
}
