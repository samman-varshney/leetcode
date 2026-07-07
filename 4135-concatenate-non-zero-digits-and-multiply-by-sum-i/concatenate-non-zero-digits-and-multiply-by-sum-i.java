class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        char[] num = (n+"").toCharArray();
        for(char c: num){
            if(c!='0'){
                x = x*10+(c-'0');
                sum += c-'0';
            }
        }
        return x*sum;
    }
}