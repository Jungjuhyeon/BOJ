

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> roomList = new ArrayList<>();

        for(int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine()," ");

            Human human = new Human(Integer.parseInt(st.nextToken()),st.nextToken());

            boolean entered = false;

            for(Room room : roomList){
                if(room.list.size() < m){
                    if(room.min<= human.leb && room.max>= human.leb){
                        room.list.add(human);
                        entered = true;
                        break;
                    }
                }
            }

            if(!entered) {
                Room newRoom = new Room(human.leb-10,human.leb+10);
                newRoom.list.add(human);
                roomList.add(newRoom);
            }
        }

        for(Room room : roomList){
            if(room.list.size() ==m){
                sb.append("Started!").append("\n");
            }else{
                sb.append("Waiting!").append("\n");
            }

            room.list.sort(Comparator.comparing(h -> h.name));

            for(Human h : room.list){
                sb.append(h.leb).append(" ").append(h.name).append("\n");
            }
        }

        System.out.println(sb);


    }

    public static class Room{
        int min;
        int max;
        List<Human> list;

        public Room(int min,int max){
            this.min =min;
            this.max = max;
            this.list = new ArrayList<>();
        }
    }

    public static class Human{
        int leb;
        String name;

        public Human(int leb, String name){
            this.leb = leb;
            this.name = name;
        }
    }
}
