public class CaeserCipher {

    public String solution(String s, int n) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        int position = 0;
        for(char c : s.toCharArray()){
            if(c == ' '){
                builder.append(c);
            }else{
                if(Character.toUpperCase(c) == c){
                    position = c - 'A';
                    position = (position + n)%26;
                    System.out.println('A' + position);
                    builder.append((char)(position + 'A'));
                }else{
                    position = c - 'a';
                    position = (position + n)%26;
                    builder.append((char)(position + 'a'));
                }
            }
        }
        System.out.println(16+'A');
        answer = builder.toString();
        return answer;
    }

    public static void main(String[] args) {
        CaeserCipher caeserCipher = new CaeserCipher();

        String answer = caeserCipher.solution("AB", 1);

    }
}
