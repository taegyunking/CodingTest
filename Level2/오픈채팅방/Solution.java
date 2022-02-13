import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> user_map = new HashMap<>();
        ArrayList<String> cmd_list = new ArrayList<>();
        ArrayList<String> id_list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++)
        {
            int cmd_idx = record[i].indexOf(" ");
            String cmd_str = record[i].substring(0, cmd_idx);
            int user_idx = record[i].indexOf(" ",cmd_idx+1);
            String user_str = cmd_str.equals("Leave") ? record[i].substring(cmd_idx+1, record[i].length()) : record[i].substring(cmd_idx+1, user_idx);

            if(!cmd_str.equals("Leave"))
            {
                String name_str = record[i].substring(user_idx+1, record[i].length());
                user_map.put(user_str, name_str);   
            }

            if(!cmd_str.equals("Change"))
            {
                cmd_list.add(cmd_str);
                id_list.add(user_str);
            }
        }
        
        String[] answer = new String[cmd_list.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = (cmd_list.get(i).equals("Enter")) ? user_map.get(id_list.get(i)) + "님이 들어왔습니다." : user_map.get(id_list.get(i)) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}