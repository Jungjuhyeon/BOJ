
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static char[][] a;
    static boolean[][] v;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        a = new char[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                char c = str.charAt(j);
                a[i][j]= c;
            }
        }

        int answer = 0;
        v = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j]){
                    dfs(i,j,false);
                    answer++;
                }
            }
        }
        sb.append(answer).append(" ");

        answer = 0;
        v = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!v[i][j]){
                    dfs(i,j,true);
                    answer++;
                }
            }
        }
        sb.append(answer);

        System.out.println(sb);

    }

    public static void dfs(int i,int j,boolean type){
        v[i][j] = true;
        for(int d=0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && ni<N && nj>=0 && nj<N && !v[ni][nj]){

                if(type){
                    if(a[i][j] == 'G'){
                        a[i][j] = 'R';
                    }
                    if(a[ni][nj] == 'G'){
                        a[ni][nj] = 'R';
                    }
                }

                if(a[i][j] == a[ni][nj]){
                    dfs(ni,nj,type);
                }
            }
        }
    }
}
