import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer, Boolean> lottos_map = new HashMap<>();
        int[] lotto_rank = {6,6,5,4,3,2,1};

        int zero_cnt = 0;
        for(int lotto : lottos)
        {
            if(lotto == 0)
            {
                zero_cnt++;
                continue;
            }
            lottos_map.put(lotto, true);	
        }

        int win_cnt = 0;
        for(int win_lotto : win_nums)
        {
            if(lottos_map.containsKey(win_lotto))
            {
                win_cnt++;
            }
        }

        int max_rank = lotto_rank[zero_cnt + win_cnt];
        int min_rank = lotto_rank[win_cnt];

        int[] answer = {max_rank, min_rank};
        return answer;
    }
}