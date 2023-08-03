import java.util.LinkedList;
import java.util.Queue;

public class RebellionOfComMaeng {
    public int solution(int n, int[][] connect) {
        int answer = 1;

        int adj [][] = new int[101][101];
        int visited [] = new int [101];

        Queue queue = new LinkedList();
        queue.offer(1);
        visited[1] = 1;

        for(int i=0; i<connect.length; i++){
            adj[connect[i][0]][connect[i][1]] = 1;
            adj[connect[i][1]][connect[i][0]] = 1;

        }

        while(!queue.isEmpty()){
            int temp = (int) queue.poll();

            for(int i=1; i<=n; i++){
                if(adj[temp][i] == 1 && visited[i] == 0){
                    queue.offer(i);
                    visited[i] = 1;
                    answer ++;

                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int [][] connect = {{1,2}, {3,2}, {4,5}};
        RebellionOfComMaeng re = new RebellionOfComMaeng();
        re.solution(n, connect);
    }

}