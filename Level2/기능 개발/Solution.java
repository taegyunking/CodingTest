import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new Queue<Integer>();

        for(int i = 0; i < progresses.length; i++)
        {
            int remainder_per = 100 - progresses[i];
            int day = remainder_per % speeds[i] == 0 ? remainder_per / speeds[i] : remainder_per / speeds[i] + 1;
            queue.add(day);
        }
        
        int cmp_day = queue.poll(0);
        int cmp_cnt = 1;
        for(int i = 1; i < progresses.length; i++)
        {
            int poll_day = queue.poll(i);
            if(poll_day <= cmp_day)
            {
                cmp_cnt++;
            }
            else
            {
                System.out.println(cmp_cnt);
                cmp_day = poll_day;
                cmp_cnt = 1;
            }
        }

        return answer;
    }
}