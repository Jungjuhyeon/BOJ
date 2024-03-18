
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int sum =0;

        String razy = br.readLine();

        for(int i =0; i<razy.length();i++){
            char c = razy.charAt(i);
            if( c ==  '('){
                stack.push(c);
            }
            else if(c == ')'){
                stack.pop();
                if(razy.charAt(i-1)=='('){
                    sum += stack.size();
                }else{
                    sum+=1;
                }
            }
        }
        System.out.println(sum);

    }
}