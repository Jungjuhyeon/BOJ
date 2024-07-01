import java.io.*;
import java.util.*;
public class Main {

    static int N,L,R;
    static boolean[][] v;
    static int[][] ia;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static ArrayList<int[]> list;

    //인구 이동처리 함수
    static int move(){
        int result =0; //총 인구 이동 횟수
        while(true){ 
            boolean isMove = false;
            v = new boolean[N][N]; //방문처리를 위한 v

            for(int i=0; i<N; i++){
                for(int j=0; j<N ; j++){
                    if(!v[i][j]){
                        int sum = bfs(i,j);
                        if(list.size()>1){
                            changePeople(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove){
                return result;
            }
            result++;
        }
    }

    static int bfs(int i,int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        list = new ArrayList<>(); //인구 이동이 일어난 지역들의 좌표를 위한
        v[i][j] = true;
        q.offer(new int[]{i,j});
        list.add(new int[]{i,j});
 
        int sum = ia[i][j]; //총 인구수 변수
        while(!q.isEmpty()){
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for(int d=0; d<4;d++){
                int ni = i+ di[d];
                int nj = j+ dj[d];
                if(ni>=0&& ni<N&& nj>=0 && nj<N && !v[ni][nj]){
                    int diff = Math.abs(ia[i][j] - ia[ni][nj]);
                    if( diff>=L && diff<=R){
                        q.offer(new int[]{ni,nj});
                        v[ni][nj] = true;
                        list.add(new int[]{ni,nj});
                        sum += ia[ni][nj];
                    }
                }
            }
        }
        return sum;
    }

    static void changePeople(int sum){
        int avg = sum/list.size();

        for(int[] a :list){
            int x =a[0];
            int y = a[1];
            ia[x][y] = avg;
        }


//        for(int i=0;i<list.size();i++){
//            int x = list.get(i)[0];
//        }


    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ia = new int[N][N];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                ia[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(ia[i]));
        }
        System.out.println(move());


    }
}
