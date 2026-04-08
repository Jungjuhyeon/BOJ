import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
    
        List<int[]> list = new ArrayList<>();
        for(int[] attack : attacks){
            list.add(attack);
        }
        int time = 1;
        int step = 1;
        int max = health;
        while(health>0){
            if(list.size()==0){
                break;
            }
            int[] attack = list.get(0);
            if(time == attack[0]){
                health -= attack[1];
                step = 1;
                list.remove(0);
            }
            else{
                if(step==bandage[0]){
                    health += (bandage[1] + bandage[2]);
                    step=1;
                }else{
                    step++;
                    health+=bandage[1];
                }
            }
            if(health>max) health = max;
            time++;
        }
        
        if(health>0){
            return health;
        }else{
            return -1;
        }

        
    }
}