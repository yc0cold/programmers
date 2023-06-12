import java.util.Arrays;

public class MakeWeirdString {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split("");
        StringBuffer buffer = new StringBuffer();

        int idx = 0;
        for(int j=0; j<str.length; j++){
            if(str[j].equals(" ")){
                buffer.append(str[j]);
                idx = 0;
            }else{
                if(idx%2 == 0){
                    buffer.append(str[j].toUpperCase());
                }else{
                    buffer.append(str[j].toLowerCase());
                }
                idx ++;
            }
        }
        answer = buffer.toString();
        return answer;
    }

    public static void main(String[] args) {
        MakeWeirdString str = new MakeWeirdString();

        str.solution("try  hello");
    }
}
