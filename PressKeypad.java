import java.util.Arrays;
import java.util.HashMap;

public class PressKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<Integer, Position> hm = new HashMap<>();

        int k = 1;
        LeftHandLocation ls = new LeftHandLocation(0,3);
        RightHandLocation rs = new RightHandLocation(2,3);

        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(i==3 && j==1){
                    hm.put(0, new Position(j,i));
                }else{
                    hm.put(k, new Position(j,i));
                }
                k++;
            }
        }
        for(int i=0; i<numbers.length; i++){

            int diffXForLeft = Math.abs(hm.get(numbers[i]).getX() - ls.getX());
            int diffYForLeft = Math.abs(hm.get(numbers[i]).getY() - ls.getY());

            int diffXForRight = Math.abs(hm.get(numbers[i]).getX() - rs.getX());
            int diffYForRight = Math.abs(hm.get(numbers[i]).getY() - rs.getY());

            //left
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                ls = new LeftHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                answer += "L";

            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){ //right
                rs = new RightHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                answer += "R";
            }else{
                if (diffXForLeft + diffYForLeft < diffXForRight + diffYForRight) {
                    ls = new LeftHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                    answer += "L";
                }
                else if(diffXForLeft + diffYForLeft > diffXForRight + diffYForRight){
                    rs = new RightHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                    answer += "R";
                }else{
                    if(hand.equals("left")){
                        ls = new LeftHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                        answer += "L";
                    }else{
                        rs = new RightHandLocation(hm.get(numbers[i]).getX(), hm.get(numbers[i]).getY());
                        answer += "R";
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        PressKeypad pressKeypad = new PressKeypad();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        pressKeypad.solution(numbers, hand);
    }
}
class Position {
    int x,y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
}
class LeftHandLocation {
    int x,y;

    LeftHandLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}

class RightHandLocation {
    int x,y;

    RightHandLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}