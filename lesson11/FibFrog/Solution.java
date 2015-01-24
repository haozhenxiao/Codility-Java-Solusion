// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> fbs = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int start = -1;
        int level = 0;
        int prepre = 0;
        int pre = 1;
        HashMap<Integer,Integer> path = new HashMap<Integer,Integer>();
        path.put(start,start);
        fbs.add(pre);
        
        for(int i = 2; i < A.length + 5; i++){
            int newfb = pre + prepre;
            fbs.add(newfb);
            prepre = pre;
            pre = newfb;
            if(newfb >= A.length + 5)
                break;
        }
        
        while(true){
            if(!q.isEmpty()){
                start = q.remove();
                level = path.get(start);
            }
            for(int i = fbs.size() - 1; i >=0; i--){
                if(start + fbs.get(i) == A.length){
                    return level + 1;    
                }else if(start + fbs.get(i) < A.length){
                    if(A[start + fbs.get(i)] == 1 && path.get(start + fbs.get(i)) == null){
                        q.add(start + fbs.get(i));
                        path.put(start + fbs.get(i),level + 1);
                    }
                }
            }
            if(q.isEmpty())
                break;
        }
        
        return -1;
            
    }
}