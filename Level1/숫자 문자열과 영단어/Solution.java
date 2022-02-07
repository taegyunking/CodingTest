import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, String> nums_map = new HashMap<>() {
            {
                put("0", "0");
                put("1", "1");
                put("2", "2");
                put("3", "3");
                put("4", "4");
                put("5", "5");
                put("6", "6");
                put("7", "7");
                put("8", "8");      
                put("9", "9");
                put("zero", "0");
                put("one", "1");
                put("two", "2");
                put("three", "3");
                put("four", "4");
                put("five", "5");
                put("six", "6");
                put("seven", "7");
                put("eight", "8");      
                put("nine", "9");
            }
        };

        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < s.length(); i++)
        {
            if(nums_map.containsKey(s.substring(i, i+1)))
            {
                result.append(nums_map.get(s.substring(i, i+1)));
            }
            else
            {
                sb.append(s.substring(i, i+1));
                String sb_temp = sb.toString();
                if(nums_map.containsKey(sb_temp))
                {
                    result.append(nums_map.get(sb_temp));
                    sb.delete(0, sb.length());
                }
            }
        }

        int answer = Integer.valueOf(result.toString());
        return answer;
    }
}