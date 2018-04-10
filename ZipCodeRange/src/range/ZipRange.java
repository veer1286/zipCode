package range;

import java.awt.List;

public class ZipRange {

    public static void main(String[] args) {

        int[][] Ranges1 = new int[][] {     new int[] { 85101, 85302 },
											new int[] { 85300, 85500 },
											new int[] { 85600, 85640 }
        								};

        ZipRange ZipRange = new ZipRange();
        
        ModifiedRange mr = new ModifiedRange(Ranges1);

        int[][] modifiedRange = mr.getModifiedRange();

        System.out.println("Modified range:");
        ZipRange.print(modifiedRange);


    }
    
    //Print the modified ranges
    private void print(int[][] newRange){

        if(newRange == null || newRange.length <=0)
            throw new IllegalArgumentException("newRange is empty or null");

        for (int i = 0; i < newRange.length; i++) {
            if (newRange[i] != null){   
                System.out.println("["+ newRange[i][0] + ", "
                        + newRange[i][1]+"]");
            }
        }
    }
}