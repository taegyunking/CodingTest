class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuffer push_str = new StringBuffer();
        int left_pos_x = 4, left_pos_y = 1;
        int right_pos_x = 4, right_pos_y = 3;        
        int[] nums_pos_x = {4, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        int[] nums_pos_y = {2, 1, 2, 3, 1, 2, 3, 1, 2, 3};
        
        for(int i = 0; i < numbers.length; i++)
        {
            String hand_pos;
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7)                hand_pos = "L";
            else if(num == 3 || num == 6 || num == 9)           hand_pos = "R";
            else
            {   
                int left_d = Math.abs(nums_pos_x[num] - left_pos_x) + Math.abs(nums_pos_y[num] - left_pos_y);
                int right_d = Math.abs(nums_pos_x[num] - right_pos_x) + Math.abs(nums_pos_y[num] - right_pos_y);
                
                if(left_d < right_d)                            hand_pos = "L";
                else if(left_d > right_d)                       hand_pos = "R";
                else
                {
                    if(hand.equals("left"))                     hand_pos = "L";
                    else                                        hand_pos = "R";
                }
            }
            
            if(hand_pos.equals("L"))
            {
                left_pos_x = nums_pos_x[num];
                left_pos_y = nums_pos_y[num];   
                push_str.append("L");
            }
            else
            {
                right_pos_x = nums_pos_x[num];
                right_pos_y = nums_pos_y[num];
                push_str.append("R");
            }
        }
        
        answer = push_str.toString();
        return answer;
    }
}