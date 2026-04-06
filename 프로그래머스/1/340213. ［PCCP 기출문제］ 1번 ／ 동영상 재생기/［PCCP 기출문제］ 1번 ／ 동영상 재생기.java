class Solution {
    public String solution
        (String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] video = video_len.split(":");
        String[] p = pos.split(":");
        String[] op_s = op_start.split(":");
        String[] op_e = op_end.split(":");
        
        int videoT = Integer.parseInt(video[0]+video[1]);
        int opStartT= Integer.parseInt(op_s[0]+op_s[1]);
        int opEndT= Integer.parseInt(op_e[0]+op_e[1]);
        int posH = Integer.parseInt(p[0]);
        int posM = Integer.parseInt(p[1]);
        int posT = posH*100+posM;
        
        for(String command : commands){
            if(posT>=opStartT && posT<=opEndT){
                posT = opEndT;
            }
            if(command.equals("prev")){
                if(posT<=10){
                    posT = 0;
                    continue;
                }
                posH = posT/100;
                posM = posT%100-10;
                if(posM<0){
                    posH--;
                    posM = 60+posM;
                }
                posT = posH*100+posM;
            }else{
                posH = posT/100;
                posM = posT%100+10;
                if(posM>=60){
                    posH++;
                    posM %= 60;
                }
                posT = posH*100+posM;
            }
            if(videoT<posT){
                posT = videoT;
            }
        }
        if(posT>=opStartT && posT<=opEndT){
            posT = opEndT;
        }
        String h = String.format("%02d",posT/100);
        String m = String.format("%02d",posT%100);
        return h+":"+m;

    }
}