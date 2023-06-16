import java.util.HashMap;

public class NumberStringAndEnglishWord {
    public int solution(String s) {
        int answer = 0;
        String [] str = {
                "zero","one","two","three","four","five","six","seven","eight","nine","ten"
        };

        for(int i=0; i<str.length; i++){
            s = s.replace(str[i], Integer.toString(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";

        NumberStringAndEnglishWord n = new NumberStringAndEnglishWord();
        n.solution(s);

    }
}
