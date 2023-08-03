import java.util.Arrays;
import java.util.HashMap;

public class Keypad {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character,Integer> map = new HashMap<>();

        for(String str : keymap){
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, i+1);
                }else{
                    map.put(c, Math.min(map.get(c), i+1));
                }
            }
        }
        int total = 0;
        int count = 0;
        for(String str : targets){
            total = 0;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(!map.containsKey(c)){
                    total = -1;
                    break;
                }else{
                    total += map.get(c);
                }
            }
            answer[count] = total;
            count ++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String [] keymap = {"ABACD","BCEFD"};
        String [] target = {"ABCD","AABB"};

        Keypad keypad = new Keypad();
        keypad.solution(keymap,target);
    }
}
