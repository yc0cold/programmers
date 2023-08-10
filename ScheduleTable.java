public class ScheduleTable {

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        if( b - a == 1) return 1;
        while(b-a != 1){
            answer ++;
            if(a%2 == 0){
                a /= 2;
            }else{
                a = (a+1)/2;
            }
            if (b % 2 == 0) {
                b /= 2;
            }else{
                b = (b+1)/2;
            }
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
        answer++;
        return answer;
    }

    public static void main(String[] args) {

        int n = 8;
        int a = 4;
        int b = 7;
        ScheduleTable s = new ScheduleTable();

        s.solution(n,a,b);
    }
}
