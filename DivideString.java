public class DivideString {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        char first = s.charAt(0);
        int firstLetterCnt = 1, otherLetterCnt = 0;

        int temp = 1;
        for (int i = 1; i < n; i++) {
            if(s.charAt(temp) == first){
                firstLetterCnt++;
            }else{
                otherLetterCnt++;
            }

            if(i == n-1){
                answer++;
                break;
            }
            if(otherLetterCnt == firstLetterCnt){
                if(s.length() <= temp+1){
                    answer++;
                    break;
                }
                s = s.substring(temp+1);
                answer ++;

                firstLetterCnt = 0;
                otherLetterCnt = 0;
                temp = -1;
                first = s.charAt(0);
            }
            temp++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        DivideString d = new DivideString();
        d.solution(s);
    }
}
