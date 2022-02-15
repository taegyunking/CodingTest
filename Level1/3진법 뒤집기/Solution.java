class Solution {
    public int solution(int n) {        
        int answer = 0;

        int cnt = 0;
        int num = 0;
        while(n > num)
        {
            num += (2 * (int)Math.pow(3, cnt++));
        }

        for(int i = cnt-1; i >= 0; i--)
        {
            int val = 0;
            for(int j = 2; j > 0; j--)
            {
                int cmp = j * (int)Math.pow(3, i);
                if(n >= cmp)
                {
                    n -= cmp;
                    val = j;
                    break;
                }
            }

            answer += val * (int)Math.pow(3, cnt-1-i);
        }

        return answer;
    }
}