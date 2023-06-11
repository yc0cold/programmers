import java.util.Arrays;

public class CheckSocialDistance {
    private final int [] dx = {0,-1,1,0};
    private final int [] dy = {-1,0,0,1};
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            char[][] room = new char[n][n];

            for(int j=0; j<places[i].length; j++){
                room[j] = places[i][j].toCharArray();
            }
            if(isDistanced(room)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }

        return answer;
    }

    public boolean isDistanced(char [][] room){

        for(int y=0; y<room.length; y++){
            for(int x=0; x<room[y].length; x++){
                if(room[y][x] != 'P') continue;
                if(!isDistanced(x,y,room)) return false;
            }
        }

        return true;
    }

    public boolean isDistanced(int x, int y, char[][] room){
        for(int d=0; d<4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]) {
                case 'P': return false;
                case 'O':
                    if(isSomeoneNextTo(nx,ny,3-d, room)) return false;
                    break;
            }
        }
        return true;
    }

    public boolean isSomeoneNextTo(int x, int y, int exclude, char[][] arr){

        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(d == exclude) continue;

            if(ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[ny].length) continue;

            if(arr[ny][nx] == 'P') return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckSocialDistance csd = new CheckSocialDistance();

        String [][] p = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
            ,{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
            , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
            , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
            , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        csd.solution(p);
    }
}
