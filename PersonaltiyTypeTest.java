import java.util.HashMap;

public class PersonaltiyTypeTest {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('R', 0);
        hm.put('T', 0);
        hm.put('C', 0);
        hm.put('F', 0);
        hm.put('J', 0);
        hm.put('M', 0);
        hm.put('A', 0);
        hm.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            Character c1 = survey[i].charAt(0);
            Character c2 = survey[i].charAt(1);

            if(choices[i] == 4){
                continue;
            }else if(choices[i] > 4){
                hm.put(c2, hm.get(c2) + choices[i]-4);
            }else{
                hm.put(c1, hm.get(c1) + 4-choices[i]);
            }
        }

        System.out.println("hm = " + hm);

        Character index1 = comparison('R','T', hm);
        Character index2 = comparison('C','F', hm);
        Character index3 = comparison('J','M', hm);
        Character index4 = comparison('A','N', hm);

        answer += index1;
        answer += index2;
        answer += index3;
        answer += index4;

        System.out.println("answer = " + answer);
        return answer;
    }

    Character comparison(Character a, Character b, HashMap<Character, Integer> hm) {
        Character rs = ' ';

        if(hm.get(a) > hm.get(b)){
            rs = a;
        }else if(hm.get(a) < hm.get(b)){
            rs = b;
        }else{
            rs = a < b ? a : b;
        }

        return rs;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        PersonaltiyTypeTest pt = new PersonaltiyTypeTest();
        pt.solution(survey, choices);
    }
}
