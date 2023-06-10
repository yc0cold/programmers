import java.util.Arrays;

public class TriangleSnail {
    public int[] solution(int n) {
        int arrLen = n*(n+1)/2;

        int[][] temp = new int[n][n];
        int block = n; //턴당 최대 움직일 수 있는 횟수
        int x = -1;
        int y = 0;
        int num = 1;

        while(block > 0){
            // down
            for(int i=0; i<block; i++){
                x++;
                temp[x][y] = num++;
            }
            block--;

            // right
            for(int j=0; j<block; j++){
                y++;
                temp[x][y] = num++;
            }
            block--;

            // left
            for(int k=0; k<block; k++){
                x--;
                y--;
                temp[x][y] = num++;
            }
            block--;
        }

        // 2 차원 배열 -> 1차원 배열
        int [] answer = new int[arrLen];
        int count =0 ;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[count++] = temp[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        TriangleSnail ts = new TriangleSnail();

        int[] result = ts.solution(4);
    }
}
