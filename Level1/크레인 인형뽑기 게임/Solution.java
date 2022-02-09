import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int[] doll_pos = new int[board.length];
        for(int i = 0; i < doll_pos.length; i++)
        {
            doll_pos[i] = doll_pos.length;
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                if(board[i][j] != 0)
                {
                    if(doll_pos[j] == doll_pos.length)
                    {
                        doll_pos[j] = i;
                    }
                }
            }        
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int erase_doll_cnt = 0;
        int crane_pos;
        for(int i = 0; i < moves.length; i++)
        {
            crane_pos = moves[i]-1;
            if(doll_pos[crane_pos] != board.length)
            {   
                int doll_line = doll_pos[crane_pos]; 
                doll_pos[crane_pos] += 1;

                if(stack.peek() == board[doll_line][crane_pos])
                {
                    erase_doll_cnt += 2;
                    stack.pop();
                }
                else
                {
                    stack.push(board[doll_line][crane_pos]);    
                }
            }
        }

        int answer = erase_doll_cnt;
        return answer;
    }
}