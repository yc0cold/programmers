import java.util.Arrays;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];

        if(yellow == 1) return new int[]{3,3};

        for (int i = 1; i <= yellow/2; i++) {
            if(yellow % i == 0){
                if(brown + yellow == (i+2) * (yellow/i + 2)){
                    answer[0] = Math.max((i+2), yellow/i + 2);
                    answer[1] = Math.min((i+2), yellow/i + 2);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        Carpet c = new Carpet();
        c.solution(brown,yellow);
    }
}
