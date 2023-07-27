import java.util.Arrays;

public class WalkingInThePark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char [][] newPark = new char [park.length][park[0].length()];
        int x = 0;
        int y = 0;
        //시작위치 찾기
        for(int i=0; i<park.length; i++){
            String s = park[i];
            newPark[i] = s.toCharArray();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == 'S'){
                    y = i;
                    x = j;
                    break;
                }
            }
        }

        System.out.println(Arrays.deepToString(newPark));
        for(int i=0; i< routes.length; i++) {
            int tempX = x;
            int tempY = y;

            boolean keepGoing = true;

            String route = routes[i];
            String direction = route.split(" ")[0];

            int count = Integer.parseInt(route.split(" ")[1]);

            System.out.println("route = " + direction + " " + count);

            for(int j = 0 ; j<count; j++){
                if(isItOkayToMove(tempX, tempY, direction, newPark)){
                    if (direction.equals("E")) {
                        tempX += 1;
                    } else if (direction.equals("S")) {
                        tempY += 1;
                    } else if (direction.equals("W")) {
                        tempX -= 1;
                    } else {
                        tempY -= 1;
                    }
                    continue;
                }else{
                    keepGoing = false;
                }
            }
            if(!keepGoing){
                continue;
            }else{
                x = tempX;
                y = tempY;
            }
            System.out.println("x = " + x + ", y = " + y);

        }
        answer[0] = y;
        answer[1] = x;

        return answer;
    }

    boolean isItOkayToMove (int x, int y, String direction, char [][] park){
        if(direction.equals("E")){
            x += 1;
        }else if(direction.equals("S")){
            y += 1;
        }else if(direction.equals("W")){
            x -= 1;
        }else{
            y -= 1;
        }
        if(x >= park[0].length || x < 0 || y >= park.length || y < 0 || park[y][x] == 'X'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String [] park1 = {"SOO","OOO","OOO"};
        String [] route1 = {"E 2","S 2","W 1"};
        String [] park2 = {"OSO","OOO","OXO","OOO"};
        String [] route2 = {"E 2","S 3","W 1"};

        WalkingInThePark w = new WalkingInThePark();
        w.solution(park1,route1);
    }
}

