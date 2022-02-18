import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : scoville)
        {
            pq.add(n);
        }
        
        int answer = 0;
        while(pq.peek() <= K)
        {
            if (pq.size() < 2) {
                return -1;
            }

            int cur = pq.poll();
            int next = pq.poll();
            pq.add(cur + (next * 2));
            answer++;
        }

        return answer;
    }
}