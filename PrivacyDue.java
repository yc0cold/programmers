import java.util.Arrays;
import java.util.HashMap;

public class PrivacyDue {
    // 날짜 형식에 얽메이지 않고도 할 수 있다. 다른 사람풀이 참고
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String s : terms) {
            String type = s.split(" ")[0];
            int months = Integer.parseInt(s.split(" ")[1]);
            hm.put(type, months);
        }

        for(int i=0; i< privacies.length; i++){
            String yyMMdd = privacies[i].split(" ")[0];
            String alpha = privacies[i].split(" ")[1];

            int m = hm.get(alpha);
            int y = m/12;
            m = m % 12;

            String[] date = yyMMdd.split("\\.");
            int newYear = Integer.parseInt(date[0]) + y;
            int newMonth = Integer.parseInt(date[1]) + m;
            int newDay = Integer.parseInt(date[2]) - 1;

            if(newMonth > 12){
                newYear++;
                newMonth -= 12;
            }

            if(newDay == 0){
                newDay = 28;
                newMonth--;
            }

            String monthToString = newMonth < 10 ? "0"+String.valueOf(newMonth) : String.valueOf(newMonth);
            String dayToString = newDay < 10 ? "0"+String.valueOf(newDay) : String.valueOf(newDay);

            String newToday = today.split("\\.")[0] + today.split("\\.")[1] + today.split("\\.")[2];
            String newDate = String.valueOf(newYear) + monthToString + dayToString;

            if(Integer.parseInt(newDate) < Integer.parseInt(newToday)){
                int[] temp = Arrays.copyOf(answer, answer.length+1);
                temp[temp.length-1] = i+1;
                answer = temp;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        PrivacyDue pd = new PrivacyDue();
        pd.solution(today, terms, privacies);
    }
}
