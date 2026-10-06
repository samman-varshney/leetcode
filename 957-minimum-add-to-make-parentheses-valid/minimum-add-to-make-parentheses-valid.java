class Solution {
    public int minAddToMakeValid(String s) {
        int opening = 0, closing = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')')
                closing++;
            else if(closing == 0){
                opening++;
            }else{
                closing--;
            }
        }

        return opening + closing;
    }
}