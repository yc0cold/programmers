import java.util.ArrayList;

public class ValidParentheses {

    //"{[]}" 이런경우 실패
    public static boolean isValid(String s) {
        String left = "({[";
        String right = ")}]";

        for(int i=0; i<right.length(); i++){
            if(s.charAt(0) == right.charAt(i)) {
                return false;
            }
        }
        int temp = 0;

        for(int i=0; i<s.length()-1; i+=2){
            //left 괄호의 index 찾기, i가 1,3,5 등의 홀수 일 때는 못찾음, temp가 기존꺼 대로 저장
            for(int j=0; j<left.length(); j++){
                if(s.charAt(i) == left.charAt(j)){
                    temp = j;
                    break;
                }
            }
            // right 인덱스와 left 인덱스 비교해서 동일하면 넘어감, 아니면 false
            if(right.indexOf(s.charAt(i+1)) == temp){
                continue;
            }else{
                return false;
            }

        }
        return true;

    }

    //Second Try: Used ArrayList
    public static boolean isValid2(String s) {
        String left = "({[";
        String right = ")}]";
        ArrayList <Integer> a = new ArrayList<>();

        //If the first element belongs to ")}]" => false
        if(!checkLeft(s.charAt(0))){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            // check if the elements belong to "({[", then add an index of the elements to arrayList
            if(checkLeft(s.charAt(i))){
                a.add(left.indexOf(s.charAt(i)));
            }else{  // if not, check if the index of elements equals, then remove the last elements in arrayList
                if(a.size() == 0){return false;}
                if(right.indexOf(s.charAt(i)) == a.get(a.size()-1)){
                    a.remove(a.size()-1);
                    continue;
                }else return false;
            }
        }

        if(a.size() != 0){return false;}
        else {return true;}
    }

    public static boolean checkLeft(Character ch){
        String left = "({[";

        for(int i=0; i<left.length(); i++){
            if(left.charAt(i) == ch){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "{[]}";

        boolean answer = isValid2(s);
        System.out.println("answer = " + answer);
    }

}
