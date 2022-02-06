import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 로또 당첨 개수에 따른 순위 Map 생성
        HashMap<Integer, Integer> rank_map = new HashMap<Integer, Integer>() {
            {
                put(6, 1);
                put(5, 2);
                put(4, 3);
                put(3, 4);
                put(2, 5);
                put(1, 6);
                put(0, 6);
            }
        };
        
        ArrayList<Integer> lotto_list = new ArrayList<>();
        ArrayList<Integer> win_nums_list = new ArrayList<>();
        
        // 2. lotto arraylist 생성 (처리를 편하게 하기 위함)
        for(int i = 0; i < lottos.length; i++)
        {
            lotto_list.add(lottos[i]);
            win_nums_list.add(win_nums[i]);
        }

        // 3. 0 개수 구함
        int zero_cnt = Collections.frequency(lotto_list, 0);
        
        // 4. 당첨 개수 구함
        int win_cnt = 0;
        for(int i = 0; i < lottos.length; i++)
        {
            if(win_nums_list.contains(lottos[i]))
            {
                win_cnt++;
            }
        }
        
        // 5. 당첨 개수와 0 개수에 따른 최소, 최대 rank
        int[] answer = new int[2];
        answer[0] = rank_map.get(win_cnt + zero_cnt);
        answer[1] = rank_map.get(win_cnt);
        
        return answer;
    }
}