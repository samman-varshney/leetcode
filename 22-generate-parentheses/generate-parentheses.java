class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, res, new StringBuilder());
        return res;
    }

    public void helper(int open, int close, List<String> res, StringBuilder s){
        if(open == 0 && close == 0){
            res.add(s.toString());
            return;
        }

        //adding a opening bracket
        if(open > 0){
            s.append('(');
            helper(open-1, close, res, s);
            s.deleteCharAt(s.length()-1);
        }

        //adding a closing bracket
        if(close > open){
            s.append(')');
            helper(open, close-1, res, s);
            s.deleteCharAt(s.length()-1);
        }
    }
}