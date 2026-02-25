
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] arg = new String[n];
            boolean available = true;

            for(int i=0;i<n;i++){
                arg[i] = br.readLine();
            }

            Arrays.sort(arg);
            for(int i=0;i<n-1;i++){
                if(arg[i+1].startsWith(arg[i])){
                    available = false;
                    break;
                }
            }
            if(available){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
