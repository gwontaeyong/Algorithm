package n1_오픈채팅방;

import java.io.IOException;
import java.util.*;

public class Solution {

    Map<String, String> map = new HashMap<>();
    Queue<Log> queue = new LinkedList<>();

    static class Log {
        String action;
        String uid;

        public Log(String action, String uid) {
            this.action = action;
            this.uid = uid;
        }
    }


    public String[] solution(String[] record) {

        int count = 0;

        for (int i = 0; i < record.length; i++) {
            String data[] = record[i].split(" ");

            String action = data[0];
            String uid = data[1];

            queue.add(new Log(action, uid));

            if(action.equals("Enter") || action.equals("Change")){
                map.put(uid, data[2]);

            }
            if(action.equals("Change"))
                continue;
            count++;
        }

        String[] answer = new String[count];
        int index = 0;

        for (int i = 0; i < record.length; i++) {
            String str[] = record[i].split(" ");
            if(str[0].equals("Change"))
                continue;

            String name = map.get(str[1]);
            String action = (str[0].equals("Enter"))?"들어왔습니다.":"나갔습니다.";
            answer[index] = String.format("%s님이 %s", name, action);
            index++;
        }





        return answer;
    }



    public static void main(String[] args) throws IOException {

        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(new Solution().solution(input)));

    }
}
