import java.util.*;

class Solution {
    public int solution(String s) {
        String[] nums_word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < nums_word.length; i++)
        {
            s = s.replaceAll(nums_word[i], String.valueOf(i));
        }
        
        int answer = Integer.valueOf(s);
        return answer;
    }
}