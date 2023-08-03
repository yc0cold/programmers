public class Painting {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;
        for(int start : section){
            if(start <= end){
                continue;
            }
            end = start + m - 1;

            answer++;
            // 아래 조건은 뺴도 됨
//            if(end >= n){
//                break;
//            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int [] section = {2,3,6};

        Painting p = new Painting();
        p.solution(n, m, section);
    }
}
