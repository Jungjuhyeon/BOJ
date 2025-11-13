
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] a;
    static int[] dj = {-1,0,1,0};
    static int[] di = {0,1,0,-1};
    static boolean[][] v;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        a = new int[N][N];
        v = new boolean[N][N];
        List<Integer> lists = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                int num = str.charAt(j)-'0';
                a[i][j] = num;
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(a[i][j] == 1){
                    if(!v[i][j]){
                        int count = bfs(i,j);
                        lists.add(count);
                    }

                }
            }
        }
        Collections.sort(lists);

        StringBuilder sb = new StringBuilder();
        sb.append(lists.size()).append("\n");
        for(int i=0;i<lists.size();i++){
            sb.append(lists.get(i)).append("\n");
        }

        System.out.println(sb);

    }

    static int bfs(int i,int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        v[i][j] =true;
        int count =1;

        while(!q.isEmpty()) {
            int[] ij = q.poll();
            int curI = ij[0];
            int curJ = ij[1];

            for (int d = 0; d < 4; d++) {
                int ni = curI+di[d];
                int nj = curJ+dj[d];
                if(ni>=0 && ni<N && nj >=0 && nj<N && !v[ni][nj]){
                    if(a[ni][nj] == 1){
                        q.offer(new int[]{ni,nj});
                        v[ni][nj]= true;
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
