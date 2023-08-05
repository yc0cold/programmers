public class SmallerSubString {

    public int solution(String t, String p) {
        int answer = 0;

        for(int i=0; i<t.length()-p.length()+1; i++){
            long temp = 0;
            String s = t.substring(i, i + p.length());

            temp = Long.parseLong(s);
            if ((temp <= Long.parseLong(p))) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";

        SmallerSubString ss = new SmallerSubString();
        ss.solution(t, p);
    }
}
