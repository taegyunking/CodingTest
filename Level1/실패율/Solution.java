import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // stage / user number mapping
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int stage : stages)
        {
            hm.put(stage, hm.getOrDefault(stage, 0) + 1);
        }
        
        // stage / fail percentage mapping
        int stage_user = stages.length;
        HashMap<Integer, Float> fail_m = new HashMap<>();
        for(int i = 1; i <= N; i++)
        {
            float fail_per = 0;
            if(hm.containsKey(i))
            {
                fail_per = (float)hm.get(i) / stage_user;
                stage_user -= hm.get(i);
            }
            
            fail_m.put(i, fail_per);
        }
        
        List<Integer> keySetList = new ArrayList<>(fail_m.keySet());
        ArrayList<Integer> arr = new ArrayList<>();

		Collections.sort(keySetList, (o1, o2) -> (fail_m.get(o2).compareTo(fail_m.get(o1))));

        int[] answer = new int[N];
        int key_cnt = 0;
        for(Integer key : keySetList) {
			answer[key_cnt++] = key;
		}
        
        return answer;
    }
}