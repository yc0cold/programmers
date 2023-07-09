public class MakeHamBurger {
    public int solution(int[][] ingredient, int k, int s) {
        int answer = 0;

        int n = ingredient.length;

        for(int num = 1; num < (1<<n); num++){
            int kSum = 0;
            int sSum = 0;
            for(int idx = 0; idx < n; idx++){
                if((num & (1 << idx)) != 0){
                    kSum += ingredient[idx][0];
                    sSum += ingredient[idx][1];
                }
            }

            if(kSum <= k && sSum >= s){
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        MakeHamBurger burger = new MakeHamBurger();
        int [][] ingredient = {{100,5},{200,20},{100,15}};
        int k = 200;
        int s = 20;
        burger.solution(ingredient,k,s);
    }

}
