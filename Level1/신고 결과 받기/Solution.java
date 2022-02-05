import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복 제거 Set
        report = new HashSet<>(Arrays.asList(report)).toArray(new String[0]);
        
        // String : 유저 id, Integer : mail 받을 횟수
        // 저장한 순서를 유지하기 위해 LinkedHashMap 사용
        HashMap<String, Integer> idInfo = new LinkedHashMap<>();

        // String : 신고 당한 id, ArrayList<String> : 신고 한 사람 List
		HashMap<String, ArrayList<String>> reportInfo = new HashMap<>();
        
        // 1. idInfo에 id list 저장
        for (int i = 0; i < id_list.length; i++)
        {
            idInfo.put(id_list[i], 0);    
        }
        
        // 2. report 내용을 통해 신고 당한 id와 신고 한 사람 List를 reportInfo에 저장
		for (int i = 0; i < report.length; i++) 
        {
			String[] id = report[i].split(" ");
			String user_id = id[0];
			String target_id = id[1];
            
			if (reportInfo.containsKey(target_id)) 
            { 
                reportInfo.get(target_id).add(user_id);
			} 
            else 
            { 
				ArrayList<String> list = new ArrayList<String>();
				list.add(user_id);
				reportInfo.put(target_id, list);
			}
		}
        
        // 3. reportInfo key 값(신고 당한 id)에 size와 신고 당한 횟수를 비교해서 충족 여부 확인 및 idInfo에 메일 전달 횟수 업데이트
        for (String report_id : reportInfo.keySet())
        {
            // 신고 당한 id의 신고 한 id list 크기는 신고 당한 횟수와 같음
            if(reportInfo.get(report_id).size() >= k)
            {
                // idInfo에 신고 당한 횟수에 만족한 id를 신고한 id list의 메일 전달 횟수 업데이트
                for (String i : reportInfo.get(report_id)) 
                {
					idInfo.put(i, idInfo.getOrDefault(i, 0) + 1);
				}
            }
        }
        
        // 4. return 메일 전달 횟수
        for(int i = 0; i < id_list.length; i++)
        {
            answer[i] = idInfo.get(id_list[i]);    
        }
        return answer;
    }
}