import java.util.Arrays;
import java.util.HashMap;

public class race {
    public static void main(String[] args) {
        String [] players =  {"mumu", "soe", "poe", "kai", "mine"};
        String [] callings = {"kai", "kai", "mine", "mine"};

        Solution2 s = new Solution2();

        String [] answer = s.solution(players, callings);
        System.out.println(Arrays.toString(answer));
        //System.out.println("players = " + players[0]);





    }
}


class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        String temp = "";


        for(String call : callings){
            for(int i=1; i<players.length; i++){
                if(call.equals(players[i])){
                    temp = players[i-1];
                    players[i-1] = players[i];
                    players[i] = temp;
                    System.out.println(Arrays.toString(players));
                    break;
                }
            }
        }

        answer = players;
        return answer;
    }
}


class Solution2 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        String temp = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for(int i=0; i<players.length; i++){
            hm.put(players[i], i);
        }

        for(int i=0; i<callings.length; i++){
            int idx = hm.get(callings[i]);
            String prePlayerNm = players[idx-1];
            players[idx-1] = callings[i];
            players[idx] = prePlayerNm;

            hm.put(callings[i], hm.get(callings[i])-1);
            hm.put(prePlayerNm, hm.get(prePlayerNm)+1);

        }
        answer = players;
        return answer;
    }
}