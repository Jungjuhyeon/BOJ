
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arg = new String[n];
        for(int i=0;i<n;i++){
            arg[i] = br.readLine();
        }

        Arrays.sort(arg);
        int count =0;
        for(int i=0;i<n;i++){
            if(i==n-1){
                count++;
                continue;
            }
            if(!arg[i+1].startsWith(arg[i])){
                count++;
            }
        }

        System.out.println(count);
    }
}
