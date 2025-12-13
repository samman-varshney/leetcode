class Pair implements Comparable<Pair> {
    String code, businessLine;
    public Pair(String code, String businessLine){
        this.code = code;
        this.businessLine = businessLine;
    }

    @Override
    public int compareTo(Pair p){
        if(!this.businessLine.equals(p.businessLine))
            return this.businessLine.compareTo(p.businessLine);
        return this.code.compareTo(p.code);
    }
}
class Solution {
    public boolean isValidCode(String code){
        int n = code.length();
        for(int i=0; i<n; i++){
            char c = code.charAt(i);
            if(!((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') || c=='_'))
                return false;
        }
        return code.length()!=0;
    }
    public boolean isValidBusinessLine(String businessLine){
        String[] valids = {"electronics", "grocery", "pharmacy", "restaurant"};
       
        for(String valid: valids){
            if(valid.equals(businessLine)){
                return true;
            }
        }
        return false;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(isActive[i] && isValidCode(code[i]) && isValidBusinessLine(businessLine[i])){
                pq.add(new Pair(code[i], businessLine[i]));
            }
        }

        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().code);
        }

        return res;
    }
}