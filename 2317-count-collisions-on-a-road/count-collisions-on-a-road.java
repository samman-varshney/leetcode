class Solution {
    public int countCollisions(String d) {
        int r = 0, s = 0;
        int res = 0;
        for(int i=0; i<d.length(); i++){
            char c = d.charAt(i);
            if(c == 'R'){
                r+=1;
                s = 0;
            }else{
                if(r != 0){
                    res += c=='L'?r+1:r;
                    r = 0;
                    s = 1;
                }else if(s == 1 && c == 'L'){
                    res+=1;
                }else if(c == 'S'){
                    s = 1;
                }
            }
        }
        return res;
    }
}