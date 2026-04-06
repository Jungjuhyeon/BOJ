import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int answer = -1;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                if(!(park[i][j].equals("-1"))){
                    continue;
                }
                
                for(int mat : mats){
                    if (i + mat > park.length || j + mat > park[0].length) continue;
                    boolean checked = false;
                    
                    
                    for (int x = i; x < i + mat; x++) {
                        for (int y = j; y < j + mat; y++) {
                            if (!park[x][y].equals("-1")) {
                                checked = true;
                                break;
                            }
                        }
                        if (checked) break;
                    }

                    
                    if (!checked) {
                        answer = Math.max(answer, mat);
                    }
                }
                  
            }
        }
        return answer;
    }
}

