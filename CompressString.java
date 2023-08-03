public class CompressString {
    public int solution(String s) {
        int answer = 0;
        System.out.println("s.substring(1,2) = " + s.substring(0,3));

        for(int i=1; i<s.length()/2; i++){
            String str = s.substring(0,i);

            for(int j=0; i<str.length(); j++){
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CompressString c = new CompressString();
        c.solution("aabbaccc");
    }
}
