import java.util.*;

class Solution {
    
    public double area(double mid, int[][] squares) {
        double lowerSum = 0, upperSum = 0;
        
        for (int[] square : squares) {
            double y = square[1], l = square[2];
            double top = y + l;
            
            if (top <= mid) { 
                lowerSum += l * l; 
            } else if (y >= mid) {  
                upperSum += l * l; 
            } else {  
               
                double lowerHeight = mid - y;
                double upperHeight = top - mid;

                lowerSum += (lowerHeight * l);
                upperSum += (upperHeight * l);
            }
        }
        
        return upperSum - lowerSum; 
    }
    
    public double separateSquares(int[][] squares) {
        double start = 0, end = 0;
        
        for (int[] square : squares) {
            end = Math.max(end, square[1] + square[2]); 
        }

        double epsilon = 1e-6;  
        double res = 0;
        while (end - start > epsilon) {
            double mid = (start + end) / 2.0;
            double diff = area(mid, squares);
            
            if (Math.abs(diff) < epsilon) {
                res =  mid;
                end  = mid;
            } else if (diff > 0) {
                start = mid; 
            } else {
                end = mid; 
            }
        }
        
        return start;
    }
    

}
