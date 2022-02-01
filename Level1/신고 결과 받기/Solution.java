class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[][] userAndReportIdArray = new int[id_list.length][id_list.length];
        int[] stop_report_cnt = new int[id_list.length];
        int[] stop_id = new int[id_list.length];

        int id_list_length = id_list.length;
        int id_report_length = report.length;

        for(int i = 0; i < id_report_length; i++)
        {
            int report_null_index = report[i].indexOf(" ");
            String user_id = report[i].substring(0, report_null_index);
            String report_id = report[i].substring(report_null_index + 1, report[i].length());    

            for(int user_point = 0; user_point < id_list_length; user_point++)
            {
                if(user_id.equals(id_list[user_point]))
                {
                    for(int report_point = 0; report_point < id_list_length; report_point++)
                    {
                        if(report_id.equals(id_list[report_point]))
                        {
                            if(user_point != report_point)
                            {
                                if(userAndReportIdArray[user_point][report_point] == 0)
                                {
                                    userAndReportIdArray[user_point][report_point]++;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        for(int i = 0; i < id_list_length; i++)
        {
            for(int j = 0; j < id_list_length; j++)
            {
                if(userAndReportIdArray[i][j] != 0)
                {
                    stop_report_cnt[j]++;
                }
            }    
        }

        for(int i = 0; i < id_list_length; i++)
        {
            if(stop_report_cnt[i] >= k)
            {
                stop_id[i]++;
            }
        }

        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list_length; i++)
        {
            for(int j = 0; j < id_list_length; j++)
            {
                if(userAndReportIdArray[i][j] != 0 && stop_id[j] != 0)
                {
                    answer[i]++;
                }   
            }
        }

        return answer;
    }
}