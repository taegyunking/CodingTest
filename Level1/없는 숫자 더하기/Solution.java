import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        Arrays.sort(numbers);
        
        int num_pos = 0;
        int sum = 0;
        for(int i = 0; i < 10; i++)
        {
            if(num_pos >= numbers.length)
            {
                sum += i;
            }
            else
            {
                if(i != numbers[num_pos])
                {
                    sum += i;
                }
                else
                {
                    num_pos++;
                }
            }
        }
        
        answer = sum;
        return answer;
    }
}