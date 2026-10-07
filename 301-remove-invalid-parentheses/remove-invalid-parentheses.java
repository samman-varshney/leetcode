class Solution {
    int n;

    public List<String> removeInvalidParentheses(String S) {
        n = S.length();
        int open = 0, close = 0;
        int[] closing = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) != ')' && S.charAt(i) != '(');
            else if (S.charAt(i) == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                close++;
            }

            closing[i + 1] = closing[i] + (S.charAt(i) == ')' ? 1 : 0);
        }
        int ops = open + close;
        //System.out.println(Arrays.toString(closing));
        HashSet<String> res = new HashSet<>();
        helper(0, 0, ops, S, new StringBuilder(), res, closing);

        List<String> ans = new ArrayList<>();
        for (String s : res) {
            ans.add(s);
        }
        return ans;
    }

    public void helper(int i, int diff, int ops, String S, StringBuilder s, HashSet<String> res, int[] closing) {
        if (i == n) {
            res.add(s.toString());
            return;
        }

        //remove
        if ((S.charAt(i) == '(' || S.charAt(i) == ')')
                && (ops - 1 >= 0) && (diff <= closing[n] - closing[i + 1])) {
            helper(i + 1, diff, ops - 1, S, s, res, closing);
        }

        //don't remove
        diff += (S.charAt(i) == ')' ? -1 : S.charAt(i) == '(' ? 1 : 0);

        if (diff >= 0 && diff <= closing[n] - closing[i + 1]) {
            s.append(S.charAt(i));
            helper(i + 1, diff, ops, S, s, res, closing);
            s.deleteCharAt(s.length() - 1);
        }
    }
}