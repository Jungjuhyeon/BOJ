import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        String last = null;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String[] input = (br.readLine()).split(" ");

            switch (input[0]){
                case "push":
                    int j =Integer.parseInt(input[1]);
                    queue.add(j);
                    last = input[1];
                    break;
                case "pop":
                    if(queue.size()==0)
                        sb.append("-1").append('\n');
                    else{
                        sb.append(queue.poll()).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.size()==0)
                        sb.append("1").append('\n');
                    else{
                        sb.append("0").append('\n');
                    }
                    break;
                case "front":
                    if(queue.size()==0)
                        sb.append("-1").append('\n');
                    else{
                        sb.append(queue.peek()).append('\n');
                    }
                    break;
                case "back":
                    if(queue.size()==0)
                        sb.append("-1").append('\n');
                    else{
                        sb.append(last).append('\n');
                    }
                    break;

            }

        }
        System.out.println(sb);


    }

}