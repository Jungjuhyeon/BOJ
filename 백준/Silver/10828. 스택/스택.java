import java.io.*;

import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(bf.readLine());

        Stack<String> stack = new Stack<>();

        for(int i =0; i< len;i++){
            String[] input = bf.readLine().split(" ");
            if(input[0].equals("push")){
                stack.add(input[1]);
            }
            else if(input[0].equals("pop")){
                if (stack.isEmpty()){
                    bw.write(-1+"\n");
                }else {
                    bw.write(stack.pop()+"\n");
                }
            }
            else if(input[0].equals("size")){
                bw.write(stack.size()+"\n");
            }
            else if(input[0].equals("empty")){
                if (stack.isEmpty()){
                    bw.write(1+"\n");
                }else {
                    bw.write(0+"\n");
                }
            }
            else if(input[0].equals("top")){
                if (stack.isEmpty()){
                    bw.write(-1+"\n");}
                else{
                    bw.write(stack.peek()+"\n");
                }
            }
        }
        bw.flush(); 

    }
}
