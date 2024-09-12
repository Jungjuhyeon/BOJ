import java.util.*;
import java.io.*;

public class Main {
    static int[] ar;
    static int N;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        ar = new int[N];


        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }
        // 배열은 반드시 정렬되어있어야한다.
        Arrays.sort(ar);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            int a = Integer.parseInt(st.nextToken());
            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
            if(dd( a) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);

    }
    static int dd(int i){
        int left = 0;
        int right = ar.length -1;

        while(left<=right){
            int mid = (left+right)/2;

            // key값이 중간 위치의 값보다 작을 경우
            if(i < ar[mid]) {
                right = mid - 1;
            }
            // key값이 중간 위치의 값보다 클 경우
            else if(i > ar[mid]) {
                left = mid +1;
            }
            // key값과 중간 위치의 값이 같을 경우
            else {
                return mid;            }
        }
        return -1;
    }
}
