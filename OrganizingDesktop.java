public class OrganizingDesktop {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;

        for(int i=0; i<wallpaper.length; i++){
            String str = wallpaper[i];
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '#'){
                    if(minX >= j){
                        minX = j;
                    }
                    if(maxX <= j){
                        maxX = j;
                    }

                    if(minY >= i){
                        minY = i;
                    }
                    if(maxY <= i){
                        maxY = i;
                    }
                }
            }
        }
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;

        return answer;
    }

    public static void main(String[] args) {
        String [] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        OrganizingDesktop od = new OrganizingDesktop();
        od.solution(wallpaper);
    }
}
