
import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (lightCheck(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean lightCheck(int mid) {
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - mid <= prev) {
                prev = arr[i] + mid;
            } else {
                return false;
            }
        }
        if (N - prev > 0) {
            return false;
        } else {
            return true;
        }

    }
}