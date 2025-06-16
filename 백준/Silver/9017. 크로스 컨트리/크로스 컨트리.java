
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            Map<Integer,Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine()," ");
            List<Integer> list = new ArrayList<>();

            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num,map.getOrDefault(num,0)+1);
                list.add(num);
            }

            // 6명이 있는 팀만 필터링
            List<Integer> filteredList = new ArrayList<>();
            for (int num : list) {
                if (map.get(num) == 6) {
                    filteredList.add(num);
                }
            }


            // 팀 번호는 최대 200 → 리스트 배열 사용
            List<Integer>[] teamRanks = new ArrayList[201];
            for (int t = 1; t <= 200; t++) {
                teamRanks[t] = new ArrayList<>();
            }

            int rank = 1;
            for (int team : filteredList) {
                teamRanks[team].add(rank++);
            }

            int winner = 0;
            int minScore = Integer.MAX_VALUE;

            for (int t = 1; t <= 200; t++) {
                if (teamRanks[t].size() >= 6) {
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        sum += teamRanks[t].get(k);
                    }

                    if (sum < minScore) {
                        minScore = sum;
                        winner = t;
                    } else if (sum == minScore) {
                        if (teamRanks[t].get(4) < teamRanks[winner].get(4)) {
                            winner = t;
                        }
                    }
                }
            }

            sb.append(winner).append("\n");
        }

        System.out.println(sb);
    }
}


//list 두개로 해서 풀기