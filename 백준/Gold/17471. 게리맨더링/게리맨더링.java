import java.util.*;
import java.io.*;

//해당문제는 일단 두 구역으로 나누고, 그 구역들이 연결되어있는지 확인한다. bfs

public class Main {
    static int N;
    static int[] a;
    static boolean[] selected, v;
    static List<Integer>[] p;
    static int result = Integer.MAX_VALUE;


    static void divide(int idx) { //구역 나구기

        if (idx == N) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    list1.add(i);
                } else {
                    list2.add(i);
                }
            }
            if (list1.isEmpty() || list2.isEmpty()) // 한 지역에 몰빵 X
                return;

            if (check(list1) && check(list2)) {
                diff(list1, list2);
            }
            return;
        }

        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);

    }

    static boolean check(List<Integer> list) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v = new boolean[N];
        v[list.get(0)] = true;
        q.offer(list.get(0));

        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < p[cur].size(); i++) {
                int y = p[cur].get(i);
                if (list.contains(y) && !v[y]) {
                    v[y] = true;
                    q.offer(y);
                    count++;
                }
            }
        }
        if (count == list.size()) return true;
        else return false;
    }

    static void diff(List<Integer> list1, List<Integer> list2) {
        int list1_sum = 0, list2_sum = 0;

        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                list1_sum += a[i];
            } else {
                list2_sum += a[i];
            }
        }

        int diff = Math.abs(list1_sum - list2_sum);

        result = Math.min(result, diff);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //구역의 수
        a = new int[N]; //인구 수
        selected = new boolean[N]; //부분집합 만들때 사용
        p = new List[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            p[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                p[i].add(num-1);
            }
//            System.out.println(Arrays.toString(p));
        }

        divide(0);


        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);

        } else {
            System.out.println(result);

        }
    }
}
