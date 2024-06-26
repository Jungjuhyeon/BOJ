import java.io.*;
import java.util.*;

//치킨거리 완전히 뿌시기
public class Main {
    static int N,M;
    static int[][] a,b;

    static int[][] home,chicken;
//    static int[] check;
    static int min = Integer.MAX_VALUE;

    static int total =0,final_total =Integer.MAX_VALUE;

    static void comb(int cnt, int start){
        if(cnt == M){
            total =0;
            for(int i=0;i<home.length;i++){
                min =Integer.MAX_VALUE;
                for(int j=0;j<M;j++){
                    int len = Math.abs(home[i][0]-b[j][0]) + Math.abs(home[i][1]-b[j][1]);
                    if(len<min){
                        min = len;
                    }
                }
                total += min;
            }
            if(total<final_total){
                final_total = total;
            }
            return;
        }
        for(int i=start;i<chicken.length;i++){
            b[cnt] = chicken[i];
            comb(cnt+1,i+1);
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a= new int[N][N];


        ArrayList<int[]> home_list = new ArrayList<>();
        ArrayList<int[]> chicken_list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] ==1) home_list.add(new int[]{i+1,j+1});
                if(a[i][j] ==2) chicken_list.add(new int[]{i+1,j+1});
            }
//            System.out.println(Arrays.toString(a[i]));
        }

        home = new int[home_list.size()][2];
        chicken = new int[chicken_list.size()][2];

        b=new int[chicken.length][2];


        for(int i=0; i<home.length;i++){
            home[i] = home_list.get(i);
        }
        for(int i=0; i<chicken.length;i++){
            chicken[i] = chicken_list.get(i);
        }



        comb(0,0);

        System.out.println(final_total);





    }
}

