import java.io.*;
import java.util.*;

public class Main {
    static int R,C,count=1,K,sum=0;
//    static int[][] a;
    static char[][] ia;
    static boolean[][] v ;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};



    static void dfs(int i,int j,int count){
        if( i ==0 && j ==C-1){
            if(count == K){
                ++sum;
            }
            return;
        }
        v[i][j] = true;
        for(int d=0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0&& nj>=0 && ni<R && nj <C && !v[ni][nj] && ia[ni][nj] !='T'){
                dfs(ni,nj,count+1);
            }
        }
        v[i][j] = false;

    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ia = new char[R][C];

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0; j<C;j++){
                char c = str.charAt(j);
                ia[i][j] = c;
            }
        }
        v = new boolean[R][C];
//        a = new int[R][C];

        dfs(R-1,0,1);

        System.out.println(sum);

    }
}


//도착 한 값이 6ㄱ와 같다면 sum ++;
//그리고 뒤로 돌아가면 해당 값을 v = false로 전환해둠.
