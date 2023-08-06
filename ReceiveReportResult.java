import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReceiveReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> temp = new ArrayList<>();

        // 각 user 별 신고 user id 목록
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        // 신고받은 id와 신고 횟수 목록
        HashMap<String, Integer> reportedId = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportedId.put(id_list[i], 0);
        }

        // 2번 이상 신고 된 id 목록
        ArrayList<String> idReportedMoreThan2 = new ArrayList<>();

        // 각 user 별 신고 user id 목록 만들기
        for (int i = 0; i < report.length; i++) {
            String user = report[i].split(" ")[0];
            String reportedUser = report[i].split(" ")[1];
            ArrayList<String> li = new ArrayList<>();
            if(hm.get(user) == null){
                li.add(reportedUser);
            }else{
                li = hm.get(user);
                if(!li.contains(reportedUser)){
                    li.add(reportedUser);
                }
            }
            hm.put(user, li);
        }

        // 신고받은 id와 신고 횟수 목록 만들기
        for(String s : hm.keySet()){
            ArrayList<String> li2 = hm.get(s);
            for (int j = 0; j < li2.size(); j++) {
                reportedId.put(li2.get(j), reportedId.get(li2.get(j)) + 1);
            }
        }

        // 2번이상 신고된 id 목록 만들기
        for (String s : reportedId.keySet()) {
            if(reportedId.get(s) >= k){
                idReportedMoreThan2.add(s);
            }
        }

        // 2번이상 신고된 id를 신고한 user에게 메일을 몇번 보낼지 정하기
       for (int i=0; i< id_list.length; i++) {
            ArrayList<String> a = hm.get(id_list[i]);
            int cnt = 0;
            if(a == null){
                temp.add(cnt);
                continue;
            }
            for (int j = 0; j < a.size(); j++) {
                if (idReportedMoreThan2.contains(a.get(j))) {
                    cnt++;
                }
            }
            temp.add(cnt);
        }

        int[] answer = new int[temp.size()];
        int size=0;
        for(int i : temp){
            answer[size++]=i;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        ReceiveReportResult r = new ReceiveReportResult();
        r.solution(id_list, report, 2);
    }
}
