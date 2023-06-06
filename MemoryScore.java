import java.util.HashMap;
import java.util.Map;

public class MemoryScore {

    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            int score = 0;
            int count = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0; i<name.length; i++){
                map.put(name[i], yearning[i]);
            }
            for(String[] photos : photo){

                score = 0;
                for(String s : photos){
                    if(map.containsKey(s)){
                        score += map.get(s);
                    }
                }
                answer[count] = score;
                count ++;

            }
            return answer;
        }
    }

    public static void main(String [] args){
        String [] name = {"may", "kein", "kain", "radi"};
        int [] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        Solution solution = new Solution();

        int [] result = solution.solution(name, yearning, photo);

    }
}
