

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Character> stack1 = new ArrayDeque<>();
        ArrayDeque<Character> stack2 = new ArrayDeque<>();


        for(int i=0; i<N;i++){
            String str = br.readLine();

            for(int j=0; j<str.length();j++){
                char c = str.charAt(j);
                if(c == '<'){
                    if(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                else if(c == '>'){
                    if(!stack2.isEmpty()){
                        stack1.push(stack2.pop());
                    }
                }
                else if(c == '-'){
                    if(!stack1.isEmpty()){
                        stack1.pop();
                    }
                }
                else{
                    stack1.push(c);
                }
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            while(!stack2.isEmpty()){
                sb.append(stack2.pop());
            }
            sb.append("\n");

        }

        System.out.println(sb);


    }
}
