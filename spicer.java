import java.sql.Array;
import java.util.*;

public class spicer {

    // tried to use pure Array, but it failed because array leaves a space after removing elements.
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0 ;
        int min = 0;
        int secondMin = 0;
        int mixed = 0;

        int[] newArray = scoville;
        Arrays.sort(scoville);

        if(scoville[0] > K) {
            return 0;
        }

        while(newArray.length - count > 1){
            int[] tempArray = new int[newArray.length - count];

            min = newArray[count];
            secondMin = newArray[count+1];
            mixed = min + secondMin*2;

            tempArray[0] = mixed;
            int k = 1 ;
            for(int i = count+2; i < newArray.length; i++){
                tempArray[k] = newArray[i];
                k+=1;
            }

            Arrays.sort(tempArray);
            newArray = tempArray;
            count += 1;

            if(newArray[1] >= K){
                return count;
            }
        }
        return -1;

    }

    // used ArrayList, but failed.
    public static int solution2(int[] scoville, int K){
        ArrayList <Integer> a = new ArrayList<Integer>();

        int min = 0;
        int secondMin = 0;
        int newElement = 0 ;
        int count = 0;

        for(int i = 0; i < scoville.length; i++){
            a.add(scoville[i]);
        }
        Collections.sort(a);

        while(a.size() > 1){

            ArrayList <Integer> tempList = new ArrayList<>();

            min = a.get(0);
            secondMin = a.get(1);
            newElement = min + secondMin * 2;

            tempList = a;
            System.out.println("tempList = " + tempList);
            if(tempList.get(0) < K){
                tempList.remove(0);
                tempList.remove(0);

                for(int i=0; i<tempList.size(); i++){
                    if(tempList.get(i) < newElement){
                        continue;
                    }else{
                        tempList.add(i,newElement);
                        break;
                    }
                }
                count += 1;

                a = tempList;
                System.out.println("a = " + a);
            }else{
                return count;
            }
        }

        if(a.get(0) < K){
            return -1;
        }else{
            return count;
        }


    }

    // Used Priority Queue and succeeded
    public static int solution3(int scoville[], int K){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int count = 0;

        for(int i = 0 ; i< scoville.length; i++){
            pQueue.add(scoville[i]);
        }

        while(pQueue.size() > 1 && pQueue.peek() < K){
            int newElement = pQueue.poll() + pQueue.poll() * 2;

            pQueue.add(newElement);

            count++;
        }

        if(pQueue.peek() < K){

            return -1;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 9, 10, 12};

        int answer = solution2(arr, 7);
        System.out.println("answer = " + answer);
    }

}

