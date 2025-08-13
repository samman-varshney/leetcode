public class Leetcode_326 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
    public static void main(String[] args) {
        int n = 2000;
        Leetcode_326 q = new Leetcode_326();
        System.out.println(q.isPowerOfThree(n));
    }
}
