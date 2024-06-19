import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
       // System.setIn(new FileInputStream("res/input_bj_1244.txt")); //이를 사용하자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] ia = new int[N];

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            ia[i]= Integer.parseInt(st.nextToken()); //스위치 입력
        }

        int student = Integer.parseInt(br.readLine()); //학색수

        int[][] a = new int[student][2];

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<student;i++){
            int gender = a[i][0];
            int number = a[i][1];
            if(gender==1){ //남학생이면
                for (int j = number - 1; j < N; j += number) {
                    ia[j] = ia[j] == 0 ? 1 : 0;
                }
            }else if(gender==2) {
                int left = number - 1;
                int right = number - 1;
                // 중심 스위치 변경
                ia[left] = ia[left] == 0 ? 1 : 0;

                // 좌우 대칭으로 스위치 상태 변경
                while (left > 0 && right < N - 1) {
                    left--;
                    right++;
                    if (ia[left] == ia[right]) {
                        ia[left] = ia[left] == 0 ? 1 : 0;
                        ia[right] = ia[right] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }

            }
        }
        for(int i=0;i<N;i++){
            sb.append(ia[i]).append(" ");
            if((i+1)%20 ==0){
                sb.append("\n");
            }
        }
        System.out.print(sb);

    }
}
