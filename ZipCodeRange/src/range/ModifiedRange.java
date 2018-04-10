package range;

import java.util.Arrays;
import java.util.Comparator;

public class ModifiedRange {
	
	
	int[][] oldRange;
	int[][] newRange;
    boolean[] rangeMerged;
    int newIndex = 0;
    
	public ModifiedRange(int[][] RangesToModify) {
		this.oldRange = RangesToModify;
		
	}
	
	//get the modified range
	 public int[][]  getModifiedRange() {	        

		 	this.newRange = new int[oldRange.length][];
		 	this.sortRange(oldRange);
	        this.rangeMerged = new boolean[oldRange.length];

	        for (int i = 0; i < oldRange.length; i++) {	 
	        	if (rangeMerged[i])
	                continue;
	        	
	            if (i == (oldRange.length - 1) ){
	                newRange[newIndex] = oldRange[i];
	                if(newRange[i] == oldRange[i]) {
	                	break;
	                }else {
	                	oldRange = newRange;
	                	this.newRange = new int[oldRange.length][];
	                	this.rangeMerged = new boolean[oldRange.length];
	                }
	            }	            
	            
	            this.mergeRange(oldRange, 0);
	            newIndex++;
	        }
	        return newRange;
	    }
	 
	 private void mergeRange(int[][] rangeToMerge, int i) {
		  int rangeMin = rangeToMerge[i][0];
          int rangeMax = rangeToMerge[i][1];

          int nextRangeMin = rangeToMerge[i + 1][0];
          int nextRangeMax = rangeToMerge[i + 1][1];

          //check if current range max is greater than next range min
          if (rangeMax >= nextRangeMin) {
        	  
              if (rangeMax >= nextRangeMax)
                  newRange[newIndex] = new int[] { rangeMin, rangeMax };
              else
                  newRange[newIndex] = new int[] { rangeMin, nextRangeMax };

              //keep track of the ranges that are purged from the original list.
              rangeMerged[i+1] = true;

          } else {

              //if there is no overlap, add the current list to the new list
              newRange = oldRange;
          }
	 }

	    //sort the ranges from min to max
	 	private void sortRange(int[][] rangeToSort){

	        Arrays.sort(rangeToSort, new Comparator<int[]>() {

	            @Override
	            public int compare(int[] range1, int[] range2) {

	                int range1Min = range1[0];
	                int range2Min = range2[0];

	                if (range1Min > range2Min)
	                    return 1;

	                if (range1Min < range2Min)
	                    return -1;

	                return 0;
	            }

	        });
	    }

}
