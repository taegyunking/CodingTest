import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length()/2; i++)
        {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            StringBuffer strBuf = new StringBuffer();

            for(int j = i; j <= s.length(); j+=i)
            {
                String next = s.substring(j, (j+i > s.length() ? s.length() : j+i));
                if(zipStr.equals(next))
                {
                    zipLevel++;
                }
                else
                {
                    strBuf.append((zipLevel != 1 ? zipLevel : "") + zipStr);
                    zipStr = next;
                    zipLevel = 1;
                }
            }
            strBuf.append(zipStr);

            answer = Math.min(answer, strBuf.length());
        }

        return answer;
    }
}