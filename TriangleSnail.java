import java.util.Arrays;

public class TriangleSnail {
    public int[] solution(int n) {
        int [] answer = new int[n*(n+1)/2];
        int [][] arr = new int[n][n];

        int x = 0;
        int y = -1;
        int count = 0;

        while(n > 0){
            //down
            for(int i=0; i<n; i++){
                count++;
                y++;
                arr[y][x] = count;
            }
            n--;

            //right
            for(int j=0; j<n; j++){
                x++;
                count++;
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                arr[y][x] = count;
            }
            n--;

            //up
            for(int k=0; k<n; k++){
                x--;
                y--;
                count++;
                arr[y][x] = count;

            }
            n--;
        }
        int point = 0;
        // 2차원 배열 => 1차원 배열
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<= i; j++){
                if(arr[i][j] != 0){
                    answer[point] = arr[i][j];
                    point ++;
                }
            }
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args){
        TriangleSnail ts = new TriangleSnail();
        int[] result = ts.solution(4);
    }
}
