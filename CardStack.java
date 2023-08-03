public class CardStack {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cards1End = 0;
        int cards2End = 0;

        for(String str : goal){
            System.out.println("str = " + str);

            if(cards1End != cards1.length && cards1[cards1End].equals(str)){
                System.out.println("cards1End = " + cards1End);
                cards1End++;
                continue;
            }

            if(cards2End != cards2.length && cards2[cards2End].equals(str)){
                System.out.println("cards2End = " + cards2End);
                cards2End++;
                continue;
            }
            answer = "No";
            break;
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        CardStack cardStack = new CardStack();
        cardStack.solution(cards1, cards2, goal);
    }
}
