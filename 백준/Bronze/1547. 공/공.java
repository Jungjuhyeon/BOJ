import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = {false, true, false, false};  //처음 1번 컵에 공이 있다
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //x, y번 컵을 바꿔준다
            boolean temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        for (int i = 1; i <= 3; i++) {
            if (arr[i]) System.out.print(i);
        }
    }
}