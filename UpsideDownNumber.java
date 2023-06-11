import java.util.Arrays;

public class UpsideDownNumber {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        String str = String.valueOf(n);
        //String str = Long.toString(n);
        for(int i=0; i< answer.length; i++){
            answer[str.length()-i-1] = str.charAt(i) - '0';
            //answer[str.length()-i-1] = Character.getNumericValue(str.charAt(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        UpsideDownNumber number = new UpsideDownNumber();

        int [] answer = number.solution(12345);

    }
}
