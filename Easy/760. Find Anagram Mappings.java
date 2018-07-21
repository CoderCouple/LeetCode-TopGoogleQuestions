package TopGoogleQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int [] result = new int [A.length];
        Map<Integer,List<Integer>> hmap = new HashMap<Integer,List<Integer>>();

        for(int i=0;i<B.length;i++){
            List<Integer> temp=null;
            if(hmap.containsKey(B[i])){
                temp = hmap.get(B[i]);
                temp.add(i);
            } else {
                temp =new ArrayList<Integer>();
                temp.add(i);
                hmap.put(B[i],temp);

            }
        }

        for(int i=0;i<A.length;i++){
            List<Integer> temp=hmap.get(A[i]);
            result[i]=temp.get(0);
            temp.remove(0);
        }
        return result;
    }
}
