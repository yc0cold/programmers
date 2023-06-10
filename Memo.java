// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Memo {
    public int solution(int K, String[] words) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        int space = 0;
        int temp = 0;
        for(int i=0; i<words.length; i++){

            System.out.println("words[i] = " + words[i]);
            temp += words[i].length();

            if(temp+space == K){
                System.out.println("first");
                answer ++;
                temp = 0;
                space = 0;
            }else if(temp+space > K){
                System.out.println("second");
                answer ++;
                i --;
                temp =0;
                space = 0;
            }else{
                System.out.println("third");
                space ++;
            }
        }
        return answer+1;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Memo sol = new Memo();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }
}
