class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                for(int k = j+1; k < nums.length; k++)
                {
                    System.out.println(nums[i] + ":" + nums[j] + ":" + nums[k]);                    
                    int sum = nums[i] + nums[j] + nums[k];
                    int check = 0;
                    for(int val = 2; val < sum; val++)
                    {
                        if(sum % val == 0)
                        {
                            check = 1;
                            break;
                        }
                    }
                    
                    if(check == 0)
                    {
                        cnt++;
                    }
                }
            }
        }
        
        answer = cnt;
        return answer;
    }
}