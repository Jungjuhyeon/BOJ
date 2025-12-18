
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] a= new boolean[101][101];
        int answer =0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x;j<x+10;j++){
                for(int z=y; z<y+10;z++){
                    if(!a[j][z]) {
                        a[j][z] = true;
                        answer++;
                    }
                }
            }

        }
        System.out.println(answer);

    }
}
