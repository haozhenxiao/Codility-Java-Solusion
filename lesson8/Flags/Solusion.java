// you can also use imports, for example:
import java.util.*;
import java.lang.Boolean;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        
        ArrayList<Boolean> values = new ArrayList<Boolean>();
        int peaks = 0;
        
		//Mark the peaks as true.
        values.add(false);
        for(int i = 1; i < A.length - 1; i++){
            if(A[i] > A[i - 1] && A[i] > A[i + 1]){
                values.add(true);
                peaks++;
            }else
                values.add(false);
        }
        values.add(false);
        
        if(peaks == 0 || peaks == 1)
            return peaks;
            
        int begin = 0;
        int end = peaks;
        int result = 0;
        
		//binary search to try possible number of flags, O(Nlog(N)) complexity.
        while(begin <= end){
            int half = (begin + end) / 2;
            int flags = 0;
            for(int i = 0; i < A.length;){
                if(values.get(i)){
                    i += half;
                    flags++;
                }else{
                    i++;    
                }    
            }
            if(flags < half){
                end = half - 1; 
            }else{
                begin = half + 1;
                result = half;
            }
        }
        
        return result;
    }
}
