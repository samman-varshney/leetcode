
public class Leetcode_1136{
    public static void main(String[] args) {
     
    }
}

class Solution_1136 {
    String exp;
    public boolean solve(boolean b1, boolean b2, char op){
        if(op == '|'){
            return b1|b2;
        }
        return b2&b1;
    }
    public boolean helper(int start, int end){
        if(start==end){
            return exp.charAt(start) == 't';
        }

        char op = exp.charAt(start);
        if(op == '!'){
            return !helper(start+2, end-1);
        }
        boolean prev = op != '|';
        for(int i=start+2; i<end; i++){
            boolean curr;

            if(exp.charAt(i) == '!' ||
            exp.charAt(i) == '|' ||
            exp.charAt(i) == '&'){
                int count = 1;
                int j=i+2;
                while(count !=0){
                    if(exp.charAt(j) == ')')
                        count--;
                    else if(exp.charAt(j) == '(')
                        count++;
                    j++;
                }
                curr = helper(i, j-1);
                i = j-1;
            }else{
                curr = exp.charAt(i) == 't';
            }
            i++;

            prev = solve(prev, curr, op);

        }
        return prev; 
    }
    public boolean parseBoolExpr(String expression) {
        exp = expression;
        int n = exp.length();
        return helper(0, n-1);
    }
}