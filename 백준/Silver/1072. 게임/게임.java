import java.util.*;
import java.io.*;

public class Main {

    static int X,Y,Z;

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1); // 승률 100% 근접 시 불가능
            return;
        }

        long left = 1;
        long right = 1000000000;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long newRate = (Y + mid) * 100 / (X + mid);

            if (newRate > Z) {
                right = mid; // 가능한 경우, 더 작은 값 확인
            } else {
                left = mid + 1; // 승률 증가 못함, 더 큰 값 필요
            }
        }

        System.out.println(left);
    }
}