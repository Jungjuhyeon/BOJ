import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean check = false;

        for(int i =0 ; i<str.length();i++){
            char c = str.charAt(i);
            if(c == '<'){
                check = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            }
            else if(c == '>'){
                check = false;
                sb.append(c);
            }
            else if (check){
                sb.append(c);
            }
            else if(!check){
                if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }
                else{
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
