import javax.lang.model.SourceVersion;

public class CodeBetweenTwo {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(char c : s.toCharArray()){
            int k = index;
            char temp = c;

            while(k > 0){
                k--;
                if(isInString((char) (temp+1), skip)){
                    k++;
                }
                temp++;
                if(temp > 'z') {
                    temp = 'a';
                }
            }
            answer += temp;
        }
        return answer;
    }

    boolean isInString (char ch, String skip){
        if(ch > 'z'){
            ch = 'a';
        }
        for(char c : skip.toCharArray()){
            if(c == ch){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        CodeBetweenTwo codeBetweenTwo = new CodeBetweenTwo();
        codeBetweenTwo.solution(s, skip, index);
        System.out.println("A");
        System.out.println();
    }
}
