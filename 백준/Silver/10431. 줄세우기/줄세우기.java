
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int caseNum = Integer.parseInt(st.nextToken());  // 케이스 번호
            List<Integer> line = new ArrayList<>();
            int moveCount = 0;

            for(int i = 0; i < 20; i++){
                int student = Integer.parseInt(st.nextToken());

                int pos = 0;
                while(pos < line.size() && line.get(pos) < student){
                    pos++;
                }
                moveCount += line.size() - pos;
                line.add(pos, student);  // 해당 위치에 삽입
            }

            System.out.println(caseNum + " " + moveCount);
        }
    }
}
